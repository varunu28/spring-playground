# Redis Lua Demo

## Goal
Use Lua script to do the following operations in Redis atomically
 - Decrement a counter
 - Insert an entry in sorted set

## Testing
The implementation is tested using the following Go script
```
package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"io"
	"net/http"
	"strconv"
	"sync"
)

func main() {
	numRequests := 100
	var wg sync.WaitGroup
	url := "http://localhost:8080/api/v1/lua"

	// Channel to signal all goroutines to start simultaneously
	startSignal := make(chan struct{})

	// Channel to collect results
	results := make(chan string, numRequests)

	for i := 0; i < numRequests; i++ {
		wg.Add(1)
		go func(requestID int) {
			defer wg.Done()

			<-startSignal // Wait for the signal to start
			data := map[string]string{"userId": "user" + strconv.Itoa(i), "count": "1"}
			jsonData, _ := json.Marshal(data)

			resp, err := http.Post(url, "application/json", bytes.NewBuffer(jsonData))
			if err != nil {
				fmt.Printf("Error: %v\n", err)
			}
			defer resp.Body.Close()
			body, err := io.ReadAll(resp.Body)
			if err != nil {
				fmt.Printf("Error reading body: %v\n", err)
			}
			result := fmt.Sprintf("Request %d - Status: %d, Response: %s",
				requestID, resp.StatusCode, string(body))
			results <- result
		}(i)
	}

	fmt.Println("Starting all requests...")
	close(startSignal) // Signal all goroutines to start

	wg.Wait()
	close(results)
	for result := range results {
		fmt.Println(result)
	}
}
```
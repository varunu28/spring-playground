# K8S Demo

This is a simple demo to show how to deploy a simple web application to a Kubernetes cluster.

## How to run?
Build the JAR file
```bash
    mvn clean package
```
Create Kubernetes POD
```bash
    kubectl apply -f kubernetes/spring-app-pod.yaml
```
Create Kubernetes Service
```bash
    kubectl apply -f kubernetes/spring-app-service.yaml
```
Access the application
```bash
    minikube service spring-app-service
```
Service API is available at `http://<minikube-ip>:<node-port>/api/v1/books`

API docs are available at `http://<minikube-ip>:<node-port>/swagger-ui/index.html`
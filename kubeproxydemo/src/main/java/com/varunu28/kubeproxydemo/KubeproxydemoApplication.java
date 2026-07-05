package com.varunu28.kubeproxydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class KubeproxydemoApplication {

	static void main(String[] args) {
		SpringApplication.run(KubeproxydemoApplication.class, args);
	}

}

@RequestMapping("/api/v1/echo")
@RestController
class EchoController {

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public String echo() {
		return "Hello World";
	}
}

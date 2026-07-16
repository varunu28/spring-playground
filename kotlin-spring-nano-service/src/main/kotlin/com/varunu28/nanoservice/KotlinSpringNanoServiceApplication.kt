package com.varunu28.nanoservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringNanoServiceApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringNanoServiceApplication>(*args)
}

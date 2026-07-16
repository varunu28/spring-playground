package com.varunu28.kotlin_spring_nano_service

import com.varunu28.nanoservice.KotlinSpringNanoServiceApplication
import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<KotlinSpringNanoServiceApplication>().with(TestcontainersConfiguration::class).run(*args)
}

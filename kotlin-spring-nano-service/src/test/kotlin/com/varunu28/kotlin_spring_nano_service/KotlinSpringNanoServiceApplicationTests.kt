package com.varunu28.kotlin_spring_nano_service

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@Import(TestcontainersConfiguration::class)
@SpringBootTest
class KotlinSpringNanoServiceApplicationTests {

	@Test
	fun contextLoads() {
	}

}

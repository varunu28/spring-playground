plugins {
	java
	id("org.springframework.boot") version "4.0.6"
	id("io.spring.dependency-management") version "1.1.7"
	kotlin("jvm")
	kotlin("plugin.power-assert") version "2.3.21"
}

group = "com.varunu28"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webmvc")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testImplementation("io.kotest:kotest-assertions-core:6.1.11")
	implementation(kotlin("stdlib-jdk8"))
}


tasks.withType<Test> {
	useJUnitPlatform()
}

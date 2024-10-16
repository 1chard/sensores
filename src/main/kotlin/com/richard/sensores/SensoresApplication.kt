package com.richard.sensores

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SensoresApplication

fun main(args: Array<String>) {
    SpringApplication.run(SensoresApplication::class.java, *args)
}

package edu.mfvp.avengers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinAvengersApiApplication

fun main(args: Array<String>) {
    runApplication<KotlinAvengersApiApplication>(*args)
}

package ch.keepcalm.cloud.springopenshift

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringOpenshiftApplication

fun main(args: Array<String>) {
    runApplication<SpringOpenshiftApplication>(*args)
}

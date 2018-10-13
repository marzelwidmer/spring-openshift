package ch.keepcalm.cloud.springopenshift

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.hateoas.ResourceSupport
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@SpringBootApplication
class SpringOpenshiftApplication

fun main(args: Array<String>) {
    runApplication<SpringOpenshiftApplication>(*args)
}


@RestController
class IndexController {

    @GetMapping(value = ["/"])
    fun getApiIndex() : ResourceSupport {
        return ResourceSupport().apply {
            add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(PersonController::class.java).getAllPersons()).withRel("get-all-persons"))
            add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(IndexController::class.java).getApiIndex()).withSelfRel())
        }
    }
}


@RestController
class PersonController() {

    var personList = mutableListOf<Person>(Person(id = "12345678-1234-1234-1234-12345678", name = "Foo", age = 32))

    @GetMapping(value = ["/api/persons"])
    fun getAllPersons(): List<Person> {
        return personList
    }

    // http GET :{port}/api/persons/12345678-1234-1234-1234-12345678
    @GetMapping(value = ["/api/persons/{id}"])
    fun getPerson(@PathVariable id: String): Person {
        return personList.first { it.id == id }
    }

    //  http POST :{port}/api/persons/ name="Marcel" age:=43
    @PostMapping(value = ["/api/persons/"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun postPerson(@RequestBody @Valid person: Person) {
        personList.add(person)
    }
}

class Person(var id: String = UUID.randomUUID().toString(),
                  var name: String,
                  var age: Int)

package uk.co.jamesmcnee.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import uk.co.jamesmcnee.controller.model.HelloResponse;

@Controller("/api/hello")
public class HelloWorldController {

    @Get(uri = "/{recipient}", produces = "application/json")
    public HelloResponse hello(@PathVariable("recipient") String recipient) {
        return new HelloResponse("Hello", recipient);
    }

}

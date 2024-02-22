package controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import service.HelloWorldService;

@Controller("/hello")
public class HelloWorldController {

    @Inject
    private HelloWorldService helloWorldService;

    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return helloWorldService.helloFromService();
    }
}

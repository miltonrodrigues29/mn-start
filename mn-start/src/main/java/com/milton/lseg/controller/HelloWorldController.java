package com.milton.lseg.controller;

import com.milton.lseg.service.HelloWorldTranslationConfig;
import io.micronaut.context.annotation.Property;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.milton.lseg.service.HelloWorldService;

@Controller("/hello")
public class HelloWorldController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);
    private final HelloWorldService helloWorldService;
    private final String helloFromConfig;
    private final HelloWorldTranslationConfig translationConfig;
    public HelloWorldController(HelloWorldService service, @Property(name = "hello.world.message") String helloFromConfig, HelloWorldTranslationConfig translationConfig) {
        this.helloWorldService = service;
        this.helloFromConfig = helloFromConfig;
        this.translationConfig = translationConfig;
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld() {
        LOG.debug("Called the hello world API");
        return helloWorldService.helloFromService();
    }

    @Get(uri = "/config", produces = MediaType.TEXT_PLAIN)
    public String helloConfig() {
        LOG.debug("Return Hello From Config Message: {}", helloFromConfig);
        return helloFromConfig;
    }

    @Get(uri = "/config/translation", produces = MediaType.TEXT_PLAIN)
    public String helloConfigTranslation() {
        LOG.debug("Return Hello From Translation Message: {}", translationConfig.getDe());
        return translationConfig.getDe();
    }
}

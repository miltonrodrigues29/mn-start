package com.milton.lseg.service;

import io.micronaut.context.annotation.ConfigurationProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;

@ConfigurationProperties("hello.world.translation")
public interface HelloWorldTranslationConfig {

    @NotBlank
    String getDe();

    @NotBlank
    String getEn();
}

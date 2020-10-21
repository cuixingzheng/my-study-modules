package com.springcloud2020.stream.provider.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomSource {

    String CUSTOM_OUTPUT="custom_output";

    @Output(CUSTOM_OUTPUT)
    MessageChannel output();

}

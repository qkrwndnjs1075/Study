package com.example.feignclient.infrustrate.feign.infrustructure;

import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetryConfiguration {

    @Bean
    public ErrorDecoder errorDecoder(){
        return new Custom5xxErrorDecoder();
    }

    @Bean
    public Retryer retryer(){
        return new Custom5xxRetryer();
    }

}

package com.crsardar.handson.spring.webflux.helloworld;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

@RestController
public class HelloWorldRestController {

    @GetMapping("/hello-world")
    public Mono<String> helloWorld(){

        return Mono.just("Hello World!");
    }

    @GetMapping(value = "hello-world-loop", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> helloWorldLoop(){

        return Flux.fromStream(Stream.generate(()-> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello World";
        }));
    }
}

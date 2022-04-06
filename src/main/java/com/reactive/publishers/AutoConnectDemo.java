package com.reactive.publishers;

import com.reactive.util.Commons;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class AutoConnectDemo {

    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(AutoConnectDemo::getMovie).
                delayElements(Duration.ofSeconds(1))
                .publish()
                .autoConnect(0);

        Commons.sleepSeconds(3);
        System.out.println("Sam is about to join");
        movieStream.subscribe(Commons.subscriber("sam"));
        Commons.sleepSeconds(3);
        System.out.println("Mike is about to join");
        movieStream.subscribe(Commons.subscriber("mike"));
        Commons.sleepSeconds(10);


    }

    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming req");
        return Stream.of("Scene 1", "Scene 2", "Scene 3", "Scene 4", "Scene 5", "Scene 6", "Scene 7");
    }
}
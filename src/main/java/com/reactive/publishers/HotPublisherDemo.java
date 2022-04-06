package com.reactive.publishers;

import com.reactive.util.Commons;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class HotPublisherDemo {

    public static void main(String[] args) {
        Flux<String> movieStream = Flux
                .fromStream(HotPublisherDemo::getMovie)
                .delayElements(Duration.ofSeconds(2))
                .share();

        movieStream.subscribe(Commons.subscriber("sam"));

        Commons.sleepSeconds(5);

        movieStream.subscribe(Commons.subscriber("mike"));


        Commons.sleepSeconds(60);


    }

    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming req");
        return Stream.of("Scene 1", "Scene 2", "Scene 3", "Scene 4", "Scene 5", "Scene 6", "Scene 7");
    }
}
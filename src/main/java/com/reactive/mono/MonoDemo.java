package com.reactive.mono;

import reactor.core.publisher.Mono;

public class MonoDemo {

    public static void main(String[] args) {

        // publisher
        Mono<Integer> mono = Mono.just(1);
        System.out.println(mono);

        //subscriber
        mono.subscribe(i-> System.out.println("Received : "+i));
    }
}

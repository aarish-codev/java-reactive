package com.reactive.mono;

import reactor.core.publisher.Mono;

public class MonoDemo {

    public static void main(String[] args) {

        // publisher
        Mono<Integer> mono = Mono.just(1);
        System.out.println(mono);
        System.out.println("-------------------------------------------");

        //subscriber
        mono.subscribe(i-> System.out.println("Received : "+i));
        System.out.println("-------------------------------------------");

        //subscriber with error
        mono.subscribe(
                item-> System.out.println("Received : "+item),
                err -> System.out.println(err.getMessage()),
                ()-> System.out.println("Completed" )
        );
        System.out.println("-------------------------------------------");

        //noinspection divzero
        Mono<Integer> integerMono = Mono.just("ball")
                .map(String::length)
                .map(l-> l/0);

        //subscriber with onError and runnable
        integerMono.subscribe(
                item-> System.out.println("Received : "+item),
                System.out::println,
                ()-> System.out.println("Completed" )
        );
    }
}

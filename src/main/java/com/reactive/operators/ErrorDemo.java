package com.reactive.operators;

import com.reactive.util.Commons;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ErrorDemo {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
                .subscribe(Commons.subscriber());

        Commons.seperator();

        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
                .onErrorReturn(-1)
                .subscribe(Commons.subscriber());

        Mono<Integer> fallbackValue = Mono.fromSupplier(() -> Commons.faker().random().nextInt(100, 200));

        Commons.seperator();

        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
                .onErrorResume(throwable -> fallbackValue)
                .subscribe(Commons.subscriber());

        Commons.seperator();

        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
                .onErrorContinue((err, obj) -> {
                    System.out.println("Error occurred for: " + obj);
                })
                .subscribe(Commons.subscriber());
    }
}
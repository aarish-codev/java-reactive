package com.reactive.mono;

import com.reactive.util.Commons;
import reactor.core.publisher.Mono;

public class MonoFromSupplier {

    public static void main(String[] args) {

        // use only when you have data
        Mono<String> mono = Mono.just(getName());
        System.out.println("--------------------------------");

        Mono<String> fromSupplier = Mono.fromSupplier(MonoFromSupplier::getName);
        // nothing happens until subscribes
        fromSupplier.subscribe(
                Commons.onNext(),
                Commons.onError(),
                Commons.onComplete()
        );
    }

    public static String getName(){
        System.out.println("Generating name....");
        return Commons.faker().name().fullName();
    }
}

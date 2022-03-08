package com.reactive.mono;

import com.reactive.util.Commons;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;

public class MonoFromCallable {

    public static void main(String[] args) {

        // use only when you have data
        Mono<String> mono = Mono.just(getName());
        System.out.println("--------------------------------");

        Callable<String> stringCallable = MonoFromCallable::getName;
        Mono.fromCallable(stringCallable).subscribe(
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

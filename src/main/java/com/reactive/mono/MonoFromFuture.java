package com.reactive.mono;

import com.reactive.util.Commons;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class MonoFromFuture {

    public static void main(String[] args) {
        Mono.fromFuture(getName())
                .subscribe(Commons.onNext());
        Commons.sleepSeconds(1);
    }

    private static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(()-> Commons.faker().name().fullName());
    }
}

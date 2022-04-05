package com.reactive.operators;

import com.reactive.util.Commons;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class TransformDemo {

    public static void main(String[] args) {
        getFirst10Numbers()
                .transform(transformNumbers())
                .subscribe(Commons.subscriber());
    }

    private static Flux<Integer> getFirst10Numbers() {
        return Flux.range(1, 10);
    }

    private static Function<Flux<Integer>, Flux<Integer>> transformNumbers() {
        return item -> item
                .filter(i -> i > 5)
                .map(i -> i * i);
    }
}
package com.reactive.operators;

import com.reactive.util.Commons;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class TimeoutDemo {

    public static void main(String[] args) {
        getNumbersFlux()
                .timeout(Duration.ofSeconds(1))
                .subscribe(Commons.subscriber());
        Commons.sleepSeconds(2);
        Commons.seperator();

        getNumbersFlux()
                .timeout(Duration.ofSeconds(1), fallbackNumbers())
                .subscribe(Commons.subscriber());

        Commons.sleepSeconds(30);
    }

    private static Flux<Integer> getNumbersFlux() {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(2));
    }

    private static Flux<Integer> fallbackNumbers() {
        return Flux.range(100, 10)
                .delayElements(Duration.ofSeconds(2));
    }
}
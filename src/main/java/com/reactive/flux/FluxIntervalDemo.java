package com.reactive.flux;

import com.reactive.util.Commons;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxIntervalDemo {

    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Commons.onNext());
        Commons.sleepSeconds(5);
    }
}

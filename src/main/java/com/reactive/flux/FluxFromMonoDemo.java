package com.reactive.flux;

import com.reactive.util.Commons;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxFromMonoDemo {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("a");
        Flux<String> flux = Flux.from(mono);
        flux.subscribe(Commons.onNext());
    }
}

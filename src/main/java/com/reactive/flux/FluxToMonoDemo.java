package com.reactive.flux;

import com.reactive.util.Commons;
import reactor.core.publisher.Flux;

public class FluxToMonoDemo {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .filter(i -> i > 3)
                .next()             // gives mono from flux
                .subscribe(Commons.onNext(), Commons.onError(), Commons.onComplete());
    }
}

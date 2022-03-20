package com.reactive.operators;

import com.reactive.util.Commons;
import reactor.core.publisher.Flux;

public class LimitRateDemo {

    public static void main(String[] args) {
        Flux.range(1, 100)
                .log()
                .limitRate(10)      // 75%
                .subscribe(Commons.subscriber());

        Commons.seperator();

        Flux.range(1, 100)
                .log()
                .limitRate(30, 20)
                .subscribe(Commons.subscriber());
    }
}

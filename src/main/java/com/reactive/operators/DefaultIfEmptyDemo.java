package com.reactive.operators;

import com.reactive.util.Commons;
import reactor.core.publisher.Flux;

public class DefaultIfEmptyDemo {

    public static void main(String[] args) {

        getOrderNumbers()
                .filter(i -> i > 10)
                .defaultIfEmpty(-1)
                .subscribe(Commons.subscriber());
//        Will print -1 as there are no values
        Commons.seperator();

        getOrderNumbers()
                .filter(i -> i > 5)
                .defaultIfEmpty(-1)
                .subscribe(Commons.subscriber());
//        Will return 6 to 10 but not default value i.e. -1
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10);
    }
}
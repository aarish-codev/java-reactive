package com.reactive.operators;

import com.reactive.util.Commons;
import reactor.core.publisher.Flux;

public class SwitchIfEmptyDemo {

    public static void main(String[] args) {

        getFirst10Numbers()
                .filter(i -> i > 10)
                .switchIfEmpty(getNext10Numbers())
                .subscribe(Commons.subscriber());
//        Will switch to other Flux as there are no results produced
        Commons.seperator();

        getFirst10Numbers()
                .filter(i -> i > 5)
                .switchIfEmpty(getNext10Numbers())
                .subscribe(Commons.subscriber());
//        Will only produce the valid items from 1st flux
    }

    private static Flux<Integer> getFirst10Numbers() {
        return Flux.range(1, 10);
    }

    private static Flux<Integer> getNext10Numbers() {
        return Flux.range(11, 10);
    }
}
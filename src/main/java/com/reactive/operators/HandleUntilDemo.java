package com.reactive.operators;

import com.reactive.util.Commons;
import reactor.core.publisher.Flux;

public class HandleUntilDemo {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> synchronousSink.next(Commons.faker().country().name()))
                .map(Object::toString)
                .handle((s, synchronousSink) -> {
                    synchronousSink.next(s);
                    if("canada".equalsIgnoreCase(s))
                        synchronousSink.complete();
                }).subscribe(Commons.subscriber());
    }
}

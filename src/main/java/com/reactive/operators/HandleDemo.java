package com.reactive.operators;

import com.reactive.util.Commons;
import reactor.core.publisher.Flux;

public class HandleDemo {

    /* handle = filter + map; */

    public static void main(String[] args) {

        Flux.range(1,10)
                .handle((integer, synchronousSink) -> synchronousSink.next(integer))      // map
                .subscribe(Commons.subscriber());

        Commons.seperator();

        Flux.range(1,10)
                .handle((integer, synchronousSink) -> {
                    if(integer%2==0)                    // filter
                        synchronousSink.next(integer);
                })
                .subscribe(Commons.subscriber());

        Commons.seperator();

        Flux.range(1,10)
                .handle((integer, synchronousSink) -> {
                    if(integer==7)                    // filter
                        synchronousSink.complete();
                    else
                        synchronousSink.next(integer);
                })
                .subscribe(Commons.subscriber());
    }
}

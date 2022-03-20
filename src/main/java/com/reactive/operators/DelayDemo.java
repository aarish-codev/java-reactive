package com.reactive.operators;

import com.reactive.util.Commons;
import reactor.core.publisher.Flux;
import reactor.util.concurrent.Queues;

import java.time.Duration;

public class DelayDemo {

    public static void main(String[] args) {
        System.out.println(Queues.XS_BUFFER_SIZE);  // 32 is default , 8 is minimum
        System.setProperty("reactor.bufferSize.x", "10");

        Flux.range(1, 100)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Commons.subscriber());

        Commons.sleepSeconds(100);
    }
}
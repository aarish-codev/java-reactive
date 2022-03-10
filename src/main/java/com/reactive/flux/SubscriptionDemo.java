package com.reactive.flux;

import com.reactive.util.Commons;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;


public class SubscriptionDemo {

    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();

        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(org.reactivestreams.Subscription subscription) {
                        System.out.println("Received subscription: " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Error: " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Complete");
                    }
                });

        Commons.sleepSeconds(3);
        atomicReference.get().request(3);
        Commons.sleepSeconds(3);
        atomicReference.get().request(3);
        System.out.println("Cancelling");
        atomicReference.get().cancel();
        Commons.sleepSeconds(5);

        atomicReference.get().request(4);
    }
}

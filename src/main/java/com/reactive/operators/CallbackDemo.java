package com.reactive.operators;

import com.reactive.util.Commons;
import reactor.core.publisher.Flux;

public class CallbackDemo {

    public static void main(String[] args) {
        Flux.create(
                        fluxSink -> {
                            System.out.println("inside sink");
                            for (int i = 0; i < 5; i++) {
                                fluxSink.next(i);
                            }
                            fluxSink.complete();
                            System.out.println("sink completed");
                        })
                .doOnComplete(() -> System.out.println("doOnComplete()"))
                .doFirst(() -> System.out.println("doFirst() 1"))
                .doFirst(() -> System.out.println("doFirst() 2"))
                .doOnNext(o -> System.out.println("doOnNext() 1: " + o))
                .doOnSubscribe(subscription -> System.out.println("doOnSubscribe() 1: " + subscription))
                .doOnRequest(value -> System.out.println("doOnRequest(): " + value))
                .doFinally(signalType -> System.out.println("doFinally: 1 " + signalType))
                .doOnError(throwable -> System.out.println("doOnError(): " + throwable.getMessage()))
                .doOnEach(objectSignal -> System.out.println("doOnEach(): " + objectSignal.getType().toString()))
                .doOnCancel(() -> System.out.println("doOnCancel()"))
                .doOnDiscard(CallbackDemo.class, callbackDemo -> System.out.println("doOnDiscard(): " + callbackDemo))
                .doOnTerminate(() -> System.out.println("doOnTerminate()"))
                .doOnSubscribe(subscription -> System.out.println("doOnSubscribe() 2: " + subscription))
                .doOnNext(o -> System.out.println("doOnNext() 2: " + o))
                .doFinally(signalType -> System.out.println("doFinally: 2 " + signalType))
                .doFirst(() -> System.out.println("doFirst() 3"))
//                .take(2)
                .doFinally(signalType -> System.out.println("doFinally: 3 " + signalType))
                .subscribe(Commons.subscriber());

    }
}

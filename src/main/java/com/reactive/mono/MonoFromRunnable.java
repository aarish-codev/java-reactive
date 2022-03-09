package com.reactive.mono;

import com.reactive.util.Commons;
import reactor.core.publisher.Mono;

public class MonoFromRunnable {

    public static void main(String[] args) {

        Runnable runnable = ()-> System.out.println("Runnable");

        Mono.fromRunnable(runnable)
                .subscribe(Commons.onNext());
        System.out.println("-------------------------------------");
        Mono.fromRunnable(timeTakingProcess())
                .subscribe(Commons.onNext(),
                        Commons.onError(),
                        ()-> System.out.println("Process done, sending email now.."));
    }

    private static Runnable timeTakingProcess(){
        return ()-> {
            Commons.sleepSeconds(3);
            System.out.println("Job Completed");
        };
    }
}

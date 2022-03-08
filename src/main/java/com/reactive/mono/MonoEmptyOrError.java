package com.reactive.mono;

import com.reactive.util.Commons;
import reactor.core.publisher.Mono;

public class MonoEmptyOrError {

    public static void main(String[] args) {
        userRepository(1)
                .subscribe(
                        Commons.onNext(),
                        Commons.onError(),
                        Commons.onComplete()
                );

        userRepository(2)
                .subscribe(
                        Commons.onNext(),
                        Commons.onError(),
                        Commons.onComplete()
                );

        userRepository(3)
                .subscribe(
                        Commons.onNext(),
                        Commons.onError(),
                        Commons.onComplete()
                );
    }

    private static Mono<String> userRepository(int userId){

        if(userId==1){
            return Mono.just(Commons.faker().name().firstName());
        }else  if(userId==2)
            return Mono.empty();    // null
        else
            return Mono.error(new RuntimeException("Not found"));

    }
}

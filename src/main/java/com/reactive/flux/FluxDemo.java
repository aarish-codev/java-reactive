package com.reactive.flux;

import com.reactive.util.Commons;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FluxDemo {
    public static void main(String[] args) {
        // Method 1
        System.out.println(Flux.just("a", "b")
                .subscribe(Commons.onNext()));

        // Method 2
        System.out.println(Flux.range(1, 10)
                .subscribe(Commons.onNext()));

        // Method 3
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        System.out.println(Flux.fromStream(integerStream)
                .subscribe(Commons.onNext())
        );

        // Method 4
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println(Flux.fromIterable(integerList).subscribe(Commons.onNext())
        );
    }


}

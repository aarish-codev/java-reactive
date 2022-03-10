package com.reactive.flux;

import com.reactive.util.Commons;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class ListVsFlux {

    public static void main(String[] args) {
        System.out.println("Printing names from List: " + getNames(5));
        System.out.println("Printing names from Flux: ");
        System.out.println(getFluxNames(5)
                .subscribe(Commons.onNext()));
    }

    public static List<String> getNames(int count) {
        List<String> namesList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            namesList.add(Commons.faker().name().fullName());
        }
        return namesList;
    }

    private static String getNames() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Commons.faker().name().fullName();
    }

    public static Flux<String> getFluxNames(int count) {
        return Flux.range(0, count)
                .map(i -> getNames());

    }
}

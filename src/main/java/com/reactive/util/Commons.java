package com.reactive.util;

import com.github.javafaker.Faker;

import java.util.function.Consumer;

public class Commons {

    public static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext(){
        return o-> System.out.println("Received: "+o);
    }

    public static Consumer<Throwable> onError(){
        return e-> System.out.println("Error: "+e.getMessage());
    }

    public static Runnable onComplete(){
        return ()-> System.out.println("Completed");
    }

    public static Faker faker(){
        return FAKER;
    }
}

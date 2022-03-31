package com.ibs.reactive.mono;

import reactor.core.publisher.Mono;

public class Lazy {
    public static void main(String[] args) {
        String res = getValueEager();
        System.out.println(res);
        Mono<String> response = getValueLazy();
//        System.out.println(response);
        //values to be emitted after subscription
        try {
            Thread.sleep(10000);
            System.out.println("After delay");
            response.subscribe(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static Mono<String> getValueLazy() {
        return Mono.just("Hello Lazy!");
    }

    private static String getValueEager() {
        return "Hello Eager";
    }
}

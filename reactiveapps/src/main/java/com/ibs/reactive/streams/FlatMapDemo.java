package com.ibs.reactive.streams;

import reactor.core.publisher.Flux;

public class FlatMapDemo {
    public static void main(String[] args) {
        Flux.range(1, 10).flatMap(i -> {
            // return Flux.just("page visit" + i).map(String::toUpperCase);
            System.out.println("I " + i);
            System.out.println("..............");
            return Flux.just("Hello").repeat(3);
            //  return Flux.interval(Duration.ofMillis(10000)).map(j->i *j);
        }).doOnNext(e -> {
            System.out.println("E " + e);
        }).blockLast();
    }
}

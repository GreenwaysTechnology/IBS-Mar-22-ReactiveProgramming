package com.ibs.reactive.threading;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Concurrency {
    public static void main(String[] args) {
        Flux.range(1,5).map(i->{
            System.out.println("map 1 => " + Thread.currentThread().getName());
            return i;
        }).subscribeOn(Schedulers.parallel())
                .map(i->{
            System.out.println("map 2 =>" + Thread.currentThread().getName());
            return i;
        }).publishOn(Schedulers.boundedElastic()).filter(j->{
            System.out.println("filter =>" + Thread.currentThread().getName());
            return j %2 ==0;
        }).blockLast();

    }
}

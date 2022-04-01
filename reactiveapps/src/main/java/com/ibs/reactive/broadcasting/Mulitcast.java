package com.ibs.reactive.broadcasting;

import reactor.core.publisher.Flux;

public class Mulitcast {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1);

        //subscriber-1
        flux.doOnSubscribe(subscription -> {
            System.out.println("Subscriber -1");
        }).doOnNext(item->{
            System.out.println(item);
        }).subscribe();

        //subscriber-2
        flux.doOnSubscribe(subscription -> {
            System.out.println("Subscriber -2");
        }).doOnNext(item->{
            System.out.println(item);
        }).subscribe();

    }
}

package com.ibs.reactive.streams;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class Streams {
    public static void main(String[] args) {
        Flux.interval(Duration.ofMillis(1000)).map(i -> {
                    System.out.println("map-1 =>" + i);
                    return i * 2;
                }).map(j -> {
                    System.out.println("map-2 =>" + j);
                    return j * 2;
                })
                .doOnNext(l -> {
                    System.out.println("Item " + l);
                }).blockLast();
    }
}

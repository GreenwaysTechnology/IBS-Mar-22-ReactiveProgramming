package com.ibs.reactive.flux;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class InfiniteStream {
    public static void main(String[] args) {
        streamNumbers();
        //   sleep(10000);
    }

    private static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void streamNumbers() {
        // Flux.interval(Duration.ofMillis(10)).subscribe(data -> System.out.println("Data =>" + data));
        Flux.interval(Duration.ofMillis(1000))
                .doOnSubscribe(subscription -> {
                    System.out.println("Subscription starts");
                })
                .doOnNext(data -> {
                    System.out.println(data);
                })
                .doOnError(err -> {
                    System.out.println(err);
                })
                .doOnComplete(() -> {
                    System.out.println("Stream closed");
                }).blockLast();
    }
}

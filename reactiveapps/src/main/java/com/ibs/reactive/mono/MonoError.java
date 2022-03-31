package com.ibs.reactive.mono;

import reactor.core.publisher.Mono;

public class MonoError {
    public static void main(String[] args) {
        Mono.create(monoSink -> {
            monoSink.error(new RuntimeException("oops!"));
        }).subscribe(data -> {
            System.out.println(data);
        }, err -> {
            System.out.println(err);
        }, () -> {
            System.out.println("Complete");
        });
    }
}

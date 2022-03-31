package com.ibs.reactive.mono;

import reactor.core.publisher.Mono;

public class MonoWithSucess {
    public static void main(String[] args) {
        Mono.create(monoSink -> {
            monoSink.success();
        }).subscribe(data -> {
            System.out.println("No data" + data);
        }, err -> {
            System.out.println(err);
        }, () -> {
            System.out.println("Complete");
        });
    }
}

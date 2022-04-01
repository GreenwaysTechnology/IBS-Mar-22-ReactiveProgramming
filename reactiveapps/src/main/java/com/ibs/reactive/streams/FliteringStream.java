package com.ibs.reactive.streams;

import reactor.core.publisher.Flux;

import java.util.List;

public class FliteringStream {
    public static void main(String[] args) {
        Flux.range(1, 10).log()
                .filter(i -> i % 2 == 0)
                .doOnNext(item -> {
                    System.out.println("Even Number =>" + item);
                }).subscribe();

        System.out.println("Filtered Name");
        Flux.fromIterable(List.of("Subramanian", "Ram", "Sudha", "Suresh", "Anbu"))
                .filter(name -> name.startsWith("A")).doOnNext(item -> {
                    System.out.println("Name =>" + item);
                }).subscribe();
    }
}

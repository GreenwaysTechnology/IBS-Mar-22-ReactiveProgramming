package com.ibs.reactive.flux;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicLong;

public class FluxGenerate {

    public static void main(String[] args) {
      //  generateInts();
        generateAutomtic();
    }

    private static void generateAutomtic() {
        Flux.generate(AtomicLong::new, (state, sink) -> {
            long i = state.incrementAndGet();
            sink.next("3 X " + i + " = " + 3 * 1);
            if (i == 10) sink.complete();
            return state;
        }).subscribe(System.out::println);
    }

    private static void generateInts() {
        Flux.generate(() -> 10, (state, sink) -> {
            //emit values
            sink.next("3 X" + state + "=" + 3 * state);
            if (state == 100) sink.complete();
            return state + 1;
        }).subscribe(System.out::println);
    }
}

package com.ibs.reactive.flux;

import reactor.core.publisher.Flux;

public class FluxWithError {
    public static void main(String[] args) {
        createFluxWithError();
    }

    private static void createFluxWithError() {
        Flux.create(fluxSink -> {
            for (int i = 0; i < 10; i++) {
                fluxSink.next(i);
                if (i > 5) throw new RuntimeException("Not possible to emit");
            }
            fluxSink.complete();
        }).subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }
}

package com.ibs.reactive.flux;

import reactor.core.publisher.Flux;

public class FluxCreate {
    public static void main(String[] args) {
        createFlux();
        createFluxWithoutVariable();
    }


    private static void createFluxWithoutVariable() {
        Flux.create(fluxSink -> {
            for (int i = 0; i < 10; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
        }).subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }

    private static void createFlux() {
        Flux<Integer> intFlux = Flux.create(fluxSink -> {
            for (int i = 0; i < 10; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
        });
        intFlux.subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }
}

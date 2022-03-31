package com.ibs.reactive.operators.transformation;

import reactor.core.publisher.Flux;

public class MapTransformation {

    public static void main(String[] args) {
        transform();
    }

    private static void transform() {
//        Flux.range(1, 10).map(i -> {
//            return i * 2;
//        }).subscribe(System.out::println);
//        Flux.range(1, 10).map(i -> i * 2).subscribe(System.out::println);
        Flux.range(1, 10).map(MapTransformation::doubleIt).subscribe(System.out::println);

    }

    private static Integer doubleIt(Integer i) {
        return i * 2;
    }
}

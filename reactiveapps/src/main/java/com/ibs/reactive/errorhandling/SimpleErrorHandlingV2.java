package com.ibs.reactive.errorhandling;

import reactor.core.publisher.Flux;

public class SimpleErrorHandlingV2 {
    private static String doSomething(int i) {
        // System.out.println(i);
        if (i == 5) {
            throw new RuntimeException("sorry");
        }
        return Integer.toString(i);
    }

    public static void main(String[] args) {

//        Flux<String> f = Flux.range(1, 10)
//                .map(v -> doSomething(v))
//                .onErrorReturn("Recovered");
//        f.subscribe(v -> System.out.println("Data =>" + v), err -> System.out.println("CAUGHT" + err.getMessage()));

        Flux.range(1, 10)
                .map(v -> doSomething(v))
                .onErrorReturn(getFromCache())
                .subscribe(v -> System.out.println(v), err -> System.out.println(err));
        //Return something for particular method
        Flux.range(1, 10)
                .map(v -> doSomethingboom(v))
                .onErrorReturn(e -> e.getMessage().equals("boom10"), "recovered10")
                .subscribe(v -> System.out.println(v), err -> System.out.println(err));

    }

    private static String doSomethingboom(int i) {
        // System.out.println(i);
        if (i == 5) {
            throw new RuntimeException("boom10");
        }
        return Integer.toString(i);
    }

    private static String getFromCache() {
        return "Cache Result";
    }
}

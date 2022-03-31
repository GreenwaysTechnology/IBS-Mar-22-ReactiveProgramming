package com.ibs.reactive.mono;

import reactor.core.publisher.Mono;

import java.util.List;

public class MonoCreationalOperators {
    public static void main(String[] args) {
        getSingleValue();
        getList();
        getError();
        getNothing();
        login("admin", "admin").subscribe(System.out::println,
                System.out::println,
                () -> System.out.println("Stream closed"));
    }

    private static void getNothing() {
        Mono.empty().subscribe(System.out::println,
                System.out::println,
                () -> System.out.println("Stream closed"));
    }

    private static void getError() {
        Mono.error(new RuntimeException("Item Not Found")).subscribe(System.out::println,
                System.out::println,
                () -> System.out.println("Stream closed"));
    }

    private static void getSingleValue() {
        int number = 100;
        Mono.just(number).subscribe(System.out::println,
                System.out::println,
                () -> System.out.println("Stream closed"));
    }

    private static Mono<String> login(String userName, String password) {
        //biz logic
        if (userName.equals("admin") && password.equals("admin")) {
            return Mono.just("Login Success");
        }
        return Mono.error(new RuntimeException("Login Failed"));
    }

    private static void getList() {
        Mono.just(List.of(1, 2, 3, 5, 8)).subscribe(System.out::println,
                System.out::println,
                () -> System.out.println("Stream closed"));
    }

}

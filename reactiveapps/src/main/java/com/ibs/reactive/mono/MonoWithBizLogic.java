package com.ibs.reactive.mono;

import reactor.core.publisher.Mono;

public class MonoWithBizLogic {
    public static void main(String[] args) {
        login("admin", "admin")
                .subscribe(System.out::println,
                        System.out::println,
                        () -> System.out.println("Login Stream closed"));
    }

    private static Mono<String> login(String userName, String password) {
        //biz logic
        if (userName.equals("admin") && password.equals("admin")) {
            return Mono.create(monoSink -> {
                monoSink.success("Login success");
            });
        }
        return Mono.create(monoSink -> {
            monoSink.error(new RuntimeException("Login failed"));
        });
    }
}

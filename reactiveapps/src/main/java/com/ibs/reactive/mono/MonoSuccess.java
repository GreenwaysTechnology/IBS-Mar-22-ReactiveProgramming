package com.ibs.reactive.mono;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Mono;

public class MonoSuccess {
    public static void main(String[] args) {
//        Mono<String> mono = Mono.create(monoSink->{
//            monoSink.success("Success");
//        });
//        mono.subscribe(data->{
//            System.out.println(data);
//        },error->{},()->{
//            System.out.println("complete");
//        });
        Mono.create(monoSink->{
            monoSink.success("Success");
        }).subscribe(data->{
            System.out.println(data);
        },error->{},()->{
            System.out.println("complete");
        });

    }
}

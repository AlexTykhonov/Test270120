package com.example.test;

import java.time.Duration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Test {

    public static void main(String[] args) throws InterruptedException {

//        Mono<String> mono1 = Mono.just("grokonez.com");
//        Mono<String> mono2 = Mono.just("|Java Technology");
//        Mono<String> mono3 = Mono.just("|Spring Framework");
//
//        System.out.println("=== Flux.concat(mono1, mono3, mono2) ===");
//        Flux.concat(mono1, mono3, mono2).subscribe(System.out::print);
//
//        System.out.println("\n=== combine the value of mono1 then mono2 then mono3 ===");
//        mono1.concatWith(mono2).concatWith(mono3).subscribe(System.out::print);

        Flux<String> flux1 = Flux.just("{1}", "{2}", "{3}", "{4}");
        Flux<String> flux2 = Flux.just("|A|", "|B|", "|C|");
//
//        System.out.println("\n=== Flux.zip(flux2, flux1, combination) ===");
//        Flux.zip(flux2, flux1,
//                (itemFlux2, itemFlux1) -> "-[" + itemFlux2 + itemFlux1 + "]-")
//                .subscribe(System.out::print);

//        System.out.println("\n=== flux1 values zip with flux2 values ===");
//        flux1.zipWith(flux2,
//                (itemFlux1, itemFlux2) -> "-[" + itemFlux1 + itemFlux2 + "]-")
//                .subscribe(System.out::print);

        Flux<String> intervalFlux1 = Flux
                .interval(Duration.ofMillis(500))
                .zipWith(flux1, (i, string) -> string);

        Flux<String> intervalFlux2 = Flux
                .interval(Duration.ofMillis(700))
                .zipWith(flux2, (i, string) -> string);

//        System.out.println("\n=== Flux.concat(flux2, flux1) ===");
//        Flux.concat(flux2, flux1).subscribe(System.out::print);
//
//        System.out.println("\n=== flux1 values and then flux2 values ===");
//       flux1.concatWith(flux2).subscribe(System.out::print);
//
//        System.out.println("\n=== Flux.concat(intervalFlux2, flux1) ===");
//        Flux.concat(intervalFlux2, flux1).subscribe(System.out::print);
//        Thread.sleep(3000);
//
//        System.out.println("\n=== intervalFlux1 values and then flux2 values ===");
//        intervalFlux1.concatWith(flux2).subscribe(System.out::print);
//        Thread.sleep(3000);

//        System.out.println("\n=== Flux.concat(intervalFlux2, intervalFlux1) ===");
//        Flux.concat(intervalFlux2, intervalFlux1).subscribe(System.out::print);
//        Thread.sleep(5000);

//        System.out.println("\n=== intervalFlux1 values and then intervalFlux2 values ===");
//        intervalFlux1.concatWith(intervalFlux2).subscribe(System.out::print);
//        Thread.sleep(5000);

        System.out.println("\n=== Flux.merge(intervalFlux1, intervalFlux2) ===");
        Flux.merge(intervalFlux1, intervalFlux2).subscribe(System.out::print);
        Thread.sleep(3000);

        System.out.println("\n=== interleave flux1 values with flux2 values ===");
        intervalFlux1.mergeWith(intervalFlux2).subscribe(System.out::print);
        Thread.sleep(3000);

    }
}
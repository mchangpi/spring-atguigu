package com.example.webflux.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestReactor {
  public static void main(String[] args) {
    Flux.just(1, 2, 3, 4).subscribe(System.out::print);
    Mono.just("A").subscribe(System.out::print);

    /*
    Integer[] arr = {1, 2, 3, 4};
    Flux.fromArray(arr);
    List<Integer> list = Arrays.asList(arr);
    Flux.fromIterable(list);
    Stream<Integer> intStream = list.stream();
    Flux.fromStream(intStream );
     */
  }
}
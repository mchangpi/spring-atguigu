package com.example.webflux;

import com.example.webflux.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class Client {
  public static void main(String[] args) {
    WebClient webClient = WebClient.create("http://127.0.0.1:59852");
    String id = "2";
    User user = webClient.get().uri("/user/{id}", id).
        accept(MediaType.APPLICATION_JSON).retrieve().
        bodyToMono(User.class).block();
    System.out.println(user.getName());
    Flux<User> usersFlux = webClient.get().uri("/users").
        accept(MediaType.APPLICATION_JSON).retrieve().
        bodyToFlux(User.class);
    usersFlux.map(stu -> stu.getName()).buffer().doOnNext(System.out::println).blockFirst();
  }
}
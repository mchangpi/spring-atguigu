package com.example.webflux.handler;

import com.example.webflux.entity.User;
import com.example.webflux.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class UserHandler {
  private UserService userService;

  public UserHandler(UserService userService) {
    this.userService = userService;
  }

  public Mono<ServerResponse> getUserById(ServerRequest request) {
    int id = Integer.valueOf(request.pathVariable("id"));
    Mono<User> userMono = userService.getUserById(id);

    Mono<ServerResponse> notFound = ServerResponse.notFound().build();
    return userMono.flatMap(person ->
        ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(person))
    ).switchIfEmpty(notFound);
  }

  public Mono<ServerResponse> getAllUsers(ServerRequest request) {
    Flux<User> users = userService.getAllUsers();
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(users, User.class);
  }

  public Mono<ServerResponse> saveUser(ServerRequest request) {
    Mono<User> userMono = request.bodyToMono(User.class);
    return ServerResponse.ok().build(this.userService.saveUserInfo(userMono));
  }

}
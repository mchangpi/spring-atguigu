package com.example.webflux.service;

import com.example.webflux.entity.User;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserService implements IUserService {

  private final Map<Integer, User> users = new HashMap<>();

  public UserService() {
    this.users.put(1, new User("lucy", "male", 20));
    this.users.put(2, new User("mary", "female", 30));
    this.users.put(3, new User("jack", "male", 35));
  }

  @Override
  public Mono<User> getUserById(int id) {
    return Mono.justOrEmpty(this.users.get(id));
  }

  @Override
  public Flux<User> getAllUsers() {
    return Flux.fromIterable(this.users.values());
  }

  @Override
  public Mono<Void> saveUserInfo(Mono<User> userMono) {
    return userMono.doOnNext(person -> {
      users.put(users.size() + 1, person);
    }).thenEmpty(Mono.empty()); // Mono.empty() means stop signal
  }
}
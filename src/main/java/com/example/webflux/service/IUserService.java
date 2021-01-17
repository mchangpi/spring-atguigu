package com.example.webflux.service;

import com.example.webflux.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {
  Mono<User> getUserById(int id);

  Flux<User> getAllUsers();

  Mono<Void> saveUserInfo(Mono<User> user);
}
package com.example.webflux.controller;

import com.example.webflux.entity.User;
import com.example.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("user/{id}")
  public Mono<User> getUserById(@PathVariable int id) {
    return userService.getUserById(id);
  }

  @GetMapping("users")
  public Flux<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @PostMapping("/saveuser")
  public Mono<Void> saveUser(@RequestBody User user) {
    Mono<User> userMono = Mono.just(user);
    return userService.saveUserInfo(userMono);
  }
}
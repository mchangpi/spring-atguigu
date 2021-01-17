package com.example.webflux;

import com.example.webflux.handler.UserHandler;
import com.example.webflux.service.UserService;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class Server {
  public static void main(String[] args) throws Exception {
    Server server = new Server();
    server.createReactorServer();
    System.out.println("Enter to exit...");
    System.in.read();
  }

  public RouterFunction<ServerResponse> routingFunction() {
    UserService userService = new UserService();
    UserHandler userHandler = new UserHandler(userService);
    return RouterFunctions.route(
        GET("/user/{id}").and(accept(APPLICATION_JSON)), userHandler::getUserById).
        andRoute(GET("/users").and(accept(APPLICATION_JSON)), userHandler::getAllUsers);
  }

  public void createReactorServer() {
    RouterFunction<ServerResponse> router = routingFunction();
    HttpHandler httpHandler = toHttpHandler(router);
    ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
    HttpServer httpServer = HttpServer.create();
    httpServer.handle(adapter).bindNow();
  }
}
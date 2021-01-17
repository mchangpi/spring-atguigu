package com.example.reactor8.reactor;

import java.util.Observable;

public class Observerdemo extends Observable {
  public static void main(String[] args) {
    Observerdemo obsable = new Observerdemo();
    obsable.addObserver((o, arg) -> {
      System.out.println("Observer 1 notified");
    });
    obsable.addObserver((o, arg) -> {
      System.out.println("Observer 2 notified");
    });
    obsable.setChanged();
    obsable.notifyObservers();
  }
}
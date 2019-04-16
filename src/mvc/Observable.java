package oop.demo.swing.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ingold
 */
public abstract class Observable {

    List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer obs) {
        observers.add(obs);
    }
    
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }

}

package org.delta.observer_mdkii;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VeryCoolTopic implements Subject {
    private String message;
    public ArrayList<Observer> observers = new ArrayList<Observer>();
    private final Object MUTEX = new Object();

    @Override
    public void register(Observer observer) {
        synchronized (MUTEX) {
            if(!observers.contains(observer)) {
                observers.add(observer);
                observer.setSubject(this);
            }
        }
    }

    @Override
    public void unregister(Observer observer) {
        synchronized (MUTEX) {
            if(!observers.contains(observer)) {
                observers.remove(observer);
                observer.setSubject(null);
            }
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public String getUpdate(Observer observer) {
        return this.message;
    }

    public void postMessage(String message) {
        this.message = message;
        notifyObservers();
    }
}

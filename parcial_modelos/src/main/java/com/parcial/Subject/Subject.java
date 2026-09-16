package com.parcial.Subject;

import com.parcial.Observer.Observer;

/**
 * Subject
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}

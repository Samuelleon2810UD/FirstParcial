package com.parcial.Subject;

import java.util.ArrayList;
import java.util.List;

import com.parcial.Aditionals.SickPerson;
import com.parcial.Observer.Observer;

public class HCU implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private List<SickPerson> sickPersons = new ArrayList<>();

    public void registerObserver(Observer o) {
        if (o != null && !observers.contains(o)) {
            observers.add(o);
        }
    }

    public void removeObserver(Observer o) {
        if (o != null) {
            observers.remove(o);
        }
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.UpdateDisplay(sickPersons);
        }
    }

    public void setMeasurements(List<SickPerson> sickPersons) {
        this.sickPersons = sickPersons;
        notifyObservers();
    }
}

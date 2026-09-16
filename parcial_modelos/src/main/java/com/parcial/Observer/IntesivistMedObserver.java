package com.parcial.Observer;

import java.util.List;

import com.parcial.Aditionals.SickPerson;

public class IntesivistMedObserver implements Observer {
    private String name;
    private List<SickPerson> sickPersons;

    public IntesivistMedObserver(String name, List<SickPerson> list) {
        this.name = name;
        this.sickPersons = list;
    }
    
    public void UpdateDisplay(List<SickPerson> sickPersons) {
        this.sickPersons = sickPersons;
        display();
    }

    public void display() {
        System.out.println("Intesivist Med Observer: " + name);
        System.out.println("Sick Persons:");
        for (SickPerson sickPerson : sickPersons) {
            System.out.println("- " + sickPerson.getName());
            System.out.println("  Age: " + sickPerson.getAge());
            System.out.println("  Oxigen Saturation: " + sickPerson.getOxigenSaturation());
            System.out.println("  Arterial Pressure: " + sickPerson.getArterialPressure());
            System.out.println("--------------------");
        }
    }
}

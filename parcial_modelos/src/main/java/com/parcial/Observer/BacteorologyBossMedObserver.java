package com.parcial.Observer;

import java.util.List;

import com.parcial.Aditionals.SickPerson;

public class BacteorologyBossMedObserver implements Observer {
    private String name;
    private List<SickPerson> sickPersons;

    public BacteorologyBossMedObserver(String name , List<SickPerson> list) {
        this.name = name;
        this.sickPersons = list;
    }
    
    public void UpdateDisplay(List<SickPerson> sickPersons) {
        this.sickPersons = sickPersons;
        display();
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println("Bacteorology Boss Med Observer: " + name);
        System.out.println("Sick Persons:");
        for (SickPerson sickPerson : sickPersons) {
            System.out.println("- " + sickPerson.getName());
            System.out.println("  Age: " + sickPerson.getAge());
            System.out.println(" Attention Priority: " + sickPerson.getAtentionPriority());
            System.out.println("--------------------");
        }
    }
    
}

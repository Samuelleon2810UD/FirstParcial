package com.parcial.Aditionals;

public class Exam {
    String name;
    String description;
    String sickPerson;
    String priority;
    boolean isDone;

    public Exam(String name, String description, String sickPerson, String priority) {
        this.name = name;
        this.description = description;
        this.sickPerson = sickPerson;
        this.priority = priority;
        this.isDone = false;
    }

    public void showExam() {
        System.out.println("Exam Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Sick Person: " + sickPerson);
        System.out.println("Priority: " + priority);
        System.out.println("Is Done: " + isDone);
    }
}

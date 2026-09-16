package com.parcial.Aditionals;

import java.util.List;

public class SickPerson implements SickPersonBuilder {
    private String name;
    private int age;
    private float oxigenSaturation;
    private float arterialPressure;
    private String atentionPriority;
    private List<Exam> exams;

    @Override
    public void name(String name) {
        this.name = name;
    }

    @Override
    public void age(int age) {
        this.age = age;
    }

    @Override
    public void oxigenSaturation(float oxigenSaturation) {
        this.oxigenSaturation = oxigenSaturation;
    }

    @Override
    public void arterialPressure(float arterialPressure) {
        this.arterialPressure = arterialPressure;
    }

    @Override
    public void atentionPriority(String atentionPriority) {
        this.atentionPriority = atentionPriority;
    }

    @Override
    public void exams(List<Exam> exams) {
        this.exams = exams;
    }

    public void showSickPerson() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Oxigen Saturation: " + oxigenSaturation);
        System.out.println("Arterial Pressure: " + arterialPressure);
        System.out.println("Atention Priority: " + atentionPriority);
        System.out.println("Exams: ");
        for (Exam exam : exams) {
            exam.showExam();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getOxigenSaturation() {
        return oxigenSaturation;
    }

    public void setOxigenSaturation(float oxigenSaturation) {
        this.oxigenSaturation = oxigenSaturation;
    }

    public float getArterialPressure() {
        return arterialPressure;
    }

    public void setArterialPressure(float arterialPressure) {
        this.arterialPressure = arterialPressure;
    }

    public String getAtentionPriority() {
        return atentionPriority;
    }

    public void setAtentionPriority(String atentionPriority) {
        this.atentionPriority = atentionPriority;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }
}



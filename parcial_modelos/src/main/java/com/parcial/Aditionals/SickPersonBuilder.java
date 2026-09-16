package com.parcial.Aditionals;

import java.util.List;

public interface SickPersonBuilder {
    public void name(String name);
    public void age(int age);
    public void oxigenSaturation(float oxigenSaturation);
    public void arterialPressure(float arterialPressure);
    public void exams(List<Exam> exams);
    public void atentionPriority(String atentionPriority);
}

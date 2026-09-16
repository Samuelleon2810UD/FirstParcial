package com.parcial.Observer;

import java.util.List;

import com.parcial.Aditionals.SickPerson;

public interface Observer {
    public void UpdateDisplay(List<SickPerson> sickPersons);
}
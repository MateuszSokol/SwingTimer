package org.example;

import org.example.gui.GUI;
import org.example.service.CountdownTimer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        new GUI(new CountdownTimer(25));
    }

}
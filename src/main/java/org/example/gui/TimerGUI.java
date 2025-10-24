package org.example.gui;

import org.example.service.CountdownTimer;

import javax.swing.*;
import java.awt.*;

public class TimerGUI extends JPanel {
    private final static int WINDOW_WIDTH = 32;
    private final static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private final JLabel timerText = new JLabel("25:00");
    private final CountdownTimer timer;

    public TimerGUI(CountdownTimer timer) {
        this.timer = timer;
        initializeSwingComponents();
        launchTimer();
    }


    public void initializeSwingComponents() {
        setLabelFont();
        configurePanel();
        addComponents();

    }

    public void configurePanel() {

    }

    public void addComponents() {
        this.add(timerText);
        this.setSize(timerText.getPreferredSize());
    }




    private void setLabelFont() {
        timerText.setFont(new Font("Arial", Font.BOLD, 25));
    }

    public void launchTimer() {
        timer.start(timerText);
    }

}

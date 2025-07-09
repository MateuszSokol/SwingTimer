package org.example.gui;

import org.example.service.CountdownTimer;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private final static int WINDOW_WIDTH = 32;
    private final static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private final JLabel timerText = new JLabel("25:00");
    private final CountdownTimer timer;

    public GUI(CountdownTimer timer) {
        this.timer = timer;
        initializeSwingComponents();
        launchTimer();
    }

    public void initializeSwingComponents() {
        setLabelFont();
        configureFrame();
        addComponents();
        packAndShow();

    }

    public void configureFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(dim.width - WINDOW_WIDTH * 2, 0);
        this.setUndecorated(true);
    }

    public void addComponents() {
        this.add(timerText);
        this.setSize(timerText.getPreferredSize());
    }

    public void packAndShow() {
        this.pack();
        this.setVisible(true);
    }


    private void setLabelFont() {
        timerText.setFont(new Font("Arial", Font.BOLD, 25));
    }

    public void launchTimer() {
        timer.start(timerText);
    }

}

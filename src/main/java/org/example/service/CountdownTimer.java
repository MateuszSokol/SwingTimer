package org.example.service;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer
{
    private int remainingSeconds;
    private static final long TIMER_DELAY = 1000L;
    private final int totalDurationSeconds;


    public CountdownTimer(int minutes)
    {
        this.totalDurationSeconds = minutes*60;
        this.remainingSeconds = this.totalDurationSeconds;

    }

    public void start(JLabel label)
    {
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(remainingSeconds>=0)
                {

                    label.setText(formatTime());
                    remainingSeconds--;
                }
                else
                {
                    timer.cancel();
                }
            }
        },0,TIMER_DELAY);

    }

    private String formatTime()
    {

        int min = remainingSeconds / 60;
        int sec = remainingSeconds % 60;

        return String.format("%02d:%02d",min,sec);
    }
}

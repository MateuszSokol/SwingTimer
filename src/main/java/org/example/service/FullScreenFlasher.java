package org.example.service;

import org.example.gui.StartingScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FullScreenFlasher implements KeyListener{

    StartingScreen screen = StartingScreen.getInstance();
    JFrame frame;
    public FullScreenFlasher()
    {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        frame = new JFrame();
        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.addKeyListener(this);

        gd.setFullScreenWindow(frame);

        Color[] colors = {Color.WHITE, Color.BLACK};

        int i =1;
        while(true){

            frame.getContentPane().setBackground(colors[i%2]);
            frame.repaint();
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }

        //gd.setFullScreenWindow(null); // Exit full screen
        //frame.dispose();


    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

        screen.dispose();
        StartingScreen.setStartingScreenInstanceToNull();
        screen = StartingScreen.getInstance();

        frame.dispose();

        //System.exit(0);

    }
}

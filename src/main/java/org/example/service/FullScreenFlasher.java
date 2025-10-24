package org.example.service;

import javax.swing.*;
import java.awt.*;

public class FullScreenFlasher {

    public FullScreenFlasher()
    {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setResizable(false);

        gd.setFullScreenWindow(frame);

        Color[] colors = {Color.WHITE, Color.BLACK};

        for (int i = 0; i < 20; i++) {
            frame.getContentPane().setBackground(colors[i % 2]);
            frame.repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        gd.setFullScreenWindow(null); // Exit full screen
        frame.dispose();
    }
}

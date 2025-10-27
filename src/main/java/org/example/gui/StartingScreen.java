package org.example.gui;

import org.example.service.CountdownTimer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartingScreen extends JFrame
{
   private final JPanel mainPanel = new JPanel();
   private final Font myFont = new Font("Roboto",Font.BOLD,20);
   private static StartingScreen INSTANCE;

   public JButton launchTimerButton = new JButton("Włącz");
   public JTextField hoursTextField = new JTextField();
   public JTextField minutesTextField = new JTextField();

   CardLayout cardLayout = new CardLayout();
   public JPanel currentPanel = new JPanel(cardLayout);

    private StartingScreen()
    {
        initializeCoreFrameProperties();
        currentPanel.add(mainPanel,"configurePanel");
        minutesTextField.setText("15");

        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        addComponentsToMainPanel();

        this.add(currentPanel);
        setUpButtonListener();
        pack();

    }
    public static StartingScreen getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new StartingScreen();
        }

        return INSTANCE;
    }
    public static void setStartingScreenInstanceToNull()
    {
        INSTANCE = null;
    }

    public void initializeCoreFrameProperties()
    {
        this.setPreferredSize(new Dimension(200,170));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //Style all labels in program
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.put("Label.font", myFont);

        this.setVisible(true);
    }
    public void addComponentsToMainPanel()
    {
        JLabel hoursLabel = new JLabel("Godziny");
        JLabel minutesLabel = new JLabel("Minuty");

        hoursTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        minutesTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        launchTimerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.setBorder(new EmptyBorder(5,10,0,10));
        mainPanel.add(hoursLabel);
        mainPanel.add(hoursTextField);
        mainPanel.add(minutesLabel);
        mainPanel.add(minutesTextField);
        mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
        styleComponents();
        mainPanel.add(launchTimerButton);
    }
    public void styleComponents()
    {
        launchTimerButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, launchTimerButton.getMinimumSize().height));
        hoursTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, hoursTextField.getPreferredSize().height));
        minutesTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, minutesTextField.getPreferredSize().height));

    }

    private void checkIfDataIsProvided()
    {

        if(hoursTextField.getText().isEmpty())
        {
            hoursTextField.setText("0");
        }
        if(minutesTextField.getText().isEmpty())
        {
            minutesTextField.setText("0");
        }
    }

    public void setUpButtonListener()
    {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                checkIfDataIsProvided();
                changeShapeOFFrameForPomodoroTimer();
                int hoursToMinutes = Integer.parseInt(hoursTextField.getText())*60;
                int totalTime = hoursToMinutes+Integer.parseInt(minutesTextField.getText());
                CountdownTimer countdownTimer = new CountdownTimer(totalTime);
                TimerGUI timerPanel = new TimerGUI(countdownTimer);
                currentPanel.add(timerPanel,"timerPanel");
                cardLayout.show(currentPanel, "timerPanel");
            }
        };
        launchTimerButton.addActionListener(buttonListener);
    }

    public void changeShapeOFFrameForPomodoroTimer()
    {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(100,70);
        this.setResizable(false);
        this.setLocation(d.width - (this.getWidth()),0);
        this.setAlwaysOnTop(true);
    }

}

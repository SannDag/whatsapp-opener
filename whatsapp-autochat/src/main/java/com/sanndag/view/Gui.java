package com.sanndag.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Gui extends JFrame {
    private JPanel cellPhoneNumberPanel;
    private JPanel mainPanel;
    private JLabel cellPhoneNumber;
    private JTextField cellPhoneField;
    private JButton openChatButton;


    public Gui() {
        setTitle("Whatsapp autochat v1.0");
        setSize(330, 130);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);

        cellPhoneNumber = new JLabel("Cellphone number:");
        cellPhoneField = new JTextField();
        cellPhoneField.setMaximumSize(new Dimension(Integer.MAX_VALUE, cellPhoneField.getPreferredSize().height));
        cellPhoneNumberPanel = new JPanel();
        cellPhoneNumberPanel.setLayout(new BoxLayout(cellPhoneNumberPanel, BoxLayout.X_AXIS));
        cellPhoneNumberPanel.add(cellPhoneNumber);
        cellPhoneNumberPanel.add(Box.createRigidArea(new Dimension(8, 0)));
        cellPhoneNumberPanel.add(cellPhoneField);
        mainPanel.add(cellPhoneNumberPanel);

        openChatButton = new JButton("Open chat");
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(openChatButton);

        setVisible(true);
    }

    public String getPhoneNumber() {
        return cellPhoneField.getText();
    }
    public void addActionListenerOpenChat(ActionListener listener) {
        openChatButton.addActionListener(listener);
    }
}
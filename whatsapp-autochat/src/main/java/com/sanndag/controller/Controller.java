package com.sanndag.controller;

import com.sanndag.model.Model;
import com.sanndag.view.Gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private Model model;
    private Gui gui;

    public Controller(Model model, Gui gui) {
        this.model = model;
        this.gui = gui;
        this.gui.addActionListenerOpenChat(this);
    }

    public void actionPerformed(ActionEvent e) {
        model.openChat(gui.getPhoneNumber());
    }
}


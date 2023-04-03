package com.sanndag.app;

/**
 * WhatsApp Auto Chat is an application that allows you to automatically open a WhatsApp Web chat by entering the cellphone number, using the MVC design pattern.
 *
 * @author SannDag
 * @version 1.0
 */

import com.sanndag.controller.Controller;
import com.sanndag.model.Model;
import com.sanndag.view.Gui;

public class Main {
    public static void main(String[] args) {
        Gui gui = new Gui();
        Model model = new Model();
        Controller controller = new Controller(model, gui);
        gui.setVisible(true);
    }
}

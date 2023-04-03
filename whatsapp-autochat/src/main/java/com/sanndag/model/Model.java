package com.sanndag.model;

import com.sanndag.view.Gui;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;

public class Model {
    private static final String ERROR_EMPTY_PHONE_NUMBER = "Please enter a cell phone number.";
    private static final String ERROR_PHONE_NUMBER_CONTAIN_LETTERS = "Phone number can't contain letters. Please try again.";

    private Gui gui;
    private String cellPhoneNumber;

    public void openChat(String cellPhoneNumber) {
        try {
            if (cellPhoneNumber == null){
                JOptionPane.showMessageDialog(gui, ERROR_EMPTY_PHONE_NUMBER);
                return;
            }

            cellPhoneNumber = cellPhoneNumber.replace(" ", "");

            if (cellPhoneNumber.matches(".*[a-zA-Z]+.*")) {
                JOptionPane.showMessageDialog(gui, ERROR_PHONE_NUMBER_CONTAIN_LETTERS);
                return;
            }

            if (cellPhoneNumber.trim().isEmpty()) {
                JOptionPane.showMessageDialog(gui, ERROR_EMPTY_PHONE_NUMBER);
                return;
            }

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(gui, "Can't open whatsapp chat. Invalid phone number format. Please check the number and try again.");
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(gui, "Can't open whatsapp chat. An unexpected error occurred.");
            ex.printStackTrace();
        }

        String url = "https://web.whatsapp.com/send?phone=" + cellPhoneNumber + "&skipSession=true";

        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(gui, "Can't open whatsapp chat. Please check the number and try again.");
            ex.printStackTrace();
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(gui, "Can't open whatsapp chat. Invalid URI syntax. Enter a valid cell phone number.");
            ex.printStackTrace();
        }
    }
}

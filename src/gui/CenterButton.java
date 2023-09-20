package gui;

import logik.ButtonListiner;

import javax.swing.*;

public class CenterButton extends JPanel {
    public CenterButton(ButtonListiner listiner) {
        JButton button = new JButton("Переименовать все");
        button.setActionCommand("Rename");
        button.addActionListener(listiner);
        add(button);
    }
}

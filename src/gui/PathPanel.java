package gui;

import logik.ButtonListiner;
import logik.TabAdapter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PathPanel extends JPanel {
    private final JTextArea fileArea;

    public PathPanel(ButtonListiner buttonListiner) {

        this.fileArea = new JTextArea(1,40);
        fileArea.setBorder(new LineBorder(Color.BLACK));
        JButton fileButton = new JButton("Browse");
        fileButton.setActionCommand("Browse");
        fileButton.addActionListener(buttonListiner);
        fileArea.addKeyListener(new TabAdapter());
        fileArea.getAccessibleContext().setAccessibleDescription("Введите путь к папке, или укажите его нажав кнопку Browse");
        add(fileArea);
        add(fileButton);
    }
    public JTextArea getFileArea() {
        return fileArea;
    }

}

import gui.MainPanel;

import javax.swing.*;


public class Start {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainPanel m1 = new MainPanel();
            }
        });
    }

}

package gui;

import logik.ButtonListiner;
import logik.RenameCp437;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JFrame {
    private final PathPanel pt;
    private final ResultTable resultTable;



    public MainPanel() throws HeadlessException {
        super("Декодер IBM 437");
        setSize(900,700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        RenameCp437 renameCp437 = new RenameCp437();
        ButtonListiner listiner = new ButtonListiner(this, renameCp437);
        pt =new PathPanel(listiner);
        add(pt);
        add(new CenterButton(listiner));
        resultTable = new ResultTable();
        add(resultTable);
    }

    public ResultTable getResultTable() {
        return resultTable;
    }


    public PathPanel getPt() {
        return pt;
    }

}

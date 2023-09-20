package gui;

import logik.TabAdapter;
import javax.swing.*;

public class ResultTable extends JPanel {
    private final JTable table;
    public JTable getTable() {
        return table;
    }

    public ResultTable() {
        String[][] rows = new String[10][2];
        String[] header = {"Исходное", "Резултат"};
        table = new JTable(rows, header);

        table.addKeyListener(new TabAdapter());
        add(new JScrollPane(table));
    }
}

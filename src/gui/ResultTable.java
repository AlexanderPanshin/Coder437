package gui;

import logik.TabAdapter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ResultTable extends JPanel {
    private final JTable table;
    public JTable getTable() {
        return table;
    }

    public ResultTable() {
        String[][] rows = new String[0][2];
        String[] header = {"Исходное", "Резултат"};
        DefaultTableModel tableModel = new DefaultTableModel(header,0);
        table = new JTable(tableModel);

        table.addKeyListener(new TabAdapter());
        add(new JScrollPane(table));
    }
}

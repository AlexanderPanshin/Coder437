package logik;

import gui.MainPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Objects;

public class ButtonListiner implements ActionListener {
    private static boolean count = true;
    private static JFileChooser fileChooser;
    private final MainPanel mp;
    private final RenameCp437 renameCp437;

    public ButtonListiner(MainPanel mp, RenameCp437 renameCp437) {
        this.mp = mp;
        this.renameCp437 = renameCp437;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Objects.equals(e.getActionCommand(), "Browse")){
            Thread fileChooserThread = new Thread(() -> {
                if (fileChooser == null&&count) {
                    count=false;
                    fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int result = fileChooser.showOpenDialog(mp);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        mp.getPt().getFileArea().setText(selectedFile.getAbsolutePath());
                        fileChooser = null;
                        count = true;
                    }
                    if (result == JFileChooser.CANCEL_OPTION){
                        fileChooser = null;
                        count = true;
                    }
                }//Надо подумать что делать с потоком Exception while removing reference.
            });
            fileChooserThread.start();
        } else if (Objects.equals(e.getActionCommand(),"Rename")) {
            if (mp.getPt().getFileArea().getText() != null & !mp.getPt().getFileArea().getText().equals("") ){
                renameCp437.activate(new File(mp.getPt().getFileArea().getText()));
                for(int i = 0; i < renameCp437.getNewName().size(); i++){
                    DefaultTableModel model = (DefaultTableModel) mp.getResultTable().getTable().getModel();
                    model.insertRow(i, new String[]{renameCp437.getOldName().get(i), renameCp437.getNewName().get(i)});
                }

            }

        }
    }
    }



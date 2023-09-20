package logik;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

public class RenameCp437 {
    private final ArrayList<String> newName;
    private final ArrayList<String> oldName;

    public RenameCp437() {
        this.newName = new ArrayList<>();
        this.oldName = new ArrayList<>();
    }

    public void activate(File file) {
        addOldname(file);
        try {
            renamecp437(file);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> getNewName() {
        return newName;
    }

    public ArrayList<String> getOldName() {
        return oldName;
    }

    public void renamecp437(File file) throws UnsupportedEncodingException {
        File[] list = file.listFiles();
        assert list != null;
        for (File f : list
        ) {
            if (f.isDirectory()) {
                renamecp437(f);
                newName.add(new String(f.getName().getBytes("Cp437"), "Cp866"));
                System.out.println(f.renameTo(new File(f.getParent() + File.separator + new String(f.getName().getBytes("Cp437"), "Cp866"))));
            } else {
                String[] mass = f.getName().split("\\.(?=[^.]+$)");
                newName.add(new String(mass[0].getBytes("Cp437"), "Cp866") + "." + mass[1]);
                System.out.println(f.renameTo(new File(f.getParent() + File.separator + new String(mass[0].getBytes("Cp437"), "Cp866") + "." + mass[1])));

            }
        }
    }

    public void addOldname(File file) {
        File[] list = file.listFiles();
        assert list != null;
        Arrays.stream(list).toList().forEach(System.out::println);
        for (File f : list) {
            if(f.isDirectory()){
                addOldname(f);
                oldName.add(f.getName());
            }else {
                oldName.add(f.getName());
            }
        }
    }
}



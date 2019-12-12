package com.company;

import java.io.*;

public class BackUp extends Thread {

    private static File file;
    private static Persons persons;

    public BackUp(String pathname, Persons persons){
        file = new File(pathname);
        BackUp.persons = persons;
    }

    @Override
    public void run(){
        BackUp();
    }

    private static void BackUp() {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (fileOutputStream != null) {
                oos = new ObjectOutputStream(fileOutputStream);
                oos.writeObject(persons.list);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(oos!=null) {
                try {
                    oos.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

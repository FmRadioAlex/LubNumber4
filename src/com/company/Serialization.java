package com.company;

import java.io.*;
import java.util.ArrayList;

public class Serialization implements Serializable {

    File file;

    public Serialization(){
    }

    public Serialization(String pathname){
        file = new File(pathname);
    }

    public String Serialization(com.company.Persons persons) throws IOException {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D://Persons.txt");
            if (fileOutputStream != null) {
                oos = new ObjectOutputStream(fileOutputStream);
                oos.writeObject(persons.list);
                return "Запись прошла успешно";
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(oos!=null) {
                try {
                    oos.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return "Ошибка записи ";
    }

    public String Deserialization(com.company.Persons persons) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        try {
            persons.list=(ArrayList)ois.readObject();
            return "Чтение прошло успешно";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Ошибка чтения ";
    }
}

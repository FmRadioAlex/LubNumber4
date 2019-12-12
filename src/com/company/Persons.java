
package com.company;

import java.util.ArrayList;

public class Persons {

    public ArrayList<Person> list;

    boolean isCorrectly = false;

    public Persons() {
        this.list = new ArrayList<>();
    }

    public Persons(int lenght) {
        this.list = new ArrayList<>(lenght);
    }

    public void add(com.company.Person person) {
        list.add(person);
    }

    String surname;
    Double price;
    int mounth;

    /**
     * Вывод всех доступных клиентов на экран
     *
     * @return
     */

    public String print() {
        String persons = "";
        for (com.company.Person person : this.list) {
            persons += ("Ф.И.О.: " + person.fullName + '\n' + "Номер: " + person.number + '\n' + "Домашний адресс: " + person.adress + '\n' + "Сумма вклада: " + person.price + '\n' + "На какой срок: " + person.mounth + '\n');
        }
        return persons;
    }

    /**
     * Поиск клиента по фамилии
     *
     * @return
     */

    public String getDataByFullName(String Surname) {
        for (com.company.Person person : this.list) {
            if (person.fullName != null) {
                if (person.fullName.contains(Surname)) {
                    isCorrectly = true;
                    return ("Ф.И.О.: " + person.fullName + '\n' + "Номер: " + person.number + '\n' + "Домашний адресс: " + person.adress + '\n' + "Сумма вклада: " + person.price + '\n' + "На какой срок: " + person.mounth + '\n');
                }

            }
        }
        return null;
    }

    /**
     *  Поиск по заданной сумме вклада
     * @return
     * @param price
     */

    public String getDataByPrice(String price){
        for (com.company.Person person : this.list) {
            if (this.price < person.price) {
                return ("Ф.И.О.: " + person.fullName + '\n' + "Номер: " + person.number + '\n' + "Домашний адресс: " + person.adress + '\n' + "Сумма вклада: " + person.price + '\n' + "На какой срок: " + person.mounth + '\n');
            }
        }
        return null;
    }


    /**
     * Вывод клиета если вклад превышает срок 12 месяцев
     * @return
     * @param new_mounth
     */

    public String getDataByMounth(int new_mounth) {
        for (com.company.Person person : list) {
            if (new_mounth < person.mounth) {
                return ("Ф.И.О.: " + person.fullName + '\n' + "Номер: " + person.number + '\n' + "Домашний адресс: " + person.adress + '\n' + "Сумма вклада: " + person.price + '\n' + "На какой срок: " + person.mounth + '\n');
            }
        }
        return null;
    }



    /**
     * Удаление клиента с заданной фамилией
     * @return
     * @param surname
     */

    public String remove(String surname) {
        for (com.company.Person person : list) {
            if (person.fullName.contains(this.surname)) {
                person.fullName = null;
                person.number = 0;
                person.mounth = 0;
                person.price = 0;
                person.adress = null;
                break;
            }

        }
        return null;
    }


}

package com.company;

import java.io.Serializable;

public class Person implements Serializable {
    String fullName;
    String adress;
    int number;
    double price;
    int mounth;




    public Person(String fullName, String adress, double price, int mounth, int number) {
        this.fullName = fullName;
        this.adress = adress;
        this.number = number;
        this.price = price;
        this.mounth = mounth;

    }


}


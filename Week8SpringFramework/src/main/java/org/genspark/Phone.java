package org.genspark;

import org.springframework.stereotype.Component;


public class Phone {

    private String number;

    public Phone(String num) {
        this.number = num;
    }


    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

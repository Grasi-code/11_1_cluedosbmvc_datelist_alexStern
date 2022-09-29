package com.example._11_1_cluedosbmvc_datelist.models.classes;

import java.util.Date;

public class Person {
    private String name;
    private String anrede;
    private int alter;
    private String merkmal;
    private String beruf;
    private boolean isDead;

    public Person(String name, String anrede, int alter, String merkmal, String beruf, boolean isDead) {
        this.name = name;
        this.anrede = anrede;
        this.alter = alter;
        this.merkmal = merkmal;
        this.beruf = beruf;
        this.isDead = isDead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnrede() {
        return anrede;
    }

    public void setAnrede(String anrede) {
        this.anrede = anrede;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getMerkmal() {
        return merkmal;
    }

    public void setMerkmal(String merkmal) {
        this.merkmal = merkmal;
    }

    public String getBeruf() {
        return beruf;
    }

    public void setBeruf(String beruf) {
        this.beruf = beruf;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}

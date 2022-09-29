package com.example._11_1_cluedosbmvc_datelist.models.classes;

public class Rooms {
    private String name;
    private String position;
    private int groesse;
    private String Merkmal;

    public Rooms(String name, String position, int groesse, String merkmal) {
        this.name = name;
        this.position = position;
        this.groesse = groesse;
        Merkmal = merkmal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getGroesse() {
        return groesse;
    }

    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }

    public String getMerkmal() {
        return Merkmal;
    }

    public void setMerkmal(String merkmal) {
        Merkmal = merkmal;
    }
}

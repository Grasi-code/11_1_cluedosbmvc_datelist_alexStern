package com.example._11_1_cluedosbmvc_datelist.models.classes;

public class Weapon {
    private String name;
    private String typ;
    private int gewicht;
    private String material;
    private String merkmal;

    public Weapon(String name, String typ, int gewicht, String material, String merkmal) {
        this.name = name;
        this.typ = typ;
        this.gewicht = gewicht;
        this.material = material;
        this.merkmal = merkmal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMerkmal() {
        return merkmal;
    }

    public void setMerkmal(String merkmal) {
        this.merkmal = merkmal;
    }
}

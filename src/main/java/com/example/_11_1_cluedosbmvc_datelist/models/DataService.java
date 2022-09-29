package com.example._11_1_cluedosbmvc_datelist.models;

import com.example._11_1_cluedosbmvc_datelist.models.classes.Person;
import com.example._11_1_cluedosbmvc_datelist.models.classes.Rooms;
import com.example._11_1_cluedosbmvc_datelist.models.classes.Weapon;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    private List<Person> people = new ArrayList<>();
    private List<Weapon> weapons = new ArrayList<>();
    private List<Rooms> rooms = new ArrayList<>();
    private List<String> history;

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List<Rooms> getRooms() {
        return rooms;
    }

    public void setRooms(List<Rooms> rooms) {
        this.rooms = rooms;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }
}
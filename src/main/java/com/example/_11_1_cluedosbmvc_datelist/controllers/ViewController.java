package com.example._11_1_cluedosbmvc_datelist.controllers;

import com.example._11_1_cluedosbmvc_datelist.logic.GameLogic;
import com.example._11_1_cluedosbmvc_datelist.models.DataService;
import com.example._11_1_cluedosbmvc_datelist.models.classes.Crime;
import com.example._11_1_cluedosbmvc_datelist.models.classes.Person;
import com.example._11_1_cluedosbmvc_datelist.models.classes.Rooms;
import com.example._11_1_cluedosbmvc_datelist.models.classes.Weapon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewController {
    Boolean isLoaded = false;
    DataService dataService = new DataService();
    GameLogic gameLogic = new GameLogic();

    Person chad = new Person("Chad", "giga", 24, "Musklen", "chad", false);
    Person soyBoy = new Person("Jeffery", "Mr", 44, "Glatze", "Detailhandel", false);
    Person geeler = new Person("Geeler", "Mr", 17, "Coding Sweater", "informatiker", false);
    Person lauper = new Person("Lauper", "Mr", 17, "Nicht sportlich", "Informatiker", false);
    Person stern = new Person("Stern", "Herr", 17, "Starboy", "Informatiker", false);
    Person gleeson = new Person("Gleeson", "Herr", 17, "Gitarre", "Informatiker", false);

    Weapon knife = new Weapon("Kitchen Knife", "Meele", 5, "Metal", "Sharp");
    Weapon katana = new Weapon("Katana", "Meele", 7, "Steel", "long");
    Weapon revolver = new Weapon("Relover", "Ranged", 8, "Steel", "44 Magnum");
    Weapon kar98 = new Weapon("Kar98", "DMR", 12, "Wood", "WW2 rifle");
    Weapon chainsaw = new Weapon("Chainsaw", "Meele", 20, "Metal", "Loud");
    Weapon gatlinGun = new Weapon("Mini Gun", "Ranged", 40, "Metal", "Heavy");

    Rooms livingRoom = new Rooms("Living Room", "Center", 100,"Spacious");
    Rooms bathRoom = new Rooms("Bath Room", "Center Left", 30,"No windows");
    Rooms kitchen = new Rooms("Kitchen", "Right", 50,"Full of weapons");
    Rooms bedRoom = new Rooms("Bed Room", "2nd Floor center", 60,"has revolver");
    Rooms garage = new Rooms("garage", "-1 Floor ", 90,"has chainsaw");
    Rooms garden = new Rooms("garden", "outside", 120,"lots of trees");

    public void setupPeople(List<Person> people) {
        people.add(chad);
        people.add(soyBoy);
        people.add(geeler);
        people.add(lauper);
        people.add(stern);
        people.add(gleeson);
    }
    public void setupWeapons(List<Weapon> weapons) {
        weapons.add(knife);
        weapons.add(katana);
        weapons.add(kar98);
        weapons.add(revolver);
        weapons.add(chainsaw);
        weapons.add(gatlinGun);
    }

    public void setupRooms(List<Rooms> rooms) {
        rooms.add(livingRoom);
        rooms.add(kitchen);
        rooms.add(bedRoom);
        rooms.add(garage);
        rooms.add(garden);
        rooms.add(bathRoom);
    }

    public void deletePeople(List<Person> people) {
        people.remove(chad);
        people.remove(soyBoy);
        people.remove(geeler);
        people.remove(lauper);
        people.remove(stern);
        people.remove(gleeson);
    }
    public void deleteWeons(List<Weapon> weapons) {
        weapons.remove(knife);
        weapons.remove(kar98);
        weapons.remove(katana);
        weapons.remove(gatlinGun);
        weapons.remove(chainsaw);
        weapons.remove(revolver);
    }

    public void deleteRooms(List<Rooms> rooms) {
        rooms.remove(livingRoom);
        rooms.remove(kitchen);
        rooms.remove(bedRoom);
        rooms.remove(garage);
        rooms.remove(garden);
        rooms.remove(bathRoom);
    }

    @GetMapping("/")
    public String homeForm(Model model) {

        deletePeople(dataService.getPeople());
        setupPeople(dataService.getPeople());
        model.addAttribute("people", dataService.getPeople());
        deleteWeons(dataService.getWeapons());
        setupWeapons(dataService.getWeapons());
        model.addAttribute("weapons", dataService.getWeapons());
        deleteRooms(dataService.getRooms());
        setupRooms(dataService.getRooms());
        model.addAttribute("rooms", dataService.getRooms());



        return "index";
    }

    @PostMapping("/submit")
    public String CheckCrime(@RequestParam Person person, @RequestParam Rooms room, @ RequestParam Weapon weapon) {
        Crime crime = new Crime();
        int MaxSuggestion = 5;
        int currenSuggestion = 0;
        Crime playersCrime = new Crime();

        playersCrime.setActor(dataService.findPersonIndexByName(dataService.getPeople(), person.getName()));
        playersCrime.setWeapon(dataService.findWeaponIndexByName(dataService.getWeapons(), weapon.getName()));
        playersCrime.setScene(dataService.findRoomIndexByName(dataService.getRooms(), room.getName()));
        gameLogic.setupNewGame(dataService, crime);
        gameLogic.evaluateSuggestion(playersCrime, crime, currenSuggestion, MaxSuggestion);
        return "";
    }
    }

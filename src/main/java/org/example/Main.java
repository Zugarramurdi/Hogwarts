package org.example;

import Models.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        House gryffindor = new House("Gryffindor","Godric Gryffindor");
        House slytherin = new House("Slytherin","Salazar Slytherin");
        House hufflepuff = new House("Hufflepuff","Helga Hufflepuff");
        House ravenclaw = new House("Ravenclaw","Rowena Ravenclaw");

        Wand wand1 = new Wand("Acebo","Pluma de fénix",28.0);
        Wand wand2 = new Wand("Espino", "Pelo de unicornio", 23.0);
        Wand wand3 = new Wand("Vid", "Corazón de dragón", 25.4);
        Wand wand4 = new Wand("Sauce", "Pelo de unicornio", 25.4);



        HouseDAO houseDAO = new HouseDAO();
        WandDAO wandDAO = new WandDAO();
        WizardDAO wizardDAO = new WizardDAO();


/*        System.out.println(gryffindor.toString());
        System.out.println(slytherin.toString());
        System.out.println(hufflepuff.toString());
        System.out.println(ravenclaw.toString());

        System.out.println(wand1.toString());
        System.out.println(wand2.toString());
        System.out.println(wand3.toString());
        System.out.println(wand4.toString());

        System.out.println(harry.toString());
        System.out.println(ron.toString());
        System.out.println(hermione.toString());
        System.out.println(draco.toString());
*/

        // Creacion de casas en BBDD
/*        houseDAO.create(slytherin);
        houseDAO.create(hufflepuff);
        houseDAO.create(ravenclaw);
        houseDAO.create(gryffindor);*/

        // Creacion de varitas en BBDD
/*        wandDAO.create(wand1);
        wandDAO.create(wand2);
        wandDAO.create(wand3);
        wandDAO.create(wand4);*/

        // Instanciamos magos con sus respectivas FK
        Wizard harry = new Wizard("Harry Potter",17,1,1);
        Wizard ron = new Wizard("Ron Weasley",17, 1, 2);
        Wizard hermione = new Wizard("Hermione Granger",17, 1, 3);
        Wizard draco = new Wizard("Draco Malfoy",17, 2, 4);

        // Creacion de magos en BBDD
/*        wizardDAO.create(harry);
        wizardDAO.create(ron);
        wizardDAO.create(hermione);
        wizardDAO.create(draco);*/

 /*       ron.setName("Ronald Weasley");
        ron.setId(2);
        wizardDAO.update(ron);*/

        //Listado de magos
        List<Wizard> wizards = wizardDAO.getAll();
        for (Wizard w : wizards) {
            System.out.println("WIZARD RAW -> "+w);
            House house = houseDAO.getById(w.getHouseId());
            Wand wand = wandDAO.getById(w.getWandId());

            System.out.println("*****");
            System.out.println("id: "+w.getWandId());
            System.out.println("Nombre: "+w.getName());
            System.out.println("Edad: "+w.getAge());
            System.out.println("Casa: "+ house.getName());
            System.out.println("Varita: "+wand.getWood()+" / "+wand.getCore());
        }

        // Listado de casas
        /*List<House> houses = houseDAO.getAll();
        houses.forEach(System.out :: println);*/




    }


}

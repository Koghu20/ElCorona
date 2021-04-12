/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elcorona;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author koghu
 */
public class Places {

    int x, y;
    Random rand = new Random();
    String s = "Flat."
            + "House A."
            + "House B."
            + "House C."
            + "Playground."
            + "Bus Stop."
            + "Train Station."
            + "Petrol Station."
            + "Primary School."
            + "Secondary School."
            + "Kindergarten."
            + "Food Court."
            + "Mall."
            + "Shop Lot."
            + "Field."
            + "Police Station."
            + "Mosque."
            + "Healthcare Centre."
            + "Bank."
            + "Market";

    public Places() {

    }

    public Places(Graphics g) {

//        Graphics g= new Graphics();
//        Graphics g = null;
//        System.out.println("paint");
//    Colour mycolour= (255,12,12);
        int alpha = 200; // 50% transparent
//Color myColour = new Color(51, 153, 255);
        Color po = new Color(188, 143, 143,alpha);
        g.setColor(po);
        //1
        g.fillRect(10, 10, 240, 130);
        //2
        g.fillRect(10, 250, 160, 180);
        //3
        g.fillRect(10, 550, 200, 150);
        //4
        g.fillRect(905, 400, 160, 110);
        //5
//      g.fillRect(800, 600, 120, 80);

        //Field
        Color ss = new Color(173, 255, 47,alpha);
        g.setColor(ss);
        g.fillRect(950, 550, 150, 80);

        //FoodCourt
        Color food = new Color(210, 105, 30,alpha);
        g.setColor(food);
        g.fillRect(580, 600, 250, 110);

        //Shoplot
        g.fillRect(280, 600, 200, 180);

        //Tadika
        Color tadika = new Color(218, 165, 32,alpha);
        g.setColor(tadika);
        g.fillRect(230, 320, 60, 90);

        //Bus Stop
        Color bus = new Color(244, 164, 96,alpha);
        g.setColor(bus);
        g.fillRect(300, 10, 60, 40);

        //Market
        Color market = new Color(210, 105, 30,alpha);
        g.setColor(market);
        g.fillRect(770, 100, 80, 100);

        //Mosque
        Color mosq = new Color(255, 255, 0,alpha);
        g.setColor(mosq);
        g.fillRect(550, 460, 120, 70);

        //Police Station
        Color police = new Color(65, 105, 225,alpha);
        g.setColor(police);
        g.fillRect(630, 210, 80, 80);

        //P.Kesihatan
        Color kesihatan = new Color(255, 0, 255,alpha);
        g.setColor(kesihatan);
        g.fillRect(270, 210, 130, 90);

        //PetrolStation
        Color petrol = new Color(255, 165, 0,alpha);
        g.setColor(petrol);
        g.fillRect(300, 70, 40, 40);

        //Bank
        Color bank = new Color(219, 112, 147,alpha);
        g.setColor(bank);
        g.fillRect(490, 600, 40, 40);

        //Train
        Color train = new Color(244, 164, 96,alpha);
        g.setColor(train);
        g.fillRect(970, 270, 110, 100);

        //Mall
        Color so = new Color(218, 165, 32,alpha);
        g.setColor(so);
        g.fillRect(900, 0, 300, 200);

        //PlayGround
        Color gi = new Color(173, 255, 47,alpha);
        g.setColor(gi);
        g.fillOval(450, 300, 150, 100);

        //SK
        Color sp = new Color(255, 182, 193,alpha);
        g.setColor(sp);
        g.fillRect(330, 440, 140, 90);

        //padangSK
        Color padang = new Color(144, 238, 144,alpha);
        g.setColor(padang);
        g.fillRect(700, 425, 100, 60);

        //Smk
        Color smk = new Color(218, 165, 32,alpha);
        g.setColor(smk);
        g.fillRect(700, 330, 125, 95);

        //Factory
        Color factory = new Color(189, 183, 107,alpha);
        g.setColor(factory);
        g.fillRect(470, 0, 200, 110);

    }

    public void Location(String s) {
        if (s.equalsIgnoreCase("Flat")) {
            x = rand.nextInt(230) + 10;
            y = rand.nextInt(120) + 10;

        } else if (s.equalsIgnoreCase("House A")) {
            x = rand.nextInt(145) + 10;
            y = rand.nextInt(175) + 250;
        } else if (s.equalsIgnoreCase("House B")) {
            x = rand.nextInt(190) + 10;
            y = rand.nextInt(120) + 550;
        } else if (s.equalsIgnoreCase("House c")) {
            x = rand.nextInt(160) + 905;
            y = rand.nextInt(105) + 400;

        } else if (s.equalsIgnoreCase("Field")) {
            x = rand.nextInt(150) + 950;
            y = rand.nextInt(80) + 550;

        } else if (s.equalsIgnoreCase("Playground")) {
            x = rand.nextInt(110) + 470;
            y = rand.nextInt(60) + 320;

        } else if (s.equalsIgnoreCase("Bus Stop")) {
            x = rand.nextInt(50) + 300;
            y = rand.nextInt(30) + 10;

        } else if (s.equalsIgnoreCase("Train Station")) {
            if(rand.nextInt(10)<7){
            x = rand.nextInt(90) + 970;
            y = rand.nextInt(95) + 270;}
            else{
            x = rand.nextInt(10) + 1500;
            y = rand.nextInt(95) + 270;              
            }
        } else if (s.equalsIgnoreCase("Petrol Station")) {
            x = rand.nextInt(35) + 300;
            y = rand.nextInt(35) + 70;
        } else if (s.equalsIgnoreCase("Primary School")) {
            x = rand.nextInt(140) + 330;
            y = rand.nextInt(80) + 440;
        } else if (s.equalsIgnoreCase("Secondary School")) {
            if(rand.nextInt(2)==1){
            x = rand.nextInt(110) + 700;
            y = rand.nextInt(90) + 330;}
            else {
            x = rand.nextInt(95) + 700;
            y = rand.nextInt(55) + 420;  
            }
        } else if (s.equalsIgnoreCase("Mosque")) {
            x = rand.nextInt(110) + 550;
            y = rand.nextInt(60) + 460;
        } else if (s.equalsIgnoreCase("Food Court")) {
            x = rand.nextInt(250) + 580;
            y = rand.nextInt(80) + 600;
        } else if (s.equalsIgnoreCase("Mall")) {
            x = rand.nextInt(160) + 900;
            y = rand.nextInt(200) + 0;
        } else if (s.equalsIgnoreCase("Shop Lot")) {
            x = rand.nextInt(190) + 280;
            y = rand.nextInt(80) + 600;
        } else if (s.equalsIgnoreCase("Police Station")) {
            x = rand.nextInt(70) + 630;
            y = rand.nextInt(70) + 210;
        } else if (s.equalsIgnoreCase("Kindergarten")) {
            x = rand.nextInt(55) + 230;
            y = rand.nextInt(80) + 320;
        } else if (s.equalsIgnoreCase("Heathcare Centre")) {
            x = rand.nextInt(110) + 270;
            y = rand.nextInt(80) + 210;
        } else if (s.equalsIgnoreCase("Market")) {
            x = rand.nextInt(80) + 770;
            y = rand.nextInt(100) + 100;
        } else if (s.equalsIgnoreCase("Bank")) {
            x = rand.nextInt(40) + 490;
            y = rand.nextInt(35) + 600;
        }
        else {
            x = rand.nextInt(200) + 470;
            y = rand.nextInt(110) + 0;
            
        }

    }

    public String getLocation() {
        return s;
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

}

/*
Flat
House A
House B
House C
Playground
Bus Stop
Train Station
Petrol Station
Primary School
Secondary School
Kindergarten
Food Court
Mall
Shop Lot
Field
Police Station
Mosque
Healthcare Centre
Bank
Market

 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elcorona;

import java.util.Random;

/**
 *
 * @author pavin
 */
public class Person {
    
    private int id;
    private String home;
    private int house;
    private int age;
    private String role;
    private String occupation;
    private int forgetfullness;
    private int immunity;
    private String gender;
    private String occupationPlace;
    
    private Random r = new Random();
    private int randnum;
    
    public void person(){
        randnum = r.nextInt(4);
        switch(randnum){
            case 0:
                age = r.nextInt(6)+1;
                role = "Toddler";
                occupation = null;
                occupationPlace = "Kindergarten";
                gender = gender();
                trait();
                break;
            case 1:
                age = r.nextInt(11)+7;
                role = "Student";
                occupation = null;
                if(age<=12){
                    occupationPlace = "Primary School";
                }else{
                    occupationPlace = "Secondary School";
                }
                gender = gender();
                trait();
                break;
            case 2:
                age = r.nextInt(23)+18;
                role = "Adult";
                occupation = theirWork();
                occupationPlace = theirOccupationPlace();
                gender = gender();
                trait();
                break;
            case 3:
                age = r.nextInt(30)+41;
                role = "Elderly";
                occupation = theirWork();
                occupationPlace = theirOccupationPlace();
                gender = gender();
                trait();
                break;
        }
    }
    
    public void setHouse(int x, String a){
        house = x;
        home = a;
    }
    
    public void initializeHome(){
        randnum = r.nextInt(4);
        switch(randnum){
            case 0:
                home = "Flat";
                break;
            case 1:
                home = "House A";
                break;
            case 2:
                home = "House B";
                break;
            case 3:
                home = "House C";
                break;
        }
    }
    
    public String getHome(){
        return home;
    }
    
    public int getHouse(){
        return house;
    }
    
    public void setId(int x){
        id = x;
    }
    
    public int getId(){
        return id;
    }
    
    public String getRole(){
        return role;
    }
    
    public String getOccupation(){
        return occupation;
    }
    
    public String getOccupationPlace(){
        return occupationPlace;
    }
    
    public int getAge(){
        return age;
    }
    
    public String gender(){
        randnum = r.nextInt(2);
        if(randnum==0){
            return "Male";
        }else{
            return "Female";
        }
    }
    
    public void trait(){
        if(role=="Elderly" || role=="Toddler"){
            forgetfullness = r.nextInt(51)+50;
            immunity = r.nextInt(51)+10;
        }else{
            forgetfullness = r.nextInt(100)+1;
            immunity = r.nextInt(71)+20;
        }
    }
    
    public String theirWork(){
        randnum = r.nextInt(15);
        if(age>=60){
            return "Retired";
        }
        switch(randnum){
            case 0:
                return "Police";
            case 1:
                return "Bank Officer";
            case 2:
                return "Healthcare Centre Worker";
            case 3:
                return "Bus Driver";
            case 4:
                return "Railway Worker";
            case 5:
                return "Mall Worker";
            case 6:
                return "School Janitor";
            case 7:
                return "Teacher";
            case 8:
                return "Taxi Driver";
            case 9:
                return "Priest";
            case 10:
                return "Restaurant Worker";
            case 11:
                return "Unemployed";
            case 12:
                return "Outside City";
            case 13:
                return "Petrol Station Worker";
            case 14:
                return "Factory Worker";
        }
        return "";
    }
    
    public String theirOccupationPlace(){
        System.out.println(occupation);
        switch (occupation) {
            case "Police":
                return "Police Station";
            case "Bank Officer":
                return "Bank";
            case "Healthcare Centre Worker":
                return "Heathcare Centre";
            case "Bus Driver":
                return "Bus Stop";
            case "Railway Worker":
                return "Train Station";
            case "Mall Worker":
                return "Mall";
            case "School Janitor":
                randnum = r.nextInt(2);
                if (randnum == 0) {
                    return "Primary School";
                } else {
                    return "Secondary School";
                }
            case "Teacher":
                randnum = r.nextInt(2);
                if (randnum == 0) {
                    return "Primary School";
                } else {
                    return "Secondary School";
                }
            case "Taxi Driver":
                return "Taxi Driver";
            case "Priest":
                return "Mosque";
            case "Restaurant Worker":
                randnum = r.nextInt(3);
                if (randnum == 0) {
                    return "Food Court";
                } else if (randnum == 1) {
                    return "Shop Lot";
                } else {
                    return "Mall";
                }
            case "Outside City":
                randnum = r.nextInt(10);
                if (randnum <= 7) {
                    return "Train Station";
                } else {
                    return "Bus Stop";
                }
            case "Petrol Station Worker":
                return "Petrol Station";
            case "Factory Worker":
                return "Factory";
            default:
                return occupation;
            }
    }
    
    public String toString(){
        return "House: "+house+"\nID: "+id+"\nAge: "+age+"\nRole: "+role+"\nOccupation: "+occupation+
                "\nGender: "+gender+"\nImmunity: "+immunity+"\nForgetfullness: "+forgetfullness;
    }
}

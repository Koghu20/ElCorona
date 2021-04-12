package elcorona;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author pavin
 */
public class Household {
    
    private ArrayList<ArrayList> house = new ArrayList();
    private int id=1;
    private boolean adultPresent=false;
    private int totalPopulation;
    
    Random r = new Random();
    
    public void generate(int numOfHouses){
//        int randNum = 1;
        for(int i=0;i<numOfHouses;i++){
            ArrayList<Object> household = new ArrayList();
            int randNum = r.nextInt(6)+1;
            for(int j=0;j<randNum;j++){
                Person p = new Person();
                p.person();
                // if have extra time work on this
                while(!adultPresent){
                    if(p.getRole()=="Adult" || p.getRole()=="Elderly"){
                        adultPresent = true;
                        break;
                    }else{
                        p.person();
                    }
                }
                p.setId(id);
                id++;
                household.add(p);
            }
            totalPopulation = id;
            house.add(household);
            adultPresent = false;
        }
    }

    public ArrayList getHouse(){
        return house;
    }
    
    public int getTotalPopulation(){
        return totalPopulation-1;
    }
    
    //house id is initialized here & home also initialzed
    public String showAll(){
        int count = 1;
        String s="\n";
        for(int i=0;i<house.size();i++){
            Person temp2 = new Person();
            temp2.initializeHome();
            for(int j=0;j<house.get(i).size();j++){
                Person temp = (Person)house.get(i).get(j);
                temp.setHouse(count,temp2.getHome());
                s+=temp.toString()+"\n";
                s+="----------------------------------------\n";
            }
            count++;
        }
        return s;
    }
    
    // to get a specific person
    public void showId(int seekId){
        int sum=0;
        int count=0;
        while(sum<seekId){
            sum = sum + house.get(count).size();
            count++;
        }
        count--;
        for(int i=0;i<house.get(count).size();i++){
            Person temp = (Person)house.get(count).get(i);
            if(seekId==temp.getId()){
                System.out.println(temp.toString());
            }
        }
    }
}

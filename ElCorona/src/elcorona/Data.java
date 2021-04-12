package elcorona;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author pavin
 */
public class Data {

    private static int pop;
    private static int sday = 1;
    private static Household h = new Household();
    private static LogHousehold logh = new LogHousehold();
    private static ActivityLog loga = new ActivityLog();
    private static ArrayList<String[]> l = new ArrayList<>();
    private static ArrayList<Integer> inf = new ArrayList();
    private static ArrayList<Integer> train = new ArrayList();
    private static int day = 0;
    private static String sDay;
  

    public static void main(String[] args) {
        Home m= new Home();
        h.generate(m.input()); 
        logh.logHouseHold(h.showAll());
        setDay();
        int count = 0;
        int days = 7;
        loga.activityLog(h.getHouse());
        loga.setDay("Weekday");
        l = loga.getList();
        pop = h.getTotalPopulation();
        GUI f = new GUI(pop);

    }
    


    public ArrayList<Integer> Inf(){
        return inf;
    }

    public int getP() {
        return pop;
    }

    public String[] getAct(int a) {
        return l.get(a - 1);

    }

    public void nextSDay() {
        sday++;
        setDay();
        loga.activityLog(h.getHouse());
        loga.setDay("Weekday");
    }

    public int getSDay() {
        return sday;
    }

    public void setInfected(int a) {
        inf.add(a);

    }

    public String getInfected() {
        String s = "List of Infected Person: \n\n";
        for (int i = 0; i < inf.size(); i++) {
            s += "Human ID: " + Integer.toString(inf.get(i)) + "\n";
        }
        return s;
    }
    
    public void removeInf(int a){
        for(int i=0;i<inf.size();i++){
            if(inf.get(i)==a)
                inf.remove(i);
        }
    }
     
    public void tinf(int a){
        train.add(a);
    }
    
    
    public ArrayList gT(){
        return train;
    }
    

    public static void setDay() {
        day++;
        if (day == 8) {
            day = 1;
        }
        switch (day) {
            case 1:
                sDay = "Monday";
                break;
            case 2:
                sDay = "Tuesday";
                break;
            case 3:
                sDay = "Wednesday";
                break;
            case 4:
                sDay = "Thursday";
                break;
            case 5:
                sDay = "Friday";
                break;
            case 6:
                sDay = "Saturday";
                break;
            case 7:
                sDay = "Sunday";
                break;

        }

        if (day < 6) {
            loga.setDay("Weekday");
        } else {
            loga.setDay("Weekend");
        }
    }

    public String getDay() {
        return sDay;
    }
    
    


}

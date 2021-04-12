package elcorona;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author pavin
 */
public class PlaceLog {
    
    private String [] names = new String[21];
    private String [] flat = new String[10];
    private String [] houseA = new String[10];
    private String [] houseB = new String[10];
    private String [] houseC = new String[10];
    private String [] playground = new String[10];
    private String [] busStop = new String[10];
    private String [] trainStation = new String[10];
    private String [] petrolStation = new String[10];
    private String [] schoolPrimary = new String[10];
    private String [] schoolSecondary = new String[10];
    private String [] kindergarten = new String[10];
    private String [] foodCourt = new String[10];
    private String [] mall = new String[10];
    private String [] shopLot = new String[10];
    private String [] field = new String[10];
    private String [] policeStation = new String[10];
    private String [] mosque = new String[10];
    private String [] healthcareCentre = new String[10];
    private String [] bank = new String[10];
    private String [] market = new String[10];
    private String [] factory = new String[10];
    
    private Logger log = Logger.getLogger("PLog");
    private FileHandler fh;
    private Random r = new Random();
    private int randnum;
    private boolean taxiDriver=false;
    
    public void initialise(){
        for(int i=0;i<10;i++){
            flat[i]="";
            houseA[i]="";
            houseB[i]="";
            houseC[i]="";
            playground[i]="";
            busStop[i]="";
            trainStation[i]="";
            petrolStation[i]="";
            schoolPrimary[i]="";
            schoolSecondary[i]="";
            kindergarten[i]="";
            foodCourt[i]="";
            mall[i]="";
            shopLot[i]="";
            field[i]="";
            policeStation[i]="";
            mosque[i]="";
            healthcareCentre[i]="";
            bank[i]="";
            market[i]="";
            factory[i]="";
        }
    }
    
    public void place(String data,int index,int id,int age,String home){
        switch(data){
            case "Random Place":
                place(randomPlace(),index,id,age,home);
                break;
            case "Police":
                policeStation[index]+=id+"|";
                break;
            case "Police Station":
                policeStation[index]+=id+"|";
                break;
            case "Bank Officer":
                bank[index]+=id+"|";
                break;
            case "Healthcare Centre Worker":
                healthcareCentre[index]+=id+"|";
                break;
            case "Healthcare Centre":
                healthcareCentre[index]+=id+"|";
                break;
            case "Bus Driver":
                busStop[index]+=id+"|";
                break;
            case "Bus Stop":
                busStop[index]+=id+"|";
                break;
            case "Railway Worker":
                trainStation[index]+=id+"|";
                break;
            case "Train Station":
                trainStation[index]+=id+"|";
                break;
            case "Mall Worker":
                mall[index]+=id+"|";
                break;
            case "Factory":
                factory[index]+=id+"|";
                break;
            case "School Janitor":
                randnum = r.nextInt(2);
                if(randnum==0){
                    schoolPrimary[index]+=id+"|";
                }else{
                    schoolSecondary[index]+=id+"|";
                }
                break;
            case "Teacher":
                randnum = r.nextInt(2);
                if(randnum==0){
                    schoolPrimary[index]+=id+"|";
                }else{
                    schoolSecondary[index]+=id+"|";
                }
                break;
            case "Taxi Driver":
                taxiDriver = true;
                place(randomPlace(),index,id,age,home);
                break;
            case "Priest":
                mosque[index]+=id+"|";
                break;
            case "Mosque":
                mosque[index]+=id+"|";
                break;
            case "Restaurant Worker":
                randnum = r.nextInt(3);
                if(randnum==0){
                    foodCourt[index]=id+"|";
                }else if(randnum==1){
                    shopLot[index]=id+"|";
                }else{
                    mall[index]=id+"|";
                }
                break;
            case "Outside City":
                randnum = r.nextInt(10);
                if(randnum<=7){
                    trainStation[index]+=id+"|";
                }else{
                    busStop[index]+=id+"|";
                }
                break;
            case "Petrol Station Worker":
                petrolStation[index]+=id+"|";
                break;
            case "Petrol Station":
                petrolStation[index]+=id+"|";
                break;
            case "Bank":
                bank[index]+=id+"|";
                break;
            case "Kindergarten":
                kindergarten[index]+=id+"|";
                break;
            case "Playground":
                playground[index]+=id+"|";
                break;
            case "Field":
                field[index]+=id+"|";
                break;
            case "Market":
                market[index]+=id+"|";
                break;
            case "Food Court":
                foodCourt[index]+=id+"|";
                break;
            case "Shop Lot":
                shopLot[index]+=id+"|";
                break;
            case "Mall":
                mall[index]+=id+"|";
                break;
            case "Home":
                if(taxiDriver){         // taxi is just going random houses
                    randnum = r.nextInt(5);
                    switch(randnum){
                    case 0:
                        flat[index]+=id+"|";
                        break;
                    case 1:
                        houseA[index]+=id+"|";
                        break;
                    case 2:
                        houseB[index]+=id+"|";
                        break;
                    case 3:
                        houseC[index]+=id+"|";
                        break;
                    }
                    taxiDriver = false;
                    break;
                }
                switch(home){
                    case "Flat":
                        flat[index]+=id+"|";
                        break;
                    case "House A":
                        houseA[index]+=id+"|";
                        break;
                    case "House B":
                        houseB[index]+=id+"|";
                        break;
                    case "House C":
                        houseC[index]+=id+"|";
                        break;
                }
            case "School":
                if(age<=12){
                    schoolPrimary[index]=id+"|";
                }else{
                    schoolSecondary[index]=id+"|";
                }
                break;
        }
    }
    
    public String randomPlace(){
        randnum = r.nextInt(16);
        String place="";
        switch(randnum){
            case 0:
                place = "Home";
                break;
            case 1:
                place = "Playground";
                break;
            case 2:
                place = "Field";
                break;
            case 3:
                place = "Police Station";
                break;
            case 4:
                place = "Train Station";
                break;
            case 5:
                place = "Petrol Station";
                break;
            case 6:
                place = "Shop Lot";
                break;
            case 7:
                place = "Food Court";
                break;
            case 8:
                place = "Mall";
                break;
            case 9:
                place = "Mosque";
                break;
            case 10:
                place = "School";
                break;
            case 11:
                place = "Kindergarten";
                break;
            case 12:
                place = "Healthcare Centre";
                break;
            case 13:
                place = "Bank";
                break;
            case 14:
                place = "Market";
                break;
            case 15:
                place = "Bus Stop";
                break;
        }
        return place;
    }
    
    public void activatePlaceLog(){
        try{
            fh = new FileHandler("Place.log");
            log.addHandler(fh);
            SimpleFormatter format = new SimpleFormatter();
            fh.setFormatter(format);
            String info="\n";
            
            info+="Flat\n";
            info+=printInfo(flat);
            info+="House A\n";
            info+=printInfo(houseA);
            info+="House B\n";
            info+=printInfo(houseB);
            info+="House C\n";
            info+=printInfo(houseC);
            info+="Playground\n";
            info+=printInfo(playground);
            info+="Bus Stop\n";
            info+=printInfo(busStop);
            info+="Train Station\n";
            info+=printInfo(trainStation);
            info+="Petrol Station\n";
            info+=printInfo(petrolStation);
            info+="Primary School\n";
            info+=printInfo(schoolPrimary);
            info+="Secondary School\n";
            info+=printInfo(schoolSecondary);
            info+="Kindergarten\n";
            info+=printInfo(kindergarten);
            info+="Food Court\n";
            info+=printInfo(foodCourt);
            info+="Mall\n";
            info+=printInfo(mall);
            info+="Shop Lot\n";
            info+=printInfo(shopLot);
            info+="Field\n";
            info+=printInfo(field);
            info+="Police Station\n";
            info+=printInfo(policeStation);
            info+="Mosque\n";
            info+=printInfo(mosque);
            info+="Healthcare Centre\n";
            info+=printInfo(healthcareCentre);
            info+="Bank\n";
            info+=printInfo(bank);
            info+="Market\n";
            info+=printInfo(market);
            info+="Factory\n";
            info+=printInfo(factory);
            
            log.info(info);
        }catch(SecurityException | IOException e){
            System.out.println("Error Ocurred");
        }
    }
    
    public String printInfo(String [] place){
        String info="";
        for(int i=0;i<10;i++){
            info+="Slot "+(i+1)+":\n";
            info+=place[i]+"\n";
        }
        return info;
    }
    
}

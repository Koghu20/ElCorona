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
public class ActivityLog {

    private String[] slot = new String[10];
    private String day = "Weekday";

    private ArrayList<String[]> list = new ArrayList();

    public void activityLog(ArrayList<ArrayList> house) {

        PlaceLog logp = new PlaceLog();
        logp.initialise();

        Logger log = Logger.getLogger("ALog");
        FileHandler fh;

        try {
            fh = new FileHandler("Activity.log");
            log.addHandler(fh);
            SimpleFormatter format = new SimpleFormatter();
            fh.setFormatter(format);

            for (int i = 0; i < (house.size()); i++) {
                for (int j = 0; j < house.get(i).size(); j++) {
                    String[] act = new String[10];
                    Person p = (Person) house.get(i).get(j);
                    PlaceLog place = new PlaceLog();
                    Random r = new Random();
                    int randnum;
                    String work;
                    if (p.getRole() == "Student") {
                        work = "School";
                    } else if (p.getRole() == "Toddler") {
                        if (p.getAge() <= 4) {
                            work = "Home";
                        } else {
                            work = "Kindergarten";
                        }
                    } else {
                        work = p.getOccupationPlace();
                    }

                    if (day == "Weekday") {
                        if (p.getOccupation() != "Unemployed" && p.getOccupation() != "Retired") {
                            slot[0] = "Home";

                            // BREAKFAST
                            // include family code
                            randnum = r.nextInt(10);
                            if (randnum <= 4) {
                                randnum = 0;
                            } else {
                                randnum = r.nextInt(2) + 1;
                            }
                            switch (randnum) {
                                case 0:
                                    slot[1] = "Home";
                                    break;
                                case 1:
                                    slot[1] = "Food Court";
                                    break;
                                case 2:
                                    slot[1] = "Shop Lot";
                                    break;
                            }

                            slot[2] = work;
                            slot[3] = work;

                            // LUNCH
                            if (p.getRole() == "Toddler") {
                                slot[4] = work;
                            } else if (p.getRole() == "Student") {
                                slot[4] = work;
                            } else {
                                randnum = r.nextInt(10);
                                if (randnum <= 4) {
                                    randnum = 0;
                                } else {
                                    randnum = r.nextInt(4) + 1;
                                }
                                switch (randnum) {
                                    case 0:
                                        slot[4] = work;
                                        break;
                                    case 1:
                                        slot[4] = "Home";
                                        break;
                                    case 2:
                                        slot[4] = "Food Court";
                                        break;
                                    case 3:
                                        slot[4] = "Shop Lot";
                                        break;
                                    case 4:
                                        slot[4] = "Mall";
                                        break;
                                }
                            }

                            // LEISURE TIME
                            // can be modified
                            if (p.getRole() == "Student") {
                                randnum = r.nextInt(10);
                                if (randnum <= 6) {
                                    randnum = r.nextInt(3);
                                } else {
                                    randnum = 3;
                                }
                                switch (randnum) {
                                    case 0:
                                        slot[5] = "Home";
                                        slot[6] = "Home";
                                        slot[7] = "Home";
                                        break;
                                    case 1:
                                        slot[5] = "Field";
                                        slot[6] = "Field";
                                        slot[7] = "Home";
                                        break;
                                    case 2:
                                        slot[5] = "Playground";
                                        slot[6] = "Playground";
                                        slot[7] = "Home";
                                        break;
                                    case 3:
                                        slot[5] = "Mall";
                                        slot[6] = "Mall";
                                        slot[7] = "Home";
                                        break;
                                }
                                randnum = r.nextInt(10);
                                if (randnum <= 1) {
                                    randnum = r.nextInt(4);
                                    switch (randnum) {
                                        case 0:
                                            break;
                                        case 1:
                                            slot[5] = place.randomPlace();
                                            break;
                                        case 2:
                                            slot[6] = place.randomPlace();
                                            break;
                                        case 3:
                                            slot[7] = place.randomPlace();
                                            break;
                                    }
                                }
                            } else if (p.getRole() == "Toddler") {
                                slot[5] = "Home";
                                slot[6] = "Home";
                                slot[7] = "Home";
                                randnum = r.nextInt(2);
                                if (randnum == 0) {
                                    randnum = r.nextInt(3);
                                    switch (randnum) {
                                        case 0:
                                            slot[5] = "Playground";
                                            break;
                                        case 1:
                                            slot[6] = "Playground";
                                            break;
                                        case 2:
                                            slot[7] = "Playground";
                                            break;
                                    }
                                }
                            } else {
                                randnum = r.nextInt(100);
                                if (randnum <= 50) {
                                    slot[5] = work;
                                    slot[6] = work;
                                    randnum = r.nextInt(10);
                                    if (randnum <= 2) {
                                        slot[7] = place.randomPlace();
                                    } else {
                                        slot[7] = work;
                                    }
                                } else if (randnum > 50 && randnum <= 75) {
                                    slot[5] = "Home";
                                    slot[6] = "Home";
                                    randnum = r.nextInt(10);
                                    if (randnum <= 2) {
                                        slot[7] = place.randomPlace();
                                    } else {
                                        slot[7] = "Home";
                                    }
                                } else {
                                    randnum = r.nextInt(4);
                                    switch (randnum) {
                                        case 0:
                                            slot[5] = "Mall";
                                            slot[6] = "Mall";
                                            slot[7] = "Home";
                                            break;
                                        case 1:
                                            slot[5] = "Home";
                                            slot[6] = "Playground";
                                            slot[7] = "Playground";
                                            break;
                                        case 2:
                                            slot[5] = "Home";
                                            slot[6] = "Field";
                                            slot[7] = "Field";
                                            break;
                                        case 3:
                                            slot[5] = "Petrol Station";
                                            slot[6] = "Home";
                                            slot[7] = "Home";
                                            break;
                                    }
                                }
                            }

                            // DINNER
                            // code family into dinner and breakfast
                            randnum = r.nextInt(10);
                            if (randnum <= 4) {
                                randnum = 0;
                            } else {
                                randnum = r.nextInt(2) + 1;
                            }
                            switch (randnum) {
                                case 0:
                                    slot[8] = "Home";
                                    break;
                                case 1:
                                    slot[8] = "Shop Lot";
                                    break;
                                case 2:
                                    slot[8] = "Food Court";
                                    break;
                            }

                            slot[9] = "Home";
                            // work = true
                        } else {
                            // work = true
                            //unemployed & retired code
                            slot[0] = "Home";
                            // BREAKFAST
                            // include family code
                            randnum = r.nextInt(10);
                            if (randnum <= 4) {
                                randnum = 0;
                            } else {
                                randnum = r.nextInt(2) + 1;
                            }
                            switch (randnum) {
                                case 0:
                                    slot[1] = "Home";
                                    break;
                                case 1:
                                    slot[1] = "Food Court";
                                    break;
                                case 2:
                                    slot[1] = "Shop Lot";
                                    break;
                            }

                            //LUNCH
                            randnum = r.nextInt(10);
                            if (randnum <= 4) {
                                randnum = 0;
                            } else {
                                randnum = r.nextInt(3) + 1;
                            }
                            switch (randnum) {
                                case 0:
                                    slot[4] = "Home";
                                    break;
                                case 1:
                                    slot[4] = "Food Court";
                                    break;
                                case 2:
                                    slot[4] = "Shop Lot";
                                    break;
                                case 3:
                                    slot[4] = "Mall";
                                    break;
                            }

                            //DINNER
                            // code family into dinner and breakfast
                            randnum = r.nextInt(10);
                            if (randnum <= 4) {
                                randnum = 0;
                            } else {
                                randnum = r.nextInt(2) + 1;
                            }
                            switch (randnum) {
                                case 0:
                                    slot[8] = "Home";
                                    break;
                                case 1:
                                    slot[8] = "Shop Lot";
                                    break;
                                case 2:
                                    slot[8] = "Food Court";
                                    break;
                            }

                            // Free time
                            randnum = r.nextInt(10);
                            if (randnum <= 4) {
                                slot[2] = "Home";
                                slot[3] = "Home";
                            } else {
                                slot[2] = place.randomPlace();
                                slot[3] = slot[2];
                            }
                            randnum = r.nextInt(10);
                            if (randnum <= 4) {
                                slot[5] = "Home";
                                slot[6] = "Home";
                                slot[7] = "Home";
                            } else {
                                slot[5] = place.randomPlace();
                                slot[6] = slot[5];
                                slot[7] = place.randomPlace();
                            }

                            slot[9] = "Home";

                        }
                        // End of weekday 
                    } else if (day == "Weekend") {
                        // weekend
                        slot[0] = "Home";
                        // BREAKFAST
                        // include family code
                        randnum = r.nextInt(10);
                        if (randnum <= 4) {
                            randnum = 0;
                        } else {
                            randnum = r.nextInt(2) + 1;
                        }
                        switch (randnum) {
                            case 0:
                                slot[1] = "Home";
                                break;
                            case 1:
                                slot[1] = "Food Court";
                                break;
                            case 2:
                                slot[1] = "Shop Lot";
                                break;
                        }

                        //LUNCH
                        randnum = r.nextInt(10);
                        if (randnum <= 4) {
                            randnum = 0;
                        } else {
                            randnum = r.nextInt(3) + 1;
                        }
                        switch (randnum) {
                            case 0:
                                slot[4] = "Home";
                                break;
                            case 1:
                                slot[4] = "Food Court";
                                break;
                            case 2:
                                slot[4] = "Shop Lot";
                                break;
                            case 3:
                                slot[4] = "Mall";
                                break;
                        }

                        //DINNER
                        // code family into dinner and breakfast
                        randnum = r.nextInt(10);
                        if (randnum <= 4) {
                            randnum = 0;
                        } else {
                            randnum = r.nextInt(2) + 1;
                        }
                        switch (randnum) {
                            case 0:
                                slot[8] = "Home";
                                break;
                            case 1:
                                slot[8] = "Shop Lot";
                                break;
                            case 2:
                                slot[8] = "Food Court";
                                break;
                        }

                        if (p.getRole() == "Toddler") {
                            randnum = r.nextInt(10);
                            if (randnum <= 4) {
                                slot[5] = "Playground";
                                slot[6] = "Playground";
                                slot[7] = "Home";
                            }
                        } else if (p.getRole() == "Student") {
                            randnum = r.nextInt(2);
                            if (randnum == 0) {
                                randnum = r.nextInt(10);
                                if (randnum <= 4) {
                                    slot[5] = "Field";
                                    slot[6] = "Field";
                                    slot[7] = "Home";
                                }
                            } else {
                                randnum = r.nextInt(10);
                                if (randnum <= 4) {
                                    slot[5] = "Playground";
                                    slot[6] = "Playground";
                                    slot[7] = "Home";
                                }
                            }
                        }
                        //day
                        randnum = r.nextInt(100);
                        if (randnum <= 33) {
                            slot[2] = "Home";
                            slot[3] = "Home";
                        } else if (randnum <= 66) {
                            slot[2] = "Mall";
                            slot[3] = "Mall";
                        } else {
                            slot[2] = place.randomPlace();
                            slot[3] = slot[2];
                        }
                        //night
                        randnum = r.nextInt(100);
                        if (randnum <= 33) {
                            slot[5] = "Home";
                            slot[6] = "Home";
                            slot[7] = "Home";
                        } else if (randnum <= 66) {
                            slot[5] = "Mall";
                            slot[6] = "Mall";
                            slot[7] = "Mall";
                        } else {
                            slot[5] = place.randomPlace();
                            slot[6] = slot[5];
                            slot[7] = slot[5];
                        }
                        slot[9] = "Home";
                    }

                    //List of id act addition to arraylist
                    for (int k = 0; k < 10; k++) {
                        switch (slot[k]) {
                            case "Police":
                                act[k] = "Police Station";
                                break;
                            case "Bank Officer":
                                act[k] = "Bank";
                                break;
                            case "Healthcare Centre Worker":
                                act[k] = "Healthcare Centre";
                                break;
                            case "Bus Driver":
                                act[k] = "Bus Stop";
                                break;
                            case "Railway Worker":
                                act[k] = "Train Station";
                                break;
                            case "Mall Worker":
                                act[k] = "Mall";
                                break;
                            case "School Janitor":
                                randnum = r.nextInt(2);
                                if (randnum == 0) {
                                    act[k] = "Primary School";
                                } else {
                                    act[k] = "Secondary School";
                                }
                                break;
                            case "Teacher":
                                randnum = r.nextInt(2);
                                if (randnum == 0) {
                                    act[k] = "Primary School";
                                } else {
                                    act[k] = "Secondary School";
                                }
                                break;
                            case "Taxi Driver":
                                act[k] = place.randomPlace();
                                slot[k] = act[k];
                                break;
                            case "Priest":
                                act[k] = "Mosque";
                                break;
                            case "Restaurant Worker":
                                randnum = r.nextInt(3);
                                if (randnum == 0) {
                                    act[k] = "Food Court";
                                } else if (randnum == 1) {
                                    act[k] = "Shop Lot";
                                } else {
                                    act[k] = "Mall";
                                }
                                break;
                            case "Outside City":
                                randnum = r.nextInt(10);
                                if (randnum <= 7) {
                                    act[k] = "Train Station";
                                } else {
                                    act[k] = "Bus Stop";
                                }
                                break;
                            case "Petrol Station Worker":
                                act[k] = "Petrol Station";
                                break;
                            case "Home":
                                act[k] = p.getHome();
                                break;
                            case "School":
                                if (p.getAge() <= 12) {
                                    act[k] = "Primary School";
                                } else {
                                    act[k] = "Secondary School";
                                }
                                break;

                            default:
                                act[k] = slot[k];
                                break;
                        }
                    }
                    list.add(act);

                    //log file
                    String info = "------------------------\n";
                    info += "Human id=" + p.getId() + "\n";
                    int count = 1;
                    for (int k = 0; k < slot.length; k++) {
                        info += "Slot " + count + "=" + slot[k] + "\n";
                        logp.place(slot[k], k, p.getId(), p.getAge(), p.getHome());
                        count++;
                    }
                    log.info(info);

                }

            }
            //place
            logp.activatePlaceLog();

        } catch (SecurityException | IOException e) {
            System.out.println("Error Ocurred");
        }
    }

    public ArrayList<String[]> getList() {
        return list;
    }

    public void setDay(String s) {
        day = s;
    }
}

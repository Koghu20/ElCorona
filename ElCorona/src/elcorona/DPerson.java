package elcorona;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author koghu
 */
public class DPerson extends Data {

    private int x, y, cx, cy, p = 0;
    private int vx = 0, vy = 0;
    private int infection = 0, infD;
    private int time = 0;
    private String[] cP;
    private Random rand = new Random();
    private int[] h = new int[2];
    private int[] nP = new int[2];
    private int[] hosp = new int[2];
    private Places pl = new Places();
    private String[] list;
    private int humanID;
    private boolean sTrain = false;
    private boolean mco = false;

    public DPerson(int a) {

        humanID = a;
        cP = getAct(a);
        String s = cP[0];
        if (s.equalsIgnoreCase("Flat")) {
            x = rand.nextInt(230) + 10;
            y = rand.nextInt(120) + 10;
        } else if (s.equalsIgnoreCase("House A")) {
            x = rand.nextInt(150) + 10;
            y = rand.nextInt(170) + 250;
        } else if (s.equalsIgnoreCase("House B")) {
            x = rand.nextInt(180) + 10;
            y = rand.nextInt(160) + 550;
        } else if (s.equalsIgnoreCase("House C")) {
            x = rand.nextInt(160) + 905;
            y = rand.nextInt(100) + 400;

        }
        h[0] = x;
        h[1] = y;
        cx = x;
        cy = y;
        nextP();
    }

    public int getP() {
        return p;
    }

    public void collision(DPerson p2) {
        Rectangle per1 = new Rectangle(p2.cx, p2.cy, 10, 10);
        Rectangle per2 = new Rectangle(this.cx, this.cy, 10, 10);

        if (per1.intersects(per2)) {
            if (rand.nextInt(100) < 5) {
                if (this.infection == 1 && p2.infection == 0) { //case person 1 is infected and person 1 is not                       
                    p2.infect();
                } else if (this.infection == 0 && p2.infection == 1) { //case person 2 is infected and person 1 is
                    infect();
                }
            }
        }

    }

    public void toggleMCO() {
        if (mco == true) {
            mco = false;
        } else {
            mco = true;
        }
    }

    public void paint(Graphics g, int a) {
        time++;

        if (infection == 0) {
            g.setColor(Color.blue);
        } else if (infection == 1) {
            g.setColor(Color.red);

        } else {
            g.setColor(new Color(34, 143, 61));
        }
        int set;

        if (a < 3) {
            set = 500;
        } else if (a < 6) {
            set = 200;
        } else {
            set = 90;
        }

        if (time % set == 0) {
            if (p + 1 < cP.length) {
                p++;
                nextP();
            } else {
                p++;
            }
        }

        if (cx <= nP[0] + 10 && cx >= nP[0] - 10) {
            cx = nP[0];
            vx = 0;

        } else if (cx > nP[0]) {
            vx = -(a);
        } else {
            vx = a;
        }
        if (cy <= nP[1] + 10 && cy >= nP[1] - 10) {
            cy = nP[1];
            vy = 0;
        } else if (cy > nP[1]) {
            vy = -a;
        } else {
            vy = a;
        }
        cx += vx;
        cy += vy;
        g.fillOval(cx, cy, 5, 5);
        if (p == cP.length && humanID == 1) {
            nextSDay();
            cP = getAct(humanID);
            p = 0;
            if (infection == 1) {
                infD++;
            }
        }

        if (p == cP.length) {
            cP = getAct(humanID);
            p = 0;
            if (infection == 1) {
                infD++;
            }

        }

    }

    public void nextP() {

        if (p > cP.length) {
            p = -1;
        }
        if (p + 1 != cP.length) {

            if (infection == 1) {
                nP[0] = hosp[0];
                nP[1] = hosp[1];
                if ((getSDay() - infD) > 14) {
                    infection = 2;
                    removeInf(humanID);
                }
            } else if (mco == true && rand.nextInt(100) > 10) {
                nP[0] = h[0];
                nP[1] = h[1];
            } else if (cP[p + 1].equalsIgnoreCase("Flat") || cP[p + 1].equalsIgnoreCase("House A") || cP[p + 1].equalsIgnoreCase("House B") || cP[p + 1].equalsIgnoreCase("House C")) {
                nP[0] = h[0];
                nP[1] = h[1];
            } else {
                pl.Location(cP[p + 1]);
                nP[0] = pl.getX();
                nP[1] = pl.getY();
            }

            if (cP[p + 1].equalsIgnoreCase("Train Station") && sTrain == false) {
                tinf(humanID);
                sTrain = true;
            }
        }

    }

    public void infect() {
        infD = getSDay();
        infection = 1;
        setInfected(humanID);
        hosp[0] = rand.nextInt(110) + 270;
        hosp[1] = rand.nextInt(80) + 210;
    }

}

package elcorona;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import elcorona.Places;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;


/**
 *
 * @author koghu
 */
public class GUI extends JPanel implements ActionListener {

    private JFrame frame = new JFrame();
    private JFrame frame2 = new JFrame();
    private JLabel label = new JLabel();
    private JLabel labe2 = new JLabel();
    private JLabel day = new JLabel("Day");
    private JLabel Sspeed = new JLabel("5");
    private JPanel p = new JPanel();
    private JButton b;
    private JButton contact;
    private JButton infc = new JButton("Infect");
    private JButton pSpeed = new JButton("+");
    private JButton mSpeed = new JButton("-");
    private JButton mco = new JButton("MCO : OFF");
    private JButton info = new JButton("Information");
    private JButton map = new JButton("Map");
    private JButton skip = new JButton("Skip Day");
    private int speed = 5;
    private int c = 1;
    private static int population;
    private boolean pause = false;
    private boolean mcoS = false;
    private Data d = new Data();
    private JTextArea jt = new JTextArea();
    private JScrollPane sp = new JScrollPane();
    private ArrayList<DPerson> people = new ArrayList<>();
    private boolean infe = false;
    private String s;
    private ImageIcon icon = new ImageIcon("test.jpg");
    private ImageIcon icon1 = new ImageIcon("sunset.jpg");
    private ImageIcon icon2 = new ImageIcon("dark.jpg");
    private static ArrayList<String[]> list;


    public GUI(int a) {
        population = a;
        jt.setEditable(true);
        frame.setSize(1380, 728);
        b = new JButton("Start");
        contact = new JButton("Contact Tracer");
        contact.setBounds(50, 0, 100, 30);
        b.setBounds(50, 0, 100, 30);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jt.setBounds(200, 200, 150, 100);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (pause == false) {
                    pause = true;
                    b.setText("Start");
                } else {
                    pause = false;
                    b.setText("Pause");
                }
            }
        });
        contact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextAreaLogProgram tx = new TextAreaLogProgram();
            }
        });
        infc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infcM();
            }
        });
        pSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (speed < 9) {
                    speed++;
                }
                Sspeed.setText(Integer.toString(speed));
            }
        });
        mSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (speed > 1) {
                    speed--;
                }
                Sspeed.setText(Integer.toString(speed));

            }
        });
        map.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame m = new JFrame("Map");
                m.setContentPane(new JLabel(new ImageIcon("map.png")));
                m.setSize(1062, 700);
                m.setVisible(true);
            }
        });
        skip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.nextSDay();
            }
        });
        mco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (mcoS == false) {
                    mcoS = true;
                    mco.setText("MCO : ON");
                } else {
                    mcoS = false;
                    mco.setText("MCO : OFF");
                }
                for (int i = 0; i < population; i++) {
                    people.get(i).toggleMCO();
                }

            }
        });

        label.setFont(new Font("Serif", Font.PLAIN, 16));
        labe2.setFont(new Font("Serif", Font.PLAIN, 16));
        day.setFont(new Font("Serif", Font.PLAIN, 16));
        Timer t = new Timer(60, this);
        t.restart();
        label.setText("Day");
        labe2.setText("Population: ");
        p.add(skip);
        p.add(mco);
        p.add(map);
        p.add(Sspeed);
        p.add(day);
        p.add(label);
        p.add(b);
        p.add(contact);
        p.add(labe2);
        p.add(infc);
        p.add(pSpeed);
        p.add(mSpeed);
        p.setLayout(null);

        sp.setViewportView(jt);
        p.add(sp);
        p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        p.setBackground(Color.lightGray);
        p.setPreferredSize(new Dimension(300, 720));
        frame.add(p, BorderLayout.EAST);
        frame.add(this);
        frame.setVisible(true);

        for (int i = 0; i < population; i++) {
            people.add(new DPerson(i + 1));

        }
        jt.setText(d.getInfected());
        label.setText("Day: " + d.getSDay());
        labe2.setText("Population: " + population);
        String s = d.getDay();
        day.setText(s);
        Sspeed.setText(Integer.toString(speed));
    }

    public void paint(Graphics g) {
        c++;
        super.paintComponent(g);
        int z = people.get(0).getP();
        if (z >= 2 && z < 6) {
            icon.paintIcon(this, g, 0, 0);
        } else if (z < 2 || z > 7) {
            icon2.paintIcon(this, g, 0, 0);
        } else {
            icon1.paintIcon(this, g, 0, 0);
        }
        Places p1 = new Places(g);
        for (DPerson p : people) {
            p.paint(g, speed);
        }

        ArrayList<Integer> temp = d.Inf();
        for (int j = 0; j < temp.size(); j++) {
            int t = temp.get(j);
            for (int i = 0; i < people.size(); i++) {
                people.get(t).collision(people.get(i));
            }

        }
    }

    public void infcM() {
        JFrame parent = new JFrame();

        int slot = Integer.parseInt(JOptionPane.showInputDialog(parent,
                "Enter the Human ID to be infected", null));
        people.get(slot - 1).infect();

    }

    public void tInf() {
        Random rand = new Random();

        ArrayList<Integer> temp = d.gT();
        if(temp!=null){
            System.out.println(temp.size());
            int i = rand.nextInt(temp.size());
            people.get(temp.get(i)).infect();
        }else{
            people.get(rand.nextInt(population)).infect();
        }
        infe = true;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (pause == false) {
            b.setText("Pause");
            repaint();
            jt.setText(d.getInfected());
            label.setText("Day: " + d.getSDay());
            labe2.setText("Population: " + population);
            String s = d.getDay();
            day.setText(s);
        } else {
            b.setText("Start");
        }

        if (d.getSDay() > 15 && infe == false) {
            tInf();
        }

        Sspeed.setBounds(150, 250, 50, 50);
        pSpeed.setBounds(190, 250, 50, 50);
        mSpeed.setBounds(80, 250, 50, 50);
        map.setBounds(70, 320, 70, 30);
        mco.setBounds(150, 320, 100, 30);
        skip.setBounds(110, 355, 100, 30);
        infc.setBounds(90, 200, 130, 30);
        labe2.setBounds(110, 40, 200, 100);
        label.setBounds(130, 30, 100, 30);
        day.setBounds(125, 45, 300, 50);
        b.setBounds(90, 120, 130, 30);
        contact.setBounds(90, 160, 130, 30);
        sp.setBounds(60, 400, 200, 250);

    }

}

package elcorona;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author koghu
 */
public class Home extends JFrame {

//    Image img = Toolkit.getDefaultToolkit().getImage("D:\\unknown.jpg");
    private static int p;
    public Home() {
       
         setContentPane(new JLabel(new ImageIcon("unknown.jpg")));

        
        this.setSize(520, 340);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        JButton start = new JButton("Start");
        JLabel label = new JLabel("Enter number of Household");
        setLayout(null);
//        add(start);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        start.setBounds(200, 250, 100, 30);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input();
            }
        });
    }
    
    public static int houseNUM(){
        return p;
    }

    public int input() {
        JFrame f = new JFrame();
        int slot = Integer.parseInt(JOptionPane.showInputDialog(f,
                "Enter the number of Household to Start", null));
        setVisible(false);
        p=slot;
        return slot;
    }

}

package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinnumber;
    JButton back;
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,710,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,710);
        add(image);

        back = new JButton("Back");
        back.setBounds(365,402,150,30);
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();
        int balance =0;
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where PIN_Number ='"+pinnumber+"'");

            while (rs.next()){
                if(rs.getString("Type").equals("Deposit") ){
                    balance+= Integer.parseInt(rs.getString("Amount"));
                }
                else {
                    balance -=Integer.parseInt(rs.getString("Amount"));
                }
            }
            JLabel text = new JLabel("Your Current Account Balance is Rs "+balance);
            text.setForeground(Color.white);
            text.setBounds(170,300,400,15);
            image.add(text);

        }catch (Exception qe){
            qe.printStackTrace();
        }


        setBounds(200,0,900,710);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transaction(pinnumber);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}

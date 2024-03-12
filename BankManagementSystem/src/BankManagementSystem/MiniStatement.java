package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    MiniStatement(String pinnumber){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setTitle("Mini Statement");

         JLabel mini = new JLabel();
         add(mini);

         JLabel bank = new JLabel("DCU Bank");
         bank.setFont(new Font("System", Font.BOLD,30));
         bank.setForeground(Color.red);
         bank.setBounds(120,20,300,25);
         add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM login where PIN_Number ='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number : " + rs.getString("Card_Number").substring(0,4)+"XXXXXXX"+rs.getString("Card_Number").substring(12));

            }
        }catch(Exception ek){
            ek.printStackTrace();
        }

        try {
            Conn c = new Conn();
            int bal =0;
            ResultSet rs = c.s.executeQuery("select * from bank where PIN_Number ='"+pinnumber+"'");

            while (rs.next()) {
                mini.setText(mini.getText()+"<html>"+rs.getString("Deposit_Date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Amount")+"<br><br></html>");
                if(rs.getString("Type").equals("Deposit") ){
                    bal+= Integer.parseInt(rs.getString("Amount"));
                }
                else {
                    bal -=Integer.parseInt(rs.getString("Amount"));
                }
            }

            balance.setText("Your Current Balance is Rs "+bal);
        }catch(Exception ep){
            ep.printStackTrace();
        }
        mini.setBounds(20,140,400,200);


        setBounds(20,20,400,600);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}

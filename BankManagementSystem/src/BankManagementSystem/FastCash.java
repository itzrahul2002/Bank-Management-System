package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton deposit,withdraw,fastcash,ministatemet,pinchange,balanceenqueriy,exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(180,220,700,35);
        text.setForeground(Color.red);
        text.setFont(new Font("System", Font.BOLD,20));
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.addActionListener(this);
        deposit.setBounds(160,330,150,30);
        image.add(deposit);

        withdraw = new JButton("Rs 500");
        withdraw.addActionListener(this);
        withdraw.setBounds(350 ,330,150,30);
        image.add(withdraw);

        fastcash = new JButton("Rs 1000");
        fastcash.addActionListener(this);
        fastcash.setBounds(160,370,150,30);
        image.add(fastcash);

        ministatemet = new JButton("Rs 2000");
        ministatemet.addActionListener(this);
        ministatemet.setBounds(350,370,150,30);
        image.add(ministatemet);

        pinchange = new JButton("Rs 5000");
        pinchange.addActionListener(this);
        pinchange.setBounds(160,410,150,30);
        image.add(pinchange);


        balanceenqueriy = new JButton("Rs 10000");
        balanceenqueriy.setBounds(350,410,150,30);
        balanceenqueriy.addActionListener(this);
        image.add(balanceenqueriy);

        exit = new JButton("BACK");
        exit.setBackground(Color.black);
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        exit.setBounds(440,460,100,32);
        image.add(exit);







        setBounds(200,0,900,710);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            setVisible(false);
            new Transaction(pinnumber);
        }else{
           String amount = ((JButton)e.getSource()).getText().substring(3);
           Conn c = new Conn();
           try{
               ResultSet rs = c.s.executeQuery("select * from bank where PIN_Number ='"+pinnumber+"'");
               int balance =0;
               while (rs.next()){
                   if(rs.getString("Type").equals("Deposit") ){
                       balance+= Integer.parseInt(rs.getString("Amount"));
                   }
                   else {
                       balance -=Integer.parseInt(rs.getString("Amount"));
                   }
               }

               if(e.getSource()!=exit && balance <Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null, "Insufficient Balance");
                   return;
               }
               Date date = new Date();
               String query ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Rs "+amount+"Debited Successfully ✅");
               setVisible(false);
               new Transaction(pinnumber);
           }catch (Exception qe){
               qe.printStackTrace();
           }
        }
    }
    public static void main(String[] args) {
        new FastCash(" ");
    }
}

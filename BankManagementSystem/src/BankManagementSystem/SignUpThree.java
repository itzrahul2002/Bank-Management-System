package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String fornmno;
    SignUpThree(String fornmno){
        this.fornmno=fornmno;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD,25));
        l1.setBounds(280,15,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD,22));
        type.setBounds(100,90,200,30);
        add(type);

        r1 = new JRadioButton("Saving Account ");
        r1.setBounds(100,140,200,20);
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("Raleway", Font.BOLD,16));
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBounds(350,140,200,20);
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("Raleway", Font.BOLD,16));
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setBounds(100,170,200,20);
        r3.setBackground(Color.WHITE);
        r3.setFont(new Font("Raleway", Font.BOLD,16));
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350,170,300,20);
        r4.setBackground(Color.WHITE);
        r4.setFont(new Font("Raleway", Font.BOLD,16));
        add(r4);

        ButtonGroup groupaccunt = new ButtonGroup();
        groupaccunt.add(r1);
        groupaccunt.add(r2);
        groupaccunt.add(r3);
        groupaccunt.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD,22));
        card.setBounds(100,230,200,30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-0420");
        number.setFont(new Font("Raleway", Font.BOLD,22));
        number.setBounds(330,235,300,30);
        add(number);

        JLabel carddeatil = new JLabel("Your 16 Digit Card Number");
        carddeatil.setFont(new Font("Raleway", Font.BOLD,12));
        carddeatil.setBounds(100,255,200,20);
        add(carddeatil);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        pin.setBounds(100,300,200,30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD,22));
        pnumber.setBounds(330,305,300,30);
        add(pnumber);

        JLabel pindetail = new JLabel("Your 4 Digit PIN Number");
        pindetail.setFont(new Font("Raleway", Font.BOLD,12));
        pindetail.setBounds(100,325,200,20);
        add(pindetail);

        JLabel services = new JLabel("Services Required :");
        services.setFont(new Font("Raleway", Font.BOLD,18));
        services.setBounds(100,360,200,20);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD,16));
        c1.setBounds(100,400,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD,16));
        c2.setBounds(350,400,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD,16));
        c3.setBounds(100,450,200,30);
        add(c3);


        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD,16));
        c4.setBounds(350,450,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD,16));
        c5.setBounds(100,500,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD,16));
        c6.setBounds(350,500,200,30);
        add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my Knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD,16));
        c7.setBounds(50,550,800,30);
        add(c7);


        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(250,600,120,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(420,600,120,30);
        cancel.addActionListener(this);
        add(cancel);


        setBounds(250,0,850,680);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType ="Saving Account";
            }else if(r2.isSelected()){
                accountType ="Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType ="Current Account";
            }else if(r4.isSelected()){
                accountType ="Reccurring Deposit Account";
            }

            Random random = new Random();
            String cardnumber= ""+Math.abs((random.nextLong() % 900000L) + 50403600024200L);

            String pinnumber =""+Math.abs((random.nextLong() % 9000L)+1000L);

            String facility ="";
            if(c1.isSelected()){
                facility = facility+" ATM Card";
            }else if(c2.isSelected()){
                facility = facility+" Internet Banking";
            }else if(c3.isSelected()){
                facility = facility+"Mobile Banking";
            }else if(c4.isSelected()){
                facility = facility+"Email  & SMS Alerts";
            }else if(c5.isSelected()){
                facility = facility+"E-Statement";
            }

            try {
                if (accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type Required ⚠️");
                }else {
                    Conn c = new Conn();
                    String query ="insert into sign_up_three values('"+fornmno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query1 ="insert into Login values('"+fornmno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);

                    JOptionPane.showMessageDialog(null, "Card Number "+cardnumber+"\n PIN"+pinnumber);

                }
            }catch (Exception ea){
                ea.printStackTrace();
            }

        }else if(e.getSource()==cancel){
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new SignUpThree("");
    }
}

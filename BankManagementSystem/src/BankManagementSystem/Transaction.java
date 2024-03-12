package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit,withdraw,fastcash,ministatemet,pinchange,balanceenqueriy,exit;
    String pinnumber;
    Transaction(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);

        JLabel text = new JLabel("Please select Your Transaction");
        text.setBounds(180,220,700,35);
        text.setForeground(Color.red);
        text.setFont(new Font("System", Font.BOLD,20));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.addActionListener(this);
        deposit.setBounds(160,330,150,30);
        image.add(deposit);

        withdraw = new JButton("Cash Withdrawl");
        withdraw.addActionListener(this);
        withdraw.setBounds(350 ,330,150,30);
        image.add(withdraw);

        fastcash = new JButton("Fast Cash");
        fastcash.addActionListener(this);
        fastcash.setBounds(160,370,150,30);
        image.add(fastcash);

        ministatemet = new JButton("Mini Statement");
        ministatemet.addActionListener(this);
        ministatemet.setBounds(350,370,150,30);
        image.add(ministatemet);

        pinchange = new JButton("PIN Change");
        pinchange.addActionListener(this);
        pinchange.setBounds(160,410,150,30);
        image.add(pinchange);


        balanceenqueriy = new JButton("Balance Enquiry");
        balanceenqueriy.setBounds(350,410,150,30);
        balanceenqueriy.addActionListener(this);
        image.add(balanceenqueriy);

        exit = new JButton("EXIT");
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
            System.exit(0);
        } else if (e.getSource()==deposit) {
            setVisible(false);
            new Deposit(pinnumber);
        } else if (e.getSource()==withdraw) {
            setVisible(false);
            new Withdrawl(pinnumber);
        } else if (e.getSource()==fastcash) {
            setVisible(false);
            new FastCash(pinnumber);
        }else if (e.getSource()==pinchange){
           setVisible(false);
           new PinChange(pinnumber);
        } else if (e.getSource()==balanceenqueriy) {
            setVisible(false);
            new BalanceEnquiry(pinnumber);
        } else if (e.getSource()==ministatemet) {

            new MiniStatement(pinnumber);

        }
    }
    public static void main(String[] args) {
        new Transaction(" ");
    }
}

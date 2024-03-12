package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pinnumber;
    JButton deposit, back;
    JTextField amount;
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,685,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,685);
        add(image);

        JLabel text = new JLabel("Enter the Amount You Want to Deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,220,400,30);
        image.add(text);

        amount = new JTextField ();
        amount.setFont(new Font("System",Font.BOLD,22));
        amount.setBounds(170,260,300,30);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.addActionListener(this);
        deposit.setBounds(360,348,150,32);
        image.add(deposit);


        back = new JButton("BACK");
        back.addActionListener(this);
        back.setBounds(360,386,150,32);
        image.add(back);


        setBounds(200,0,900,710);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==deposit){
            setVisible(false);
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Deposit");
            }
            else {
                try {
                    Conn c = new Conn();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";

                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs"+number+"Deposited Successfully 🆗");
                    setVisible(true);
                    new Transaction(pinnumber);
                }catch (Exception ze){
                    ze.printStackTrace();
                }
            }
        }else if(e.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber);
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}

package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame  implements ActionListener {
    JButton signup,clear,login;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        getContentPane().setBackground(new Color(173, 216, 230) );
        setLayout(null);

        setTitle("AUTOMATED TALLER MACHINE");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hdfc.gif"));
        Image i2 = i1.getImage().getScaledInstance(150,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(50,-40,150,200);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD,45));
        text.setBounds(250,40,400,40);
        add(text);

        JLabel cardno = new JLabel("Card No :");
        cardno.setFont(new Font("Raleway", Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.setBounds(300,300,100,30);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.setBounds(450,300,100,30);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.setBounds(300,350,250,30);
        signup.addActionListener(this);
        add(signup);







        setBounds(250,100,800,480);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            Conn c = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query ="select * from login where Card_Number ='"+cardnumber+"'and PIN_Number ='"+pinnumber+"'";

            try {
               ResultSet rs = c.s.executeQuery(query);
               if (rs.next()) {
                   setVisible(false);
                   new Transaction(pinnumber);
               }else{
                   JOptionPane.showMessageDialog(null, "Incorrect Card Number & PIN ❌");
               }

            }catch (Exception eq){
                eq.printStackTrace();
            }
        }else if(e.getSource()==signup){
            setVisible(false);
            new SignupOne();
        }else if(e.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}

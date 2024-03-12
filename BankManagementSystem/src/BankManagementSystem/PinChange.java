package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JButton change,back;
    JPasswordField pin,repin;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,710,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,710);
        add(image);

        JLabel text = new JLabel("Change Your PIN");
        text.setForeground(Color.red);
        text.setFont(new Font("System", Font.BOLD,25));
        text.setBounds(220,210,500,35);
        image.add(text);


        JLabel newPintext = new JLabel( "New PIN");
        newPintext.setForeground(Color.white);
        newPintext.setFont(new Font("System", Font.BOLD,16));
        newPintext.setBounds(165,260,100,25);
        image.add(newPintext);

        JLabel repintext = new JLabel("Re-Enter PIN");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System", Font.BOLD,16));
        repintext.setBounds(165,300,150,25);
        image.add(repintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD,25));
        pin.setBounds(330,260,180,25);
        image.add(pin);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD,25));
        repin.setBounds(330,300,180,25);
        image.add(repin);

        change= new JButton("CHNAGE");
        change.setBounds(165,380,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355,380,150,30);
        back.addActionListener(this);
        image.add(back);

        setBounds(200,0,900,710);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Enter PIN Doesn't Match 📰");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter New PIN  📰");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter RE-PIN 📰");
                    return;
                }
                Conn c = new Conn();
                String query1="update bank set PIN_Number ='"+rpin+"' where PIN_Number = '"+pinnumber+"'";
                String query2="update login set PIN_Number ='"+rpin+"' where PIN_Number = '"+pinnumber+"'";
                String query3="update sign_up_three set PIN_Number ='"+rpin+"' where PIN_Number = '"+pinnumber+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully ");

                setVisible(false);

            } catch (Exception re) {
                re.printStackTrace();
            }
        }
        else {
            setVisible(false);
            new Transaction(pinnumber);
        }
    }
    public static void main(String[] args) {
        new PinChange("");
    }
}

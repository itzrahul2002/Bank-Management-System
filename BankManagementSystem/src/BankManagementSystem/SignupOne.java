package BankManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupOne extends JFrame implements ActionListener {
    Long random;
    JTextField nameTextfield,fnameTextfield,emailTextfield,addressTextfield,cityTextfield,pinTextfield;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser dateChooser;
    JButton next;
    SignupOne(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Random ran = new Random();
        random= (Math.abs(ran.nextLong() % 900l)+ 1000L);

        JLabel formo = new JLabel("APPLICATION FORM NO. "+random);
        formo.setFont(new Font("Raleway", Font.BOLD,38));
        formo.setBounds(140,10,600,40);
        add(formo);

        JLabel  personalDetails= new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        personalDetails.setBounds(290,60,400,40);
        add(personalDetails);

        JLabel  name= new JLabel("Name :");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextfield = new JTextField();
        nameTextfield.setFont(new Font("Raleway", Font.BOLD,14));
        nameTextfield.setBounds(300,140,400,30);
        add(nameTextfield);

        JLabel fname= new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100,190,220,30);
        add(fname);


        fnameTextfield = new JTextField();
        fnameTextfield.setFont(new Font("Raleway", Font.BOLD,14));
        fnameTextfield.setBounds(300,190,400,30);
        add(fnameTextfield);

        JLabel dob= new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setFont(new Font("Raleway", Font.BOLD,14));
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,240,400,30);
        add(dateChooser);

        JLabel gender= new JLabel("Gender :");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100,290,100,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);


        female = new JRadioButton("Female");
        female.setBounds(450,290,100,30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gedergroup = new ButtonGroup();
        gedergroup.add(male);
        gedergroup.add(female);

        JLabel email= new JLabel("Email Address :");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextfield = new JTextField();
        emailTextfield.setFont(new Font("Raleway", Font.BOLD,14));
        emailTextfield.setBounds(300,340,400,30);
        add(emailTextfield);

        JLabel marital= new JLabel("Marital Status :");
        marital.setFont(new Font("Raleway", Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);


        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        JLabel address= new JLabel("Address :");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100,440,100,30);
        add(address);

        addressTextfield = new JTextField();
        addressTextfield.setFont(new Font("Raleway", Font.BOLD,14));
        addressTextfield.setBounds(300,440,400,30);
        add(addressTextfield);


        JLabel city= new JLabel("City :");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100,490,100,30);
        add(city);

        cityTextfield = new JTextField();
        cityTextfield.setFont(new Font("Raleway", Font.BOLD,14));
        cityTextfield.setBounds(300,490,400,30);
        add(cityTextfield);

        JLabel pincode= new JLabel("Pin Code :");
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(100,540,200,30);
        add(pincode);

        pinTextfield = new JTextField();
        pinTextfield.setFont(new Font("Raleway", Font.BOLD,14));
        pinTextfield.setBounds(300,540,400,30);
        add(pinTextfield);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(600,590,100,30);
        next.addActionListener(this);
        add(next);



        setBounds(250,5,850,675);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = ""+random;
        String name = nameTextfield.getText();
        String fname = fnameTextfield.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender ="Male";
        }
        else if(female.isSelected()){
            gender ="Female";
        }
        String email = emailTextfield.getText();
        String marital =null;
        if(male.isSelected()){
            marital ="Married";
        }else if(female.isSelected()){
            marital ="Ummarried";
        }else if(other.isSelected()){
            marital ="Other";
        }
        String address = addressTextfield.getText();
        String city = cityTextfield.getText();
        String pin = pinTextfield.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Data FillUp is Required");
            }else {
                Conn c = new Conn();
                String query = "insert into sing_up values('"+formno+"','"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno);
            }

        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new SignupOne();
    }
}

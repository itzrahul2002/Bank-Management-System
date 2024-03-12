package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField pan,aadhar;
    JRadioButton yes,no;

    JComboBox education,income,category,occupation,religion;
    JButton next;
    String fromno;
    SignupTwo(String fromno){
        this.fromno= fromno;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2 "+fromno);


        JLabel  AdditionalDetails= new JLabel("Page 1 : Additional Details");
        AdditionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        AdditionalDetails.setBounds(290,60,400,40);
        add(AdditionalDetails);

        JLabel  name= new JLabel("Religion :");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        String valreligion[] ={"Hindu","Sanatani","Hindu","Sanatani","Hindu","Sanatani"};
        religion= new JComboBox(valreligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname= new JLabel("Category :");
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100,190,220,30);
        add(fname);

        String valcategory[] ={"General","SC","OBC","ST","Other"};
        category= new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);


        JLabel dob= new JLabel("Income :");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String incomecategory[] ={"Null","< 1,50,000","< 2,50,000","<5,00,000","Upto 10,00,000"};
        income= new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);


        JLabel Educational= new JLabel("Educational");
        Educational.setFont(new Font("Raleway", Font.BOLD,20));
        Educational.setBounds(100,290,150,30);
        add(Educational);


        JLabel Qualification= new JLabel("Qualification:");
        Qualification.setFont(new Font("Raleway", Font.BOLD,20));
        Qualification.setBounds(100,315,200,30);
        add(Qualification);

        String edcationvalues[] ={"Non-Graduation","Graduation","Post-Graduation","Others"};
        education= new JComboBox(edcationvalues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);


        JLabel marital= new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        String occupationValues[] ={"Salaried","Self-Employed","Un-Employed","Student","Retired","Other"};
        occupation= new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address= new JLabel("PAN Number");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100,440,150,30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);


        JLabel Aadhar= new JLabel("Aadhar Number");
        Aadhar.setFont(new Font("Raleway", Font.BOLD,20));
        Aadhar.setBounds(100,490,150,30);
        add(Aadhar);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);

        JLabel Account= new JLabel("Existing Account");
        Account.setFont(new Font("Raleway", Font.BOLD,20));
        Account.setBounds(100,540,200,30);
        add(Account);

        yes = new JRadioButton("YES");
        yes.setBounds(300,540,60,30);
        yes.setBackground(Color.WHITE);
        add(yes);


        no = new JRadioButton("NO");
        no.setBounds(390,540,100,30);
        no.setBackground(Color.white);
        add(no);

        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(yes);
        accountgroup.add(no);



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
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sIcomename = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String existingaccount = null;
        if(yes.isSelected()){
            existingaccount ="YES";
        }
        else if(no.isSelected()){
            existingaccount ="NO";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();

        try{
            Conn c = new Conn();
            String query = "insert into sing_up_Two values('"+fromno+"','"+sreligion+"', '"+scategory+"', '"+sIcomename+"', '"+seducation+"', '"+soccupation+"', '"+existingaccount+"', '"+span+"', '"+saadhar+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignUpThree(fromno);

        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new SignupTwo("");
    }
}

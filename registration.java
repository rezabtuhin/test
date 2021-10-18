import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registration extends JFrame {
    JFrame frame = new JFrame("Registration");
    JLabel name,birthday,gender,email,password,retype,status;
    JTextField nameTf,emailTf;
    JPasswordField pass,retypePass;
    JButton clear,validate,register;
    JRadioButton male,female,other;
    JComboBox day,month,year;
    ButtonGroup group;
    String genderX = null;
    String res = "Validation results";

    public registration(){
        frame.setSize(600,400);
        frame.setLocation(200,50);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        name = new JLabel("Name");
        birthday = new JLabel("Birthday");
        gender = new JLabel("Gender");
        email = new JLabel("Email");
        password = new JLabel("Password");
        retype = new JLabel("Retype");
        name.setBounds(30,30,40,20);
        birthday.setBounds(30,70,50,20);
        gender.setBounds(30,110,50,20);
        email.setBounds(30,150,50,20);
        password.setBounds(30,190,90,20);
        retype.setBounds(320,190,50,20);
        frame.add(name);
        frame.add(birthday);
        frame.add(gender);
        frame.add(email);
        frame.add(password);
        frame.add(retype);

        nameTf = new JTextField();
        nameTf.setBounds(120,30,150,20);
        frame.add(nameTf);
        emailTf = new JTextField();
        emailTf.setBounds(120,150,150,20);
        frame.add(emailTf);
        pass = new JPasswordField();
        pass.setBounds(120,190,150,20);
        frame.add(pass);
        retypePass = new JPasswordField();
        retypePass.setBounds(400,190,150,20);
        frame.add(retypePass);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");
        group = new ButtonGroup();
        group.add(male);
        group.add(female);
        group.add(other);
        male.setBounds(120,110,70,20);
        frame.add(male);
        female.setBounds(200,110,70,20);
        frame.add(female);
        other.setBounds(280,110,70,20);
        frame.add(other);
        male.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genderX = "male";
            }
        });
        female.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genderX = "female";
            }
        });
        other.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genderX = "other";
            }
        });

        String[] months = {"month","January","February","March",
                "April","May","June","July","August",
                "September","October","November","December"};
        String[] days = new String[32];
        days[0] = "day";
        for (int i = 1; i < days.length; i++) {
            days[i] = String.valueOf(i);
        }
        String[] years = new String[102];
        int start = 1921;
        years[0] = "year";
        for (int i = 1; i < years.length; i++) {
            years[i] = String.valueOf(start);
            start++;
        }
        day = new JComboBox(days);
        day.setBounds(120,70,100,20);
        frame.add(day);
        month = new JComboBox(months);
        month.setBounds(240,70,100,20);
        frame.add(month);
        year = new JComboBox(years);
        year.setBounds(360,70,100,20);
        frame.add(year);
        clear = new JButton("Clear");
        clear.setBounds(150,250,70,40);
        clear.setBackground(Color.blue);
        clear.setForeground(Color.white);
        frame.add(clear);
        validate = new JButton("Validate");
        validate.setBounds(250,250,90,40);
        validate.setBackground(Color.blue);
        validate.setForeground(Color.white);
        frame.add(validate);
        register = new JButton("Register");
        register.setBounds(370,250,90,40);
        register.setBackground(Color.blue);
        register.setForeground(Color.white);
        frame.add(register);

        status = new JLabel("Status: "+res);
        status.setBounds(30,320,250,20);
        frame.add(status);
        frame.setVisible(true);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                day.setSelectedIndex(0);
                month.setSelectedIndex(0);
                year.setSelectedIndex(0);
                nameTf.setText("");
                emailTf.setText("");
                pass.setText("");
                retypePass.setText("");
                res = "Validation results";
                status.setText("Status: "+res);
            }
        });
        validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nameTf.getText().equals("")){
                    res = "Status: Name Missing";
                    status.setText(res);
                }
                else if(day.getSelectedIndex() == 0){
                    res = "Status: Day Missing";
                    status.setText(res);
                }
                else if(month.getSelectedIndex() == 0){
                    res = "Status: Month Missing";
                    status.setText(res);
                }
                else if(year.getSelectedIndex() == 0){
                    res = "Status: Year Missing";
                    status.setText(res);
                }
                else if(!male.isSelected() && !female.isSelected() && !other.isSelected()){
                    res = "Status: Select Gender";
                    status.setText(res);
                }
                else if(emailTf.getText().equals("")){
                    res = "Status: Email Missing";
                    status.setText(res);
                }
                else if(pass.getText().equals("")){
                    res = "Status: Password Missing";
                    status.setText(res);
                }
                else if(retypePass.getText().equals("")){
                    res = "Status: Retype Password Missing";
                    status.setText(res);
                }
                else if(!pass.getText().equals(retypePass.getText())){
                    res = "Status: Password didn't match";
                    status.setText(res);
                }
                else{
                    res = "Validation Successful";
                    status.setText("Status: "+res);
                }
            }
        });
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(res.equals("Validation Successful")){
                    JOptionPane.showMessageDialog(frame,"Name: "+nameTf.getText()+"\nBirthday: "
                            +day.getSelectedItem()+"th "
                            +month.getSelectedItem()+", "+year.getSelectedItem()
                    +"\nGender: "+genderX+"\nEmail: "+emailTf.getText());
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Validate Your Entry First.");
                }
            }
        });
    }
    public static void main(String[] args) {
        new registration();
    }
}
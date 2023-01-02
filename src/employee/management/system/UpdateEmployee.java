
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
 
    
    JTextField tfeducation,tffname,tfsalary,tfaddress,tfphone,tfemail,tfdsg;
    JLabel lblemp;
    JButton add,back;
    String empId;
    
    
    UpdateEmployee(String empId){
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(50,150,150,30);
        lblname.setFont(new Font("serif",Font.PLAIN,20));
        add(lblname);
        
        JLabel tfname = new JLabel();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        JLabel fname = new JLabel("FATHER'S NAME");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("serif",Font.PLAIN,20));
        add(fname);
        
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        JLabel lbldob = new JLabel("DATE OF BIRTH");
        lbldob.setBounds(50,200,150,30);
        lbldob.setFont(new Font("serif",Font.PLAIN,20));
        add(lbldob);
        
        JLabel dcdob = new JLabel();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);

        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(400,200,150,30);
        lblsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(lblsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        JLabel lbladdress = new JLabel("ADDRESS");
        lbladdress.setBounds(50,250,150,30);
        lbladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(400,250,150,30);
        lblphone.setFont(new Font("serif",Font.PLAIN,20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setBounds(50,300,150,30);
        lblemail.setFont(new Font("serif",Font.PLAIN,20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        JLabel lbledu = new JLabel("HIGHEST EDUCATION");
        lbledu.setBounds(400,300,150,30);
        lbledu.setFont(new Font("serif",Font.PLAIN,20));
        add(lbledu);
        
        
        tfeducation = new JTextField();
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
        JLabel lbldsg = new JLabel("DESIGNATION");
        lbldsg.setBounds(50,350,150,30);
        lbldsg.setFont(new Font("serif",Font.PLAIN,20));
        add(lbldsg);
        
        tfdsg = new JTextField();
        tfdsg.setBounds(200,350,150,30);
        add(tfdsg);
        
        JLabel lbladhr = new JLabel("AADHAR NO.");
        lbladhr.setBounds(400,350,150,30);
        lbladhr.setFont(new Font("serif",Font.PLAIN,20));
        add(lbladhr);
        
        JLabel tfadhr = new JLabel();
        tfadhr.setBounds(600,350,150,30);
        add(tfadhr);
        
        JLabel lblempid = new JLabel("EMPLOYEE ID");
        lblempid.setBounds(50,400,150,30);
        lblempid.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempid);
        
        lblemp = new JLabel();
        lblemp.setBounds(200,400,150,30);
        lblemp.setFont(new Font("serif",Font.PLAIN,20));
        add(lblemp);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empID = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                tfname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                dcdob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfeducation.setText(rs.getString("education"));
                tfemail.setText(rs.getString("email"));
                tfdsg.setText(rs.getString("designation"));
                tfadhr.setText(rs.getString("aadhar"));
                lblemp.setText(rs.getString("empID"));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(250,550,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("BACK");
        back.setBounds(450,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            String education = tfeducation.getText();
            String designation = tfdsg.getText();
            
            
            try{
                Conn conn = new Conn();
                String query = "update employee set fname = '"+fname+"',salary = '"+salary+"',address = '"+address+"',phone = '"+phone+"',email = '"+email+"',education = '"+education+"',designation = '"+designation+"' where empID = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated successfully");
                setVisible(false);
                new Home();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource()== back){
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args){
        new UpdateEmployee("");
    }
}

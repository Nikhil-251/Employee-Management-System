
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    
    Choice cEmpId;
    JButton delete,back;
    
    RemoveEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblempId = new JLabel("Employee ID");
        lblempId.setBounds(50,50,100,30);
        add(lblempId);
        
        cEmpId = new Choice();
        cEmpId.setBounds(200,50,150,30);
        add(cEmpId);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                cEmpId.add(rs.getString("empID"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,100,100,30);
        add(lblname);
        
        JLabel tfname = new JLabel();
        tfname.setBounds(200,100,100,30);
        add(tfname);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(50,150,100,30);
        add(lblphone);
        
        JLabel tfphone = new JLabel();
        tfphone.setBounds(200,150,100,30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50,200,100,30);
        add(lblemail);
        
        JLabel tfemail = new JLabel();
        tfemail.setBounds(200,200,100,30);
        add(tfemail);
        
        try{
                    Conn c = new Conn();
                    String query = "select * from employee where empID = '"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        tfname.setText(rs.getString("name"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                    }
            
                    while(rs.next()){
                        cEmpId.add(rs.getString("empID"));
                    }
        }
        catch(Exception e){
                e.printStackTrace();
        }
        
        cEmpId.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "select * from employee where empID = '"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        tfname.setText(rs.getString("name"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                    }
            
                    while(rs.next()){
                        cEmpId.add(rs.getString("empID"));
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,600,400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300,150);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == delete){
            try{
                Conn c = new Conn();
                String query = "delete from employee where empID = '"+cEmpId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Information Deleted Successfully");
                setVisible(false);
                new Home();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args){
        new RemoveEmployee();
    }
}

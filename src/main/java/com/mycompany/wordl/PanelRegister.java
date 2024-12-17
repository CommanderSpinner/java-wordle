package com.mycompany.wordl;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelRegister extends JPanel{
    JButton btn_Register;
    JTextField txt_NickName;
    JTextField txt_Password;
    
    JLabel ueberschrift;
    
    JLabel label_NickName;
    JLabel label_Password;
    
    public PanelRegister(){
        btn_Register = new JButton("Registrieren");
        txt_NickName = new JTextField();
        txt_Password = new JTextField();
        
        ueberschrift = new JLabel();
        ueberschrift.setText("Registrierung");
        ueberschrift.setBounds(190, 50, 1000, 30);
        ueberschrift.setFont(ueberschrift.getFont().deriveFont(24f));
        this.add(ueberschrift);
        
        label_NickName = new JLabel("Nick name");
        label_Password = new JLabel("Password");
        
        this.setLayout(null);
        btn_Register.setBounds(200, 220, 150, 20);
        txt_Password.setBounds(200, 200, 150, 20);
        txt_NickName.setBounds(200, 160, 150, 20);
        
        
        label_NickName.setBounds(200, 140, 100, 20);
        label_Password.setBounds(200, 180, 100, 20);
        
        this.add(btn_Register);
        this.add(txt_NickName);
        this.add(txt_Password);
        this.add(label_Password);
        this.add(label_NickName);
    }
}

package com.mycompany.wordl;

import javax.swing.JButton;
import javax.swing.*;

public class PanelLogin extends JPanel{
    JButton btn_Login;
    JTextField txt_NickName;
    JTextField txt_Password;
    JLabel ueberschrift;
    JLabel label_NickName;
    JLabel label_Password;
    JTextArea txt_erfolgreich;
    
    public PanelLogin(){
        btn_Login = new JButton("Login");
        txt_NickName = new JTextField();
        txt_Password = new JTextField();
        
        label_NickName = new JLabel("Nick name");
        label_Password = new JLabel("Password");
        
        txt_erfolgreich = new JTextArea();
        txt_erfolgreich.setEditable(false);
        
        ueberschrift = new JLabel();
        ueberschrift.setText("Login");
        ueberschrift.setBounds(190, 50, 1000, 30);
        ueberschrift.setFont(ueberschrift.getFont().deriveFont(24f));
        this.add(ueberschrift);
        
        this.setLayout(null);
        btn_Login.setBounds(200, 220, 100, 20);
        txt_Password.setBounds(200, 200, 100, 20);
        txt_NickName.setBounds(200, 160, 100, 20);
        
        label_NickName.setBounds(200, 140, 100, 20);
        label_Password.setBounds(200, 180, 100, 20);
        txt_erfolgreich.setBounds(190, 240, 120, 80);
        
        this.add(txt_erfolgreich);
        this.add(btn_Login);
        this.add(txt_NickName);
        this.add(txt_Password);
        this.add(label_Password);
        this.add(label_NickName);
    }
}

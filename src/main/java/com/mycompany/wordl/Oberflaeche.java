/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wordl;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Lorenz Schaller
 */
public class Oberflaeche extends JFrame implements ActionListener{
    
    MenuLeiste ml;
    
    PanelLogin pl;
    PanelRegister pr;
    PanelWordle pw;
    
    Benutzer b;
    
    char[] wort;
    
    DatenbankConnSingleton dbconn;
    
    public Oberflaeche() throws SQLException{
        this.setSize(600, 500);
        
        b = new Benutzer();
        
        dbconn = DatenbankConnSingleton.getInstance();
        
        ml = new MenuLeiste();
        
        pw = new PanelWordle();
        pr = new PanelRegister();
        pl = new PanelLogin();
        
        wort = dbconn.wortAuslesen().toCharArray();
        
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        this.setJMenuBar(ml);
        
        this.add(pw);
        
        addActionLisoners();
        
        this.setTitle("Wordle");
        
        this.setVisible(true);
        
    }
    
    private void addActionLisoners(){
        ml.item_login.addActionListener(this);
        ml.item_register.addActionListener(this);
        ml.item_wordle.addActionListener(this);
        pl.btn_Login.addActionListener(this);
        pr.btn_Register.addActionListener(this);
        for (int i = 0; i < pw.btn_check.length; i++) {
            pw.btn_check[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ml.item_register){
            this.add(pr);
            pw.setVisible(false);
            pl.setVisible(false);
            pr.setVisible(true);
            System.out.println("register");
        }else if(e.getSource() == ml.item_login){
            this.add(pl);
            pw.setVisible(false);
            pr.setVisible(false); 
            pl.setVisible(true);
            System.out.println("login");
        }else if(e.getSource() == ml.item_wordle){
            this.add(pw);
            pl.setVisible(false);
            pr.setVisible(false);
            pw.setVisible(true);
            System.out.println("wordle");
        }else if(e.getSource() == pl.btn_Login){
            try {
                dbconn.benutzerEinloggen(b, pl.txt_NickName.getText(), pl.txt_Password.getText());
            } catch (SQLException ex) {
                Logger.getLogger(Oberflaeche.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            pl.txt_erfolgreich.setText(b.toString());
            
            System.out.println("Login Button pressed");
        }else if(e.getSource() == pr.btn_Register){
            dbconn.benutzerEingeben(pr.txt_NickName.getText(), pr.txt_Password.getText());
        }
        //chekc if word is correct
        else if(e.getSource() == pw.btn_check[0]){
            System.out.println("check 0");
            char[] input = new char[5];
            for (int i = 0; i < wort.length; i++) {
                input[i]  = pw.txt_fields[0][i].getText().charAt(0);
                if(wort[i] == input[i]){
                    pw.txt_fields[0][i].setColor(Color.GREEN);
                }
            }
        }else if(e.getSource() == pw.btn_check[1]){
            System.out.println("check 1");
            
        }else if(e.getSource() == pw.btn_check[2]){
            System.out.println("check 2");
            
        }else if(e.getSource() == pw.btn_check[3]){
            System.out.println("check 3");
            
        }else if(e.getSource() == pw.btn_check[4]){
            System.out.println("check 4");
            
        }
    }
}

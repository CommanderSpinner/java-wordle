package com.mycompany.wordl;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuLeiste extends JMenuBar{
    JMenu optionen;
    JMenuItem item_register;
    JMenuItem item_login;
    JMenuItem item_wordle;
    
    public MenuLeiste(){
        optionen = new JMenu("optionen");
        item_register = new JMenuItem("register");
        item_login = new JMenuItem("login");
        item_wordle = new JMenuItem("wordle");
        
        optionen.add(item_register);
        optionen.add(item_login);
        optionen.add(item_wordle);
        
        this.add(optionen);
    }
}

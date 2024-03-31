package com.mycompany.wordl;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/* @author Lorenz Schaller */
public class SingleCharacterTextField extends JTextField{

    public void setColor(Color c){
        this.setBackground(c);
    }
    
    public SingleCharacterTextField(/*int columns*/) {
        //super(columns);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) || getText().length() >= 1) {
                    e.consume(); // Tastatureingabe ignorieren
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
}
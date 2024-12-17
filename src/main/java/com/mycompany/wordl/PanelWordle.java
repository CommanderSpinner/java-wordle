package com.mycompany.wordl;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class PanelWordle extends JPanel{
    SingleCharacterTextField txt_fields[][] = new SingleCharacterTextField[5][5];
    
    int textFieldWidth = 50; 
    int textFieldHeight = 50; 
    int horizontalGap = 5;
    int verticalGap = 5;
    
    JButton[] btn_check = new JButton[5];
    
    public PanelWordle(){
        this.setLayout(null);
        
        int startX = 150;
        int startY = 10;
        for (int i = 0; i < txt_fields.length; i++) {
            for (int j = 0; j < txt_fields[i].length; j++) {
                txt_fields[i][j] = new SingleCharacterTextField();
                int x = startX + (textFieldWidth + horizontalGap) * j;
                int y = startY + (textFieldHeight + verticalGap) * i;
                txt_fields[i][j].setBounds(x, y, textFieldWidth, textFieldHeight);
                
                
                this.add(txt_fields[i][j]);
            }
            btn_check[i] = new JButton("check");
            btn_check[i].setBounds(startX + (textFieldWidth + horizontalGap) * txt_fields[i].length, startY + (textFieldHeight + verticalGap) * i, 70, textFieldHeight);
            this.add(btn_check[i]);
        }
    }
}

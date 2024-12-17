package com.mycompany.wordl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class DatenbankConnSingleton {

    private static DatenbankConnSingleton eineDatenbankInstanz;
    private Connection connection;
    String jdbcURL = "jdbc:postgresql://localhost:5432/benutzer"; //Aufenthaltsort des Servers, Port, Name der Datenbank ist case sensitive
    String username = "postgres";
    String psw = "admin";

    private DatenbankConnSingleton() {
        try {
            this.connection = DriverManager.getConnection(jdbcURL, username, psw);
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankConnSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatenbankConnSingleton getInstance() throws SQLException {
        if (eineDatenbankInstanz == null) {
            eineDatenbankInstanz = new DatenbankConnSingleton();
        } else if (eineDatenbankInstanz.getConnection().isClosed()) {
            eineDatenbankInstanz = new DatenbankConnSingleton();
        }

        return eineDatenbankInstanz;

    }

    public void benutzerEingeben(String name, String password) {
        try {
            String query = "INSERT INTO benutzer (nickname, password, highscore) VALUES (?, ?, 0)";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, password);
            statement.executeUpdate();
            System.out.println("Benutzer erfolgreich eingefügt: " + name);
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankConnSingleton.class.getName()).log(Level.SEVERE, "Fehler beim Einfügen des Benutzers: " + name, ex);
        }
    }
    
    public void benutzerEinloggen(Benutzer b, String nicknameInput, String paswordInput) throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM benutzer;");
        while(rs.next()){
            int bid = rs.getInt("bid");
            String nickname = rs.getString("nickname");
            String password = rs.getString("password");
            int highscore = rs.getInt("highscore");
            
            if(nicknameInput.equals(nickname) && paswordInput.equals(password)){
                b.setBid(bid);
                b.setHighscore(highscore);
                b.setNickname(nickname);
                b.setPassword(password);
            }
        }
        
        System.out.println("Benutzer eingelogged als: " + b);
    }
    
    public String wortAuslesen() throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM woerter_mit_fuenf_buchstaben;");
        Random r = new Random();
        int randomZahl = r.nextInt(5)+1;
        
        String wort = "";
        
        while(rs.next()){
            int bid = rs.getInt("wid");
            if(bid == randomZahl)
                wort = rs.getString("wort");
        }
        
        System.out.println("wort:" + wort);
        
        return wort;
    }
}

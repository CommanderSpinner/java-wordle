package com.mycompany.wordl;

public class Benutzer {
    private int bid;
    private String nickname;
    private String password;
    private int highscore;
    

    public void setBid(int bid) {
        this.bid = bid;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }
    
    @Override
    public String toString(){
        return "bid:" + bid + "\nnickname:" + nickname + "\npassword:" + password + "\nhighscore:" + highscore + "\n";
    }
}

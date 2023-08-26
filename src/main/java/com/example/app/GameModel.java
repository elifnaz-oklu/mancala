package com.example.app;
    
public class GameModel{
    private String p1Name;
    private String p2Name;

    public GameModel(String p1Name,String p2Name){
            this.p1Name = p1Name;
            this.p2Name = p2Name;
    }


    /**
     * @return String return the p1Name
     */
    public String getP1Name() {
        return p1Name;
    }

    /**
     * @param p1Name the p1Name to set
     */
    public void setP1Name(String p1Name) {
        this.p1Name = p1Name;
    }

    /**
     * @return String return the p2Name
     */
    public String getP2Name() {
        return p2Name;
    }

    /**
     * @param p2Name the p2Name to set
     */
    public void setP2Name(String p2Name) {
        this.p2Name = p2Name;
    }
}
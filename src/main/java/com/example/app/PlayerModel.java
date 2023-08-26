package com.example.app;


public class PlayerModel{
    private String name;
    private int pitIndex;


    public PlayerModel(String name,int pitIndex){
            this.name = name;
            this.pitIndex = pitIndex;   
    }


    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return int return the pitIndex
     */
     public int getPitIndex() {
        return pitIndex;
    }

    
    /**
     * @param pitIndex the pitIndex to set
     */
    public void setPitIndex(int pitIndex) {
        this.pitIndex = pitIndex;
    }

}
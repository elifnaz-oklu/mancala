package com.example.app;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Game {

    private Player playerTurn;
    private ArrayList<Player> players = new ArrayList<Player>();
    private Timestamp createdAt;
    private String status;
    private ArrayList<Pit> pits;
    private Player player1;
	private Player player2;
    
    // Game object has all components player and pits
    public Game(String p1Name,String p2Name) {
        player1 = new Player(p1Name);
        players.add(player1);
        player2 = new Player(p2Name);
        players.add(player2);
        createdAt = new Timestamp(System.currentTimeMillis());
        status = "started";
        playerTurn = player1;
        pits = new ArrayList<Pit>();
        createPitList(6,6);
    }

    // Function for creating all pits and add them to Game object's pits
    private void createPitList(Integer pitNumber, Integer pitSize) {
		
		for(int i = 0;i<pitNumber;i++) {
			Pit p1 = new Pit(pitSize,false,player1);
			pits.add(p1);
		}
		Pit p2 = new Pit(0,true,player1);
		pits.add(p2);
			
		for(int i = 0;i<pitNumber;i++) {
			Pit p1 = new Pit(pitSize,false,player2);
			pits.add(p1);
		}
		Pit p3 = new Pit(0,true,player2);
		pits.add(p3);	
	
    }

    /**
     * @param Player the PlayerTurn to set
     */
    public void setPlayerTurn(Player player) {
        this.playerTurn=player;       
    }

    /**
     * @return Player return the playerTurn
     */
    public Player getPlayerTurn() {
        return playerTurn;
    }

    /**
     * @return ArrayList<Player> return the players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * @return Timestamp return the createdAt
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return ArrayList<Pit> return the pits
     */
    public ArrayList<Pit> getPits() {
		return pits;
	}
    
    /**
     * @param pits the pits to set
     */
	public void setPits(ArrayList<Pit> pits) {
		this.pits = pits;
	}

    /**
     * @return Player return the player1
     */
	public Player getPlayer1() {
		return player1;
	}

    /**
     * @param player1 the player to set
     */
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

    /**
     * @return Player return the player2
     */
	public Player getPlayer2() {
		return player2;
	}
    

    /**
     * @param player2 the player to set
     */
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

}
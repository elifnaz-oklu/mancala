package com.example.app;


public class Pit {
	
	private Integer size;
	private Boolean isBigPit;
	private Player player;

	public Pit(Integer size,Boolean isBigPit,Player player) {
		this.size = size;
		this.isBigPit = isBigPit;
		this.player = player;
	}
	
	// function for decreasing pit size
	public void decreasePit() {
		size --;
	}
	

	// function for adding all pit's content to @param p
	public void decreaseAll(Pit p) {
		p.setSize(p.getSize()+getSize());
		setSize(0);
	}
	

	// function for increasing pit size
	public void increasePit() {
		size ++;
	}

	public Boolean isPlayersBigPit(Player p) {
		return (isBigPit && player.getName().equals(p.getName()));
	}

	public Boolean isPlayersPit(Player p) {
		return (player.getName().equals(p.getName()));
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Boolean getIsBigPit() {
		return isBigPit;
	}

	public void setIsBigPit(Boolean isBigPit) {
		this.isBigPit = isBigPit;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	

}
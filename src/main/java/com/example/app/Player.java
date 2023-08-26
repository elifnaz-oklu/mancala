package com.example.app;

import java.util.ArrayList;

public class Player {
	
	private String name;

	// flag for player plays another turn
	private boolean isPlayAgain = false;
	
	public Player(String name) {	
		this.name = name;
	}
	
	// function for each player Move
	public Move playTurn(int indexofPit, ArrayList<Pit> pits) {
		
		Pit p = pits.get(indexofPit);

		// flag for if game is finished
		Boolean isFinished = false;
		String result = "";
        
		// if selected pit is empty select another one
		if(p.getSize()==0){
			setPlayAgain(true);
		}
		
		while(p.getSize() != 0) {
			indexofPit ++;

			// loop through list		
			if(indexofPit == pits.size()) {
				indexofPit=0;
			}
            // following pit
			Pit nextPit = pits.get(indexofPit);
			
			// check if player play another turn
			if(p.getSize()==1 && nextPit.isPlayersBigPit(this)) {
				setPlayAgain(true);
			}
			
			else {
				setPlayAgain(false);
			}

			// capture opponents stones
			if(p.getSize()==1 && !nextPit.getIsBigPit() && 
			nextPit.getSize()==0&&nextPit.isPlayersPit(this) && pits.get(12-indexofPit).getSize()!=0) {
	
				p.decreasePit();
				getBigPit(pits).increasePit();
				pits.get(12-indexofPit).decreaseAll(getBigPit(pits));
				break;
			}

			// skip opponent's big pit
			if(nextPit.isPlayersBigPit(this)|| !nextPit.getIsBigPit()) {		
				nextPit.increasePit();
				p.decreasePit();			
			}
		}

		isFinished = isFinished(pits);

		if (isFinished) {
			int playersPoint = getBigPit(pits).getSize();
			int opponentsPoint = sumofOpponentsPits(pits);
			if(playersPoint > opponentsPoint){
				result = getName() + " finished and won the game " + Integer.toString(playersPoint) 
				+ " to " + Integer.toString(opponentsPoint) ;
			}
			if(playersPoint == opponentsPoint){
				result = getName() + " finished but there is a draw " + Integer.toString(playersPoint) 
				+ " to " + Integer.toString(opponentsPoint) ;
			}
			if(playersPoint < opponentsPoint){
				result = getName() + " finished but lost the game " + Integer.toString(playersPoint) 
				+ " to " + Integer.toString(opponentsPoint) ;
			}

		}

        Move move = new Move(isPlayAgain,pits,isFinished,result);

        return move;
			
	}
    
	// function for when game is finished calculate opponents pits
    public int sumofOpponentsPits(ArrayList<Pit> pits) {	
		int sum = 0;
		for (Pit pit : pits) {
            if(!pit.isPlayersPit(this)){
                sum = sum + pit.getSize();
            }
        }
        return sum;
	}

	public Pit getBigPit(ArrayList<Pit> pits) {	
		for (Pit pit : pits) {
            if(pit.isPlayersBigPit(this)){
                return pit;
            }
        }
        return null;
	}
    
	// function for if player's all pits empty (game is finished)
	public Boolean isFinished(ArrayList<Pit> pits) {
		int sum = 0;	
		for (Pit pit : pits) {
            if(!pit.isPlayersBigPit(this) && pit.isPlayersPit(this)){
                sum = sum + pit.getSize();
            }
        }

		return (sum == 0 ? true : false);
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isPlayAgain() {
		return isPlayAgain;
	}

	public void setPlayAgain(boolean isPlayAgain) {
		this.isPlayAgain = isPlayAgain;
	}

}

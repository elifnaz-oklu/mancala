package com.example.app;

import java.util.ArrayList;

public class Move {
	
	private Boolean isPlayAgain;
	private ArrayList<Pit> pits;
	private Boolean isFinished;
	private String result;


	public Move(Boolean isPlayAgain,ArrayList<Pit> pits, Boolean isFinished, String result) {
		this.isPlayAgain = isPlayAgain;
		this.pits = pits;
		this.isFinished = isFinished;
		this.result = result;
	}


	public Boolean getIsPlayAgain() {
		return isPlayAgain;
	}

	public void setIsPlayAgain(Boolean isPlayAgain) {
		this.isPlayAgain = isPlayAgain;
	}

	public ArrayList<Pit> getPits() {
		return pits;
	}

	public void setPits(ArrayList<Pit> pits) {
		this.pits = pits;
	}

	public Boolean getIsFinished() {
		return isFinished;
	}


	public void setIsFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}

	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}

}
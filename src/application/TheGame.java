package application;

import java.util.concurrent.ThreadLocalRandom; 
import java.util.Scanner; 

public class TheGame {
	
	int score = 0; 
	int tot = 0;
	int localRandom = 0; 
	
	public TheGame() {
		
	}
	
	public int getLocalRandom() {
		return localRandom;
	}

	public void setLocalRandom(int localRandom) {
		this.localRandom = localRandom;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}
	
 	public int generateNumber() {
 	 	
 		localRandom = ThreadLocalRandom.current().nextInt(100000,999999);
 	 	tot++; 

 		return localRandom;
 	}
 	
 	public void addScore(int userInput) {
 		if (userInput == localRandom) {
 			score++; 
 		}
 	}

}



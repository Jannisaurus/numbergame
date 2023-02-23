package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ScoreBoard {
//	private ArrayList<Integer> scoreBoard = new ArrayList<Integer>(); 
	private ObservableList<Integer> observableScoreBoard = FXCollections.observableArrayList(); 
	private static ScoreBoard instance = null; 
	private String data; 
	private File file = new File("C:\\Users\\janni\\eclipse-workspace\\numbergame\\testscoreboard.txt");
	
	
//	public static ScoreBoard getInstance() {
//		if (instance == null) {
//			instance = new ScoreBoard();
//		}
//		return instance; 
//	}
	
//	public ArrayList<Integer> getScoreBoard() {
//		return scoreBoard;
//	}
//	public void setScoreBoard(ArrayList<Integer> scoreBoard) {
//		this.scoreBoard = scoreBoard;
//	}
//	
//	public void addToScoreBoard(int score) {
//		this.scoreBoard.add(score);
//	}
	public ObservableList<Integer> getObservableScoreBoard() {
		return observableScoreBoard;
	}
	public void setObservableScoreBoard(ObservableList<Integer> observableScoreBoard) {
		this.observableScoreBoard = observableScoreBoard;
	}
	
	public void addObservableScoreBoard(int score) {
		observableScoreBoard.add(score);
	}
	
	public void addToFile (int score) throws IOException {
	    
	    FileWriter fr = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fr);
        
	    try {
	        bw.write(Integer.toString(score));
	        bw.newLine();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            bw.close();
	            fr.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public int getHighScore() throws IOException {
		ArrayList<Integer> scores = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		
		String st; 
		
		while ((st = br.readLine()) != null) {
			scores.add(Integer.parseInt(st)); 
		}
		
		Collections.sort(scores, Collections.reverseOrder());
		
		return scores.get(0); 
	}
	
	
	public void clearScoreBoard() throws IOException {
		new FileWriter(file).close();
		
		addToFile(0); 
	}
	
	
//	BufferedWriter bw = null; 
//	FileWriter fr = null;
//	String st;
	// + System.getProperty("line.separator"
	//		while ((st = br.readLine()) != null) {
//			System.out.println(st);
//		}
	
}

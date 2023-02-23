package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PlayController{
	private Stage stage; 
	private Scene scene; 
	private Parent root; 
	
	private ScoreBoard scoreBoard = new ScoreBoard();
//    public PlayController(ScoreBoard scoreBoard) {
//        this.scoreBoard = scoreBoard;
//    }
	
	@FXML
	private Label lastScoreLabel;
	
	public void initialize() throws IOException {
		
		lastScoreLabel.setText("High score: " + Integer.toString(scoreBoard.getHighScore()));

	}
	
	public void switchToNumberGame(ActionEvent event) throws IOException {
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Number.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root); 
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void button_clearHighScore(ActionEvent event) throws IOException {
		scoreBoard.clearScoreBoard();
		lastScoreLabel.setText("High score: " + 0);
	}
	
}

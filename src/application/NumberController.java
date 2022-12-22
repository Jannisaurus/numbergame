package application;

import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class NumberController {
	private Stage stage; 
	private Scene scene; 
	private Parent root; 
	
	@FXML
	Label labelNumberOutput; 
	
	@FXML
	TextField textFieldNumberInput;
	
	TheGame game = new TheGame(); 
	
	PauseTransition visiblePause = new PauseTransition(
	        Duration.seconds(1)
	);
	
	
	private void change() {
		labelNumberOutput.setVisible(false);
		textFieldNumberInput.setVisible(true);
	}
	
	public void initialize() {
		labelNumberOutput.setText(String.valueOf(game.generateNumber()));
		textFieldNumberInput.setVisible(false);

		visiblePause.setOnFinished(
		        event ->  {
		        	labelNumberOutput.setVisible(false);
			        textFieldNumberInput.setVisible(true);
		        }
		);
		
		visiblePause.play();
		
		
	}
	
	public void switchToPlayScreen(ActionEvent event) throws IOException {
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Play.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void button_numberSubmitAnswer(ActionEvent event) throws IOException {
		String inputString = textFieldNumberInput.getText();
		
		int input = Integer.parseInt(inputString); 
		
		game.addScore(input);
		
		labelNumberOutput.setText(String.valueOf(game.generateNumber()));
		
		textFieldNumberInput.clear();
		
		int tot = game.getTot(); 
		
		if (tot <= 10) {
			labelNumberOutput.setVisible(true);
			textFieldNumberInput.setVisible(false);
			
			System.out.println(game.getScore());
			
			visiblePause.setOnFinished(
			        iAmNothing ->  {
			        	labelNumberOutput.setVisible(false);
				        textFieldNumberInput.setVisible(true);
			        }
			);
			
			visiblePause.play();
		} else {
			System.out.println(game.getScore());
			
			game.setScore(0);
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Play.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}
		
	
	}
	
}
 
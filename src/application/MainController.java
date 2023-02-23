package application;

public class MainController {
	protected ScoreBoard scoreBoard = new ScoreBoard();
	
	private MainController() {
		scoreBoard.addObservableScoreBoard(10);
		scoreBoard.addObservableScoreBoard(40);
		scoreBoard.addObservableScoreBoard(30);
	}

}

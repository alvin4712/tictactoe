package controller;

import exceptions.DrawException;
import exceptions.WinException;
import model.Board;
import model.Player;
import view.Console;

public class GameController {
	private Board board;
	private Player first;
	private Player second;
	private Player controller;
	private Console console;

	public GameController(Player first, Player second) {
		this.first = first;
		this.second = second;
		console = new Console();

	}

	public void start() {
		initGame();
		takeControl();
	}

	private void initGame() {
		board = new Board();
		first.setBoard(board);
		second.setBoard(board);
		controller = first;
		console.showIntroductoryMessage(board);
	}

	private void takeControl() {
		boolean gameFinished = false;
		do {
			try {
				console.showRequestForPlayMessage(controller);
				controller.play();
				console.showPlayResultMessage(board);
				changePlayer();
			} catch (DrawException e) {
				console.showDrawMessage(board, e);
				gameFinished = true;
			} catch (IllegalArgumentException e) {
				console.showErrorMessage(e);
			} catch (WinException e) {
				console.showWinMessage(board, e);
				gameFinished = true;
			}
		} while (!gameFinished);
	}

	private void changePlayer() {
		controller = (controller.equals(first)) ? second : first;
	}

}

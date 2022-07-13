package model;

import engine.PlayerEngine;
import exceptions.DrawException;
import exceptions.WinException;

public class Player {
	private PlayerEngine engine;
	private Stamp stamp;
	private Board board;
	private char symbol;

	public Player(PlayerEngine engine, char symbol) {
		this.symbol = symbol;
		this.engine = engine;
		this.stamp = new Stamp(symbol);
	}

	public void play() throws DrawException, WinException {
		board.setPlay(engine.getPlay(), stamp);
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	@Override
	public String toString() {
		return "Player [" + symbol + "]";
	}

}

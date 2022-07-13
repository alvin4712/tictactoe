package model;

import exceptions.DrawException;
import exceptions.WinException;

public class Board {
	public static final int SIZE = 3;
	private final Stamp BLANK_STAMP = new Stamp();
	private Stamp[][] board = new Stamp[SIZE][SIZE];
	private int plays = 0;

	public Board() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = BLANK_STAMP;
			}
		}
	}

	public void setPlay(Gap play, Stamp stamp) throws DrawException, WinException {
		boolean isEmptyGap = board[play.getLine()][play.getColumn()].equals(BLANK_STAMP);
		if (!isEmptyGap)
			throw new IllegalArgumentException("A lacuna já foi escolhida anteriormente.");

		board[play.getLine()][play.getColumn()] = stamp;
		plays++;
		verifyGameStatus();
	}

	private void verifyGameStatus() throws DrawException, WinException {
		verifyDraw();
		verifyWin();
	}

	private void verifyDraw() throws DrawException {
		if (plays >= Math.pow(SIZE, 2))
			throw new DrawException();
	}

	private void verifyWin() throws WinException {
		verifyLines();
		verifyColumns();
		verifyDiagonals();
	}

	private void verifyLines() throws WinException {
		for (int i = 0; i < SIZE; i++) {
			if (board[i][0].equals(BLANK_STAMP))
				continue;
			if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
				throw new WinException("Vitória");

			}
		}
	}

	private void verifyColumns() throws WinException {
		for (int i = 0; i < SIZE; i++) {
			if (board[0][i].equals(BLANK_STAMP))
				continue;

			if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) {
				throw new WinException("Vitória");

			}
		}

	}

	private void verifyDiagonals() throws WinException {
		if (board[0][0].equals(BLANK_STAMP) || board[2][0].equals(BLANK_STAMP))
			return;

		if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]))
			throw new WinException("Vitória");

		if (board[2][0].equals(board[1][1]) && board[2][0].equals(board[0][2]))
			throw new WinException("Vitória");

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("   |A||B||C|\n");
		for (int i = 0; i < SIZE; i++) {
			sb.append("|" + (i + 1) + "|");
			for (int j = 0; j < SIZE; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}

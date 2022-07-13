package engine;

import java.util.Scanner;

import model.Gap;

public class HumanPlayer implements PlayerEngine {
	protected HumanPlayer() {
	}

	@Override
	public Gap getPlay() {
		return new Gap(readPlay());
	}

	@SuppressWarnings("resource")
	private String readPlay() {
		return new Scanner(System.in).next();
	}

}

import java.util.Scanner;

import controller.GameController;
import engine.EngineFactory;
import model.Player;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Player first = new Player(EngineFactory.getHumanPlayerEngine(), 'x');
		Player second = new Player(EngineFactory.getHumanPlayerEngine(), 'o');
		String decision;
		GameController gameController = new GameController(first, second);
		do {
			gameController.start();
			System.out.print("Para jogar novamente, digite 'sim': ");
			decision = new Scanner(System.in).next().toLowerCase();
		} while (decision.equals("sim"));
	}
}

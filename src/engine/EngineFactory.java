package engine;

public class EngineFactory {
	private static PlayerEngine humanEngine;

	public static PlayerEngine getHumanPlayerEngine() {
		if (humanEngine == null)
			humanEngine = new HumanPlayer();
		return humanEngine;
	}
}

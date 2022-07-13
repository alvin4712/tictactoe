package exceptions;

public class DrawException extends Exception {

	private static final long serialVersionUID = 1L;

	public DrawException() {
		super("O jogo empatou!");
	}

}

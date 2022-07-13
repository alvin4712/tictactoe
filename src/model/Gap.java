package model;

public class Gap {
	private int line;
	private int column;

	public Gap(String gap) {
		if (gap.length() != 2)
			throw new IllegalArgumentException(
					"A lacuna deve ter dois valores que representam a linha e a coluna respectivamente: " + gap);

		line = getLine(gap);
		column = getColumn(gap);
	}

	private int getLine(String gap) {
		Integer number;
		try {
			number = Integer.parseInt("" + gap.charAt(0));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("O primeiro parâmetro deve ser um número inteiro: " + gap);
		}

		if (number > Board.SIZE || number < 1)
			throw new IllegalArgumentException("O primeiro parâmetro deve ser um número inteiro entre 1 e 3: " + gap);
		return --number;
	}

	private int getColumn(String gap) {
		Character column = Character.toLowerCase(gap.charAt(1));
		if (column < 'a' || column > 'c')
			throw new IllegalArgumentException("O segundo parâmetro deve ser uma letra entre A, B e C: " + gap);
		return Character.toLowerCase(gap.charAt(1)) - 'a';
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return "[line=" + line + ", column=" + column + "]";
	}

}

package model;

public class Stamp {
	private char symbol;

	public Stamp() {
		this(' ');
	}

	public Stamp(char symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "[" + symbol + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Stamp other = (Stamp) obj;
		return Character.valueOf(symbol).compareTo(Character.valueOf(other.symbol)) == 0;
	}

}

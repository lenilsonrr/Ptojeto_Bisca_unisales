package bisca;

import java.util.ArrayList;
import java.util.List;

public class Baralho {

	private List<Carta> cartas = new ArrayList<>();

	public Baralho() {
		String[] faces = { "As", "2", "3", "4", "5", "6", "7", "Q", "J", "K" };
		for (int i = 0; i < faces.length; i++) {
			this.cartas.add(new Carta(faces[i], "Copas", 0));
			this.cartas.add(new Carta(faces[i], "Espadas", 0));
			this.cartas.add(new Carta(faces[i], "Ouros", 0));
			this.cartas.add(new Carta(faces[i], "Paus", 0));
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Carta c : cartas) {
			sb.append(c);
		}
		return sb.toString();
	}
}

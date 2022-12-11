package bisca;

import java.util.ArrayList;
import java.util.List;

public class Programa {

	public static void main(String[] args) {

		


		// testando partida//
		Partida partidaTeste = new Partida(new Baralho());
		partidaTeste.getBaralho().embaralhar();
		partidaTeste.getCartaNipe();
		partidaTeste.addJogadores();
		System.out.println(partidaTeste);

	}
}

package bisca;

import java.util.ArrayList;
import java.util.List;

public class Programa {

	public static void main(String[] args) {
		
		//testando carta//
		Carta cartaAs = new Carta ("As", "Copas", 11);
		Carta cart7 = new Carta ("7", "Copas", 11);
		Carta cartaK = new Carta ("K", "Copas", 11);
		System.out.println(cartaAs);
		
		//testando baralho//
		Baralho baralho1 = new Baralho();
		System.out.println("___________teste___________");
		 baralho1.embaralhar();
		System.out.println(baralho1);
		
		//testando Jogador//
		List<Carta> cartasJogador = new ArrayList<>();
		cartasJogador.add(cartaAs);
		cartasJogador.add(cartaK);
		cartasJogador.add(cart7);
		Jogador jogadorTeste = new Jogador("Jog1", 0, cartasJogador) ;
		Jogador jogadorTeste2 = new Jogador("Jog2", 0, cartasJogador) ;
		System.out.println(jogadorTeste);
		
		//testando partida//
		Partida partidaTeste = new Partida(baralho1);
		partidaTeste.setCartaNipe(cartaK);
		partidaTeste.setjogador1(jogadorTeste);
		partidaTeste.setjogador2(jogadorTeste2);
		System.out.println(partidaTeste);
		
	}
}

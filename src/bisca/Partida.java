package bisca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Partida {

	private Baralho baralho;
	private Carta cartaNipe;
	private Jogador jogador1;
	private Jogador jogador2;

	private Scanner sc = new Scanner(System.in);

	public Partida(Baralho baralho) {
		this.baralho = baralho;
	}

	public Jogador getJogador1() {
		return this.jogador1 = jogador1;
	}

	public void setjogador1(Jogador jogador) {
		this.jogador1 = jogador;
	}

	public Jogador getJogador2() {
		return this.jogador2 = jogador2;
	}

	public void setjogador2(Jogador jogador) {
		this.jogador2 = jogador;
	}

	public Baralho getBaralho() {
		return baralho;
	}

	public Carta getCartaNipe() {
		return cartaNipe;
	}

	public void setCartaNipe(Carta cartaNipe) {
		this.cartaNipe = cartaNipe;
	}

	// Adicinonando jogadores//

	public void addJogadores() {
		jogador1 = new Jogador("jog1", 0, cartasJogadores());
		jogador2 = new Jogador("jog2", 0, cartasJogadores());
		jogador1.setVez("vez");
		jogador2.setVez(null);
	}

	//adicionando cartas ao jogadores//
	
	public List<Carta> cartasJogadores() {
		List<Carta> cartasJogador = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			cartasJogador.add(baralho.comprarUmaCarta());
		}
		return cartasJogador;
	}
	
	public void nipeDoJogo() {
		Carta c_trunfo = baralho.cartaParaTrunfo();
		setCartaNipe(c_trunfo);
	}
	
	

	@Override
	public String toString() {

		return jogador1 + " carta nipe: " + cartaNipe + " nipe: " + cartaNipe.getNipe() + jogador2 + "carta nipe: "
				+ cartaNipe + "nipe: " + cartaNipe.getNipe();
	}

}

 public void trocandoDoisPorTrunfoMaior() {
	for (int i = 0; i < jogador1.getCartasJogador().size(); i++) {
		if (jogador1.getCartasJogador().get(i).getFaces().equals("2")
				&& jogador1.getCartasJogador().get(i).getNipe().equals(cartaNipe.getNipe())) {
			jogador1.getCartasJogador().set(i, cartaNipe);
		}
		if (jogador2.getCartasJogador().get(i).getFaces().equals("2")
				&& jogador2.getCartasJogador().get(i).getNipe().equals(cartaNipe.getNipe())) {
			jogador2.getCartasJogador().set(i, cartaNipe);
		}
	}

}
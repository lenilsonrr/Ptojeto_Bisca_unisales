package bisca;

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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Carta c : cartas) {
			sb.append(c);
		}
		return sb.toString();
}
	
}

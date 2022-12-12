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
		jogador1 = new Jogador("Jogador 1", 0, cartasJogadores());
		jogador2 = new Jogador("Jogador 2", 0, cartasJogadores());
		jogador1.setVez("Vez");
		jogador2.setVez(null);
	}

	// adicionando cartas ao jogadores//

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

		return jogador1 + " carta naipe: " + cartaNipe + " naipe: " + cartaNipe.getNipe()
				+ "\n--------------------------------------\n" + jogador2 + "carta naipe: " + cartaNipe + "naipe: "
				+ cartaNipe.getNipe() + "\n--------------------------------------\n";
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

	public void regraMesmoNipeSemSerTrunfo(Jogador j1, int n1, Jogador j2, int n2) {

		if (j1.getCartasJogador().get(n1).getNipe().equals(j2.getCartasJogador().get(n2).getNipe())
				&& j1.getCartasJogador().get(n1).getNipe() != cartaNipe.getNipe()
				&& j2.getCartasJogador().get(n2).getNipe() != cartaNipe.getNipe()) {
			if (j1.getCartasJogador().get(n1).getPeso() > j2.getCartasJogador().get(n2).getPeso()) {
				j1.somarPontos(j1.getCartasJogador().get(n1).getValor() + j2.getCartasJogador().get(n2).getValor());
				System.out.println("Vitoria jogador 1 agora é sua vez @@@@@ cartas mesmo nipe sem ser trunfo\n");
				j1.setVez("vez");
				j2.setVez(null);

			} else {
				j2.somarPontos(j1.getCartasJogador().get(n1).getValor() + j2.getCartasJogador().get(n2).getValor());
				System.out.println("Vitoria jogador 2 agora é sua vez @@@@@ cartas mesmo nipe sem ser trunfo\n");
				j2.setVez("vez");
				j1.setVez(null);
			}
		}

	}
}
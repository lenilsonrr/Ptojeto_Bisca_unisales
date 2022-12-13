package bisca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

	// Adicinonando jogadores

	public void addJogadores() {
		jogador1 = new Jogador("Jog1", 0, cartasJogadores());
		jogador2 = new Jogador("Jog2", 0, cartasJogadores());
		jogador1.setVez("vez");
		jogador2.setVez(null);
	}

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
			if (j1.getCartasJogador().get(n1).GetPeso() > j2.getCartasJogador().get(n2).GetPeso()) {
				j1.somarPontos(j1.getCartasJogador().get(n1).getValor() + j2.getCartasJogador().get(n2).getValor());
				System.out.println("Vitoria jog1 agora é sua vez @@@@@ cartas mesmo naipe sem ser trunfo\n");
				j1.setVez("vez");
				j2.setVez(null);

			} else {
				j2.somarPontos(j1.getCartasJogador().get(n1).getValor() + j2.getCartasJogador().get(n2).getValor());
				System.out.println("Vitoria jog2 agora é sua vez @@@@@ cartas mesmo naipe sem ser trunfo\n");
				j2.setVez("vez");
				j1.setVez(null);
			}
		}

	}

	public void regraCartaTrunfoEOutraNaoTrunfo(Jogador j1, int n1, Jogador j2, int n2) {
		if (j1.getCartasJogador().get(n1).getNipe().equals(cartaNipe.getNipe())
				&& j2.getCartasJogador().get(n2).getNipe() != cartaNipe.getNipe()) {

			j1.somarPontos(j1.getCartasJogador().get(n1).getValor() + j2.getCartasJogador().get(n2).getValor());
			System.out.println("Vitoria jog1 agora é sua vez ***** Cartas trunfo e outro não\n");
			j1.setVez("vez");
			j2.setVez(null);

		}
		if (j2.getCartasJogador().get(n2).getNipe().equals(cartaNipe.getNipe())
				&& j1.getCartasJogador().get(n1).getNipe() != cartaNipe.getNipe()) {
			j2.somarPontos(j1.getCartasJogador().get(n1).getValor() + j2.getCartasJogador().get(n2).getValor());
			System.out.println("Vitoria jog2 agora é sua vez ******** Cartas trunfo e outro não\n");
			j2.setVez("vez");
			j1.setVez(null);
		}

	}

	public void regraCartasMesmoNipeTrunfo(Jogador j1, int n1, Jogador j2, int n2) {

		if (j1.getCartasJogador().get(n1).getNipe().equals(cartaNipe.getNipe())
				&& j2.getCartasJogador().get(n2).getNipe().equals(cartaNipe.getNipe())) {
			if (j1.getCartasJogador().get(n1).GetPeso() > j2.getCartasJogador().get(n2).GetPeso()) {
				j1.somarPontos(j1.getCartasJogador().get(n1).getValor() + j2.getCartasJogador().get(n2).getValor());
				System.out.println("Vitoria jog1 agora é sua vez  %%%%%%% cartas mesmo naipe trunfo\n");
				j1.setVez("vez");
				j2.setVez(null);
			} else {
				j2.somarPontos(j1.getCartasJogador().get(n1).getValor() + j2.getCartasJogador().get(n2).getValor());
				System.out.println("Vitoria jog2 agora é sua vez %%%%%%%% cartas mesmo naipe trunfo\n");
				j2.setVez("vez");
				j1.setVez(null);
			}
		}
	}

	public void regraCartasNipesDiferentes(Jogador j1, int n1, Jogador j2, int n2) {

		if (j1.getCartasJogador().get(n1).getNipe() != j2.getCartasJogador().get(n2).getNipe()
				&& j1.getCartasJogador().get(n1).getNipe() != cartaNipe.getNipe()
				&& j2.getCartasJogador().get(n2).getNipe() != cartaNipe.getNipe()
				&& j2.getCartasJogador().get(n2).getNipe() != cartaNipe.getNipe()) {
			j1.somarPontos(j1.getCartasJogador().get(n1).getValor() + j2.getCartasJogador().get(n2).getValor());
			System.out.println("Vitoria continua a sua vez  ######## Cartas naipes diferentes\n");
			j1.setVez("vez");
			j2.setVez(null);
		}

	}

	public void regraReles(Jogador j1, int n1, Jogador j2, int n2) {

		if (j1.getCartasJogador().get(n1).getFaces() == "7"
				&& j1.getCartasJogador().get(n1).getNipe() == cartaNipe.getNipe()
				&& j2.getCartasJogador().get(n2).getFaces() == "As"
				&& j2.getCartasJogador().get(n2).getNipe() == cartaNipe.getNipe()) {
			System.out.println("Reles\n");
		}
	}

	public void rodadas() {
		Random rand = new Random();
		String jogadorDaVez = "vez";
		int pJ1 = 0;
		int pJ2 = 0;

		for (int i = 0; i < 17; i++) {

			System.out.println((i + 1) + "ª Rodada");
			if (jogador1.getVez() == "vez") {
				System.out.print("\n" + getJogador1());
				System.out.println("\nTrunfo: " + cartaNipe + "Naipe: " + cartaNipe.getNipe() + "\n");

				System.out.print(getJogador2());
				System.out.println("\nTrunfo: " + cartaNipe + "Naipe: " + cartaNipe.getNipe() + "\n");

				System.out.println(getJogador1().getCartasJogador().get(pJ1) + "    X \n"
						+ getJogador2().getCartasJogador().get(pJ2));

				regraMesmoNipeSemSerTrunfo(jogador1, pJ1, jogador2, pJ2);
				regraCartaTrunfoEOutraNaoTrunfo(jogador1, pJ1, jogador2, pJ2);
				regraCartasMesmoNipeTrunfo(jogador1, pJ1, jogador2, pJ2);
				regraCartasNipesDiferentes(jogador1, pJ1, jogador2, pJ2);
			} else {
				System.out.print("\n" + getJogador2());

				System.out.println("\nTrunfo: " + cartaNipe + "Naipe: " + cartaNipe.getNipe() + "\n");

				System.out.print("\n" + getJogador1());
				System.out.println("\nTrunfo: " + cartaNipe + "Naipe: " + cartaNipe.getNipe() + "\n");
				System.out.println("Mão");
				System.out.println(getJogador2().getCartasJogador().get(pJ2) + "    X \n"
						+ getJogador1().getCartasJogador().get(pJ1));

				regraMesmoNipeSemSerTrunfo(jogador1, pJ1, jogador2, pJ2);
				regraCartaTrunfoEOutraNaoTrunfo(jogador1, pJ1, jogador2, pJ2);
				regraCartasMesmoNipeTrunfo(jogador1, pJ1, jogador2, pJ2);
				regraCartasNipesDiferentes(jogador2, pJ2, jogador1, pJ1);
			}

			regraReles(jogador1, pJ1, jogador2, pJ2);

			jogador1.getCartasJogador().remove(pJ1);
			jogador1.getCartasJogador().add(baralho.comprarUmaCarta());
			jogador2.getCartasJogador().remove(pJ2);
			jogador2.getCartasJogador().add(baralho.comprarUmaCarta());
			System.out.println();
		}

		for (int i = 0; i < 3; i++) {
			System.out.println("Rodada " + (i + 18) + "ª");

			if (jogador1.getVez() == "vez") {
				System.out.print("\n" + getJogador1());
				System.out.println("\nTrunfo: " + cartaNipe + "Naipe: " + cartaNipe.getNipe() + "\n");

				System.out.print(getJogador2());
				System.out.println("\nTrunfo: " + cartaNipe + "Naipe: " + cartaNipe.getNipe() + "\n");
				System.out.println("Mão");
				System.out.println(getJogador1().getCartasJogador().get(pJ1) + "    X \n"
						+ getJogador2().getCartasJogador().get(pJ2));

				regraMesmoNipeSemSerTrunfo(jogador1, pJ1, jogador2, pJ2);
				regraCartaTrunfoEOutraNaoTrunfo(jogador1, pJ1, jogador2, pJ2);
				regraCartasMesmoNipeTrunfo(jogador1, pJ1, jogador2, pJ2);
				regraCartasNipesDiferentes(jogador1, pJ1, jogador2, pJ2);

			} else {
				System.out.print("\n" + getJogador2());

				System.out.println("\nTrunfo: " + cartaNipe + "Naipe: " + cartaNipe.getNipe() + "\n");

				System.out.print("\n" + getJogador1());
				System.out.println("\nTrunfo: " + cartaNipe + "Naipe: " + cartaNipe.getNipe() + "\n");

				System.out.println("Mão");
				System.out.println(getJogador2().getCartasJogador().get(pJ2) + "    X \n"
						+ getJogador1().getCartasJogador().get(pJ1));

				regraMesmoNipeSemSerTrunfo(jogador1, pJ1, jogador2, pJ2);
				regraCartaTrunfoEOutraNaoTrunfo(jogador1, pJ1, jogador2, pJ2);
				regraCartasMesmoNipeTrunfo(jogador1, pJ1, jogador2, pJ2);
				regraCartasNipesDiferentes(jogador2, pJ2, jogador1, pJ1);
			}

			regraReles(jogador1, pJ1, jogador2, pJ2);

			jogador1.getCartasJogador().remove(pJ1);

			jogador2.getCartasJogador().remove(pJ2);
		}
		System.out.println(jogador1.getNome() + " Pontos: " + jogador1.getPontos() + " \n" + jogador2.getNome()
				+ " Pontos: " + jogador2.getPontos());
	}

	public void resetarJogo() {
		getJogador1().setPontos(0);
		getJogador2().setPontos(0);
		getBaralho();
	}

	@Override
	public String toString() {

		return jogador1 + "\n" + jogador2 + "" + "\ntrunfo: " + cartaNipe + "" + "Naipe: " + cartaNipe.getNipe() + "\n";
	}

}
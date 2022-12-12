package bisca;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
	private String nome;
	private Integer pontos;
	private List<Carta> cartasJogador;
	private String Vez;
	
	
	public Jogador(String nome, int pontos,List<Carta> cartas) {
		this.nome = nome;
		this.pontos = pontos;
		this.cartasJogador = cartas;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getPontos() {
		return pontos;
	}


	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}


	public List<Carta> getCartasJogador() {
		return cartasJogador;
	}


	public void setCartasJogador(List<Carta> cartasJogador) {
		this.cartasJogador = new ArrayList<>();
	}
	
	
	public String getVez() {
		return Vez;
	}


	public void setVez(String vez) {
		Vez = vez;
	}


	public void somarPontos(int pontos) {
		this.pontos += pontos;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int cont = 0;
		for (Carta c : cartasJogador) {
			cont++;
			sb.append("("+cont+")  "+c);
		}
		return "\n" + nome +", pontos: "+ pontos + "\n\n Nª  Suas cartas \n\n" + sb.toString();
	}

}

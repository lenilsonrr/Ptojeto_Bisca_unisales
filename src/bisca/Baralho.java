package bisca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Baralho {

	private List<Carta> cartas = new ArrayList<>();

	private Random rand = new Random();

	public Baralho() {
		String[] faces = { "As", "2", "3", "4", "5", "6", "7", "Q", "J", "K" };
		for (int i = 0; i < faces.length; i++) {
			this.cartas.add(new Carta(faces[i], "Copas", 0));
			this.cartas.add(new Carta(faces[i], "Espadas", 0));
			this.cartas.add(new Carta(faces[i], "Ouros", 0));
			this.cartas.add(new Carta(faces[i], "Paus", 0));

			adicionadoValorAsCartas();
		}
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = new ArrayList<>();
	}

	public void adicionadoValorAsCartas() {
		for (int i = 0; i < cartas.size(); i++) {
			if (getCartas().get(i).getFaces() == ("As")) {
				getCartas().get(i).setValor(11);
				getCartas().get(i).setPeso(10);
			}
			if (getCartas().get(i).getFaces() == "7") {
				getCartas().get(i).setValor(10);
				getCartas().get(i).setPeso(9);
			}
			if (getCartas().get(i).getFaces() == "K") {
				getCartas().get(i).setValor(4);
				getCartas().get(i).setPeso(8);
			}
			if (getCartas().get(i).getFaces() == "J") {
				getCartas().get(i).setValor(3);
				getCartas().get(i).setPeso(7);
			}
			if (getCartas().get(i).getFaces() == "Q") {
				getCartas().get(i).setValor(2);
				getCartas().get(i).setPeso(6);
			}
			if (getCartas().get(i).getFaces() == "6") {
				getCartas().get(i).setPeso(5);
			}
			if (getCartas().get(i).getFaces() == "5") {
				getCartas().get(i).setPeso(4);
			}
			if (getCartas().get(i).getFaces() == "4") {
				getCartas().get(i).setPeso(3);
			}
			if (getCartas().get(i).getFaces() == "3") {
				getCartas().get(i).setPeso(2);
			}
			if (getCartas().get(i).getFaces() == "2") {
				getCartas().get(i).setPeso(1);
			}
		}
	}

	public void embaralhar() {
		Collections.shuffle(cartas);
	}

	public Carta cartaParaTrunfo() {
		int index = rand.nextInt(cartas.size() - 1);
		Carta cartaTrunfo = cartas.get(index);
		Collections.swap(cartas, index, cartas.size() - 1);
		if (cartaTrunfo.getFaces() == "7" || cartaTrunfo.getFaces() == "As") {
			index = rand.nextInt(cartas.size() - 1);
			cartaTrunfo = cartas.get(index);
			Collections.swap(cartas, index, cartas.size() - 1);
		}
		return cartaTrunfo;
	}

	public Carta comprarUmaCarta() {

		Carta retirandoCartas = cartas.get(0);
		cartas.remove(0);
		return retirandoCartas;
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

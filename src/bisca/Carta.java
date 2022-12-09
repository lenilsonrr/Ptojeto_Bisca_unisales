package bisca;

public class Carta {

	private String faces; 
	private String nipe;
	private int valor;
 	private int peso;

	


	public Carta(String faces, String nipe,int valor) {
		this.faces = faces;
		this.nipe = nipe;
		this.valor = valor;
	}

	public String getFaces() {
		return faces;
	}

	public void setFaces(String faces) {
		this.faces = faces;
	}

	public String getNipe() {
		return nipe;
	}

	public void setNipe(String nipe) {
		this.nipe = nipe;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	 public int getPeso(){
	  return peso;
	 }

	 public void setPeso(int peso){
	 this.peso = peso;
	 }

	@Override
	public String toString() {
		return faces + " de " + nipe +"\n";
	}
}

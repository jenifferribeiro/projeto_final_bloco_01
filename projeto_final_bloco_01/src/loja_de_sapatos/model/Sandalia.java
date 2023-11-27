package loja_de_sapatos.model;

public class Sandalia extends Produto {
	
	private String salto;

	public Sandalia(int id, String nome, int tipo, float preço, String salto) {
		super(id, nome, tipo, preço);
		this.salto = salto;

	}

	public String getSalto() {
		return salto;
	}

	public void setSalto(String salto) {
		this.salto = salto;
	}
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Tem salto? " + this.salto);
	}


}

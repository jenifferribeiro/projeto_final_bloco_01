package loja_de_sapatos.model;

public class Sapato extends Produto {
	
	private String estilo;

	public Sapato(int id, String nome, int tipo, float preço, String estilo) {
		super(id, nome, tipo, preço);
		this.estilo = estilo;
		
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	
	@Override 
	public void visualizar() {
		super.visualizar();
		System.out.println("Estilo: " + this.estilo);

	}
}

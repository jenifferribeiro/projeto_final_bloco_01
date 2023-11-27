package loja_de_sapatos.model;

public abstract class Produto {

	private int id;
	private String nome;
	private int tipo;
	private float preço;
	
	public Produto(int id, String nome, int tipo, float preço) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.preço = preço;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public float getPreço() {
		return preço;
	}

	public void setPreço(float preço) {
		this.preço = preço;
	}
	
	public void visualizar() {
		
		String tipo = "";
		
		switch(this.tipo) {
		case 1 -> tipo = "Sapato";
		case 2 -> tipo = "Sandalia";
		}
		
		System.out.println("Id do produto: " + this.id);
		System.out.println("Produto: " + this.nome);
		System.out.println("Categoria: " + tipo);
		System.out.println("Preço: " + this.preço);

	
	
	}
	
}

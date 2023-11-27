package loja_de_sapatos.repository;

import loja_de_sapatos.model.Produto;

public interface ProdutoRepository {
	
	// CRUD
	
		public void procurarPorId(int id);
		public void listarTodas();
		public void cadastrar(Produto nome);
		public void atualizar(Produto nome);
		public void deletar(int id);
	

}

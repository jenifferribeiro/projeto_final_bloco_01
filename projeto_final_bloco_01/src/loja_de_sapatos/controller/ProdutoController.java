package loja_de_sapatos.controller;

import java.util.ArrayList;
import java.util.Optional;

import loja_de_sapatos.model.Produto;
import loja_de_sapatos.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	// Criar a Collection
			private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
			
			// Variável para receber o id do produto
			int id = 0;

			@Override
			public void procurarPorId(int id) {
				Optional<Produto> produto = buscarNaCollection(id);
				
				if(produto.isPresent())
					produto.get().visualizar();
				else
					System.out.println("O produto número: " + id + " não foi encontrado!" );

				
			}

			@Override
			public void listarTodas() {
				for(var produto : listaProdutos) {
					produto.visualizar();
				}

				
			}

			@Override
			public void cadastrar(Produto nome) {
				listaProdutos.add(nome);
				System.out.println("O produto id: " + nome.getId() + " foi criado com Sucesso!");

				
			}

			@Override
			public void atualizar(Produto nome) {
				Optional<Produto> buscaNome = buscarNaCollection(nome.getId());
				
				if(buscaNome.isPresent()) {
						listaProdutos.set(listaProdutos.indexOf(buscaNome.get()), nome);
					
						System.out.println("O produto ID: " + nome.getId() + " foi atualizado com sucesso!");
				}else
					System.out.println("O produto ID: " + nome.getId() + " não foi encontrado!" );

				
			}

			@Override
			public void deletar(int id) {
				Optional<Produto> produto = buscarNaCollection(id);
				
				if(produto.isPresent()) {
					if (listaProdutos.remove(produto.get()) == true)
						System.out.println("O produto ID: " + id + " foi excluido com sucesso!");
				}else
					System.out.println("O produto ID: " + id + " não foi encontrado!" );

				
			}
			public int gerarID() {
				return ++ id;
				}

			
			public Optional<Produto> buscarNaCollection(int id) {
				for (var produto : listaProdutos) {
					if (produto.getId() == id)
						return Optional.of(produto);
				}
				return Optional.empty();
			}
}

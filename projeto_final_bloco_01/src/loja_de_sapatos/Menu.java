package loja_de_sapatos;

import java.io.IOException; 
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import loja_de_sapatos.controller.ProdutoController;
import loja_de_sapatos.model.Sandalia;
import loja_de_sapatos.model.Sapato;
import loja_de_sapatos.model.Produto;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		ProdutoController produtos = new ProdutoController();
		int opcao, id, tipo;
		String nome, estilo, salto;
		float preco;

		

		while (true) {

			System.out.println("       LOJA DE SAPATOS DO BAIRRO                 ");
			System.out.println("                                                 ");
			System.out.println("     1 - Criar produto                           ");
			System.out.println("     2 - Listar todos os produtos                ");
			System.out.println("     3 - Buscar produto por ID                   ");
			System.out.println("     4 - Atualizar produto                       ");
			System.out.println("     5 - Apagar produto                          ");
			System.out.println("     6 - Sair                                   ");
			System.out.println("                                                 ");
			System.out.println("*************************************************");
			System.out.println("Entre com a opção desejada:                      ");

			try {
				opcao = leia.nextInt();

			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 6) {
				System.out.println("\n Loja de Sapatos do Bairro agradece!");
				sobre();
				leia.close();
				System.exit(0);
			}
			switch (opcao) {
			case 1:
				System.out.println( "Criar produto" );
				
				System.out.println("Digite o nome do produto: ");
				leia.skip("\\R");
				nome = leia.nextLine();

				System.out.println("Digite o preço do produto: ");
				preco = leia.nextFloat();

				System.out.println("Digite o tipo do produto 1- Sapato ou 2- Sandalia: ");
				tipo = leia.nextInt();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o estilo do sapato:");
					leia.skip("\\R?");
					estilo = leia.nextLine();
					produtos.cadastrar(new Sapato(produtos.gerarID(), nome, tipo, preco, estilo));
				}
				case 2 -> {
					System.out.println("Digite o salto da sandália:");
					leia.skip("\\R?");
					salto = leia.nextLine();
					produtos.cadastrar(new Sandalia(produtos.gerarID(), nome, tipo, preco, salto));
				}

				}

				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os produtos");
				
				produtos.listarTodas();
				
				keyPress();
				break;
			case 3:
				System.out.println("Buscar produto por ID");
				
				System.out.println("Digite o ID do produto: ");
				id = leia.nextInt();
				
				produtos.procurarPorId(id);

				
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar produto");
				
				System.out.println("Digite o Id do produto: ");
				id = leia.nextInt();
				
				Optional<Produto> buscaNome = produtos.buscarNaCollection(id);
				
				if(buscaNome.isPresent()) {
					
					System.out.println("Digite o nome do produto: ");
					leia.skip("\\R?");
					nome = leia.nextLine();
					
					System.out.println("Digite o preço do produto: ");
					preco = leia.nextFloat();
					
					
					tipo = buscaNome.get().getTipo();
					
									
					switch(tipo) {
						case 1 -> {
							System.out.println("Digite o estilo do sapato: ");
							leia.skip("\\R?");
							estilo = leia.nextLine();
							produtos.atualizar(new Sapato(id, nome, tipo, preco, estilo));
						}
						case 2 -> {
							System.out.println("Digite o salto da sandalia:");
							leia.skip("\\R?");
							salto = leia.nextLine();
							produtos.atualizar(new Sandalia(id, nome, tipo, preco, salto));
						}
					}
				} else
					System.out.println("O produto número: " + id + " não foi encontrado!");

				keyPress();
				break;
			case 5:
				System.out.println("Apagar produto");
				
				System.out.println("Digite o ID do produto: ");
				id = leia.nextInt();
				
				produtos.deletar(id);

				
				keyPress();
				break;
			default:
				System.out.println("Opção Inválida!");
				keyPress();
				break;
			}		

		}

	}

	public static void sobre() {
		System.out.println("*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Jeniffer Ribeiro");
		System.out.println("github.com/jenifferribeiro");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {
		try {
			System.out.println("\n\nPressione a tecla Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou a tecla inválida!");
		}
	}
}

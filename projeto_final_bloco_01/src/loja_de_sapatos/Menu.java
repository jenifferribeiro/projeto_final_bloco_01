package loja_de_sapatos;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao;

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
				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os produtos");
				keyPress();
				break;
			case 3:
				System.out.println("Buscar produto por ID");
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar produto");
				keyPress();
				break;
			case 5:
				System.out.println("Apagar produto");
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

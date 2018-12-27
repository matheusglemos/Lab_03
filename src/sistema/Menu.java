package sistema;

import java.util.Scanner;

/**
 * Classe responsavel por exibir o menu do programa.
 * 
 * Responsavel por cadastrar um contato na agenda, exibir a listagem de todos os
 * contatos cadastrados e exibir informacoes sobre um contato especifico.
 * 
 * @author Matheus Gusmao Lemos - 117210399
 * 
 */
public class Menu {

	/**
	 * Dois atributos estaticos.
	 * 
	 * sc: leitura das entradas do usuario. agenda: Instancia da minha classe
	 * agenda.
	 */
	static Scanner sc = new Scanner(System.in);
	static Agenda agenda = new Agenda();

	/**
	 * Funcao principal do meu projeto.
	 * 
	 * @param args Nao e utilizado.
	 */
	public static void main(String[] args) {

		// Laco de execucao do meu programa.
		boolean cond = true;
		while (cond) {
			System.out.println("(C)adastrar Contato");
			System.out.println("(E)xibir Contato");
			System.out.println("(L)istar Contato");
			System.out.println("(S)air\n");
			System.out.print("Opção > ");
			String entrada = sc.nextLine();

			// Cadastro de um contato na agenda.
			if (entrada.toLowerCase().equals("c")) {
				cadastrar();
			}
			// Listagem dos contatos cadastrados na agenda.
			else if (entrada.toLowerCase().equals("l")) {
				listar();
			}
			// Exibicao de um contato especifico da agenda.
			else if (entrada.toLowerCase().equals("e")) {
				exibir();
			}
			// Saida do laco e encerramento do programa
			else if (entrada.toLowerCase().equals("s")) {
				break;
			} else {
				System.out.println("\n" + "OPÇÃO INVÁLIDA!" + "\n");
			}
		}
	}

	/**
	 * Metodo sem retorno responsavel por cadastrar um contato na agenda, atraves de
	 * metodos presentes na classe Agenda.
	 */
	private static void cadastrar() {
		System.out.print("\n" + "Posição: ");
		int posicao = Integer.parseInt(sc.nextLine());
		if (posicao <= 0 || posicao > 100) {
			System.out.println("\n" + "Posição Inválida!" + "\n");
			return;
		}
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Sobrenome: ");
		String sobrenome = sc.nextLine();
		System.out.print("Telefone: ");
		String telefone = sc.nextLine();

		try {
			agenda.cadastrarContato(posicao, nome, sobrenome, telefone);
			System.out.println("\n" + "CADASTRO REALIZADO!" + "\n");
		} catch (NullPointerException e) {
			System.out.println("\n" + e.getMessage() + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("\n" + e.getMessage() + "\n");
		}
	}

	/**
	 * Metodo sem retorno responsavel por exibir um contato que esta cadastrado na
	 * agenda, utiliza metodo da classe Agenda.
	 */
	private static void exibir() {
		System.out.print("Contato> ");
		int posicao = Integer.parseInt(sc.nextLine());
		try {
			String res = agenda.exibirContato(posicao);
			System.out.println("\n" + res + "\n");
		} catch (NullPointerException e) {
			System.out.println("\n" + e.getMessage() + "\n");
		}
	}

	/**
	 * Metodo sem retorno responsavel por listar todos os contatos cadastrados na
	 * agenda ate o momento, utiliza metodo da classe Agenda.
	 */
	private static void listar() {
		System.out.println("\n" + agenda.listarContato());
	}
}
package sistema;

import java.util.Arrays;

/**
 * Classe responsavel por uma agenda. Desde sua criacao com 100 espacos a
 * metodos que cadastram, exibem e listam os contatos.
 * 
 * @author Matheus Gusmao Lemos - 117210399
 *
 */
public class Agenda {

	/**
	 * Array do tipo Contatos, para armazenar todos os objetos(contatos).
	 */
	private Contato[] contatos;

	/**
	 * Construtor sem parametros, responsavel pela criacao de uma agenda com 100
	 * espacos.
	 */
	public Agenda() {
		this.contatos = new Contato[100];
	}

	/**
	 * Metodo booleano responsavel por cadastrar um contato na agenda.
	 * 
	 * @param posicao   referente a posicao que o contato devera ocupar na agenda(1
	 *                  a 100).
	 * @param nome      referente ao nome do contato a ser cadastrado.
	 * @param sobrenome referente ao sobrenome do contato a ser cadastrado.
	 * @param telefone  referente ao telefone do contato a ser cadastrado.
	 * @return true caso o contato seja cadastrado com sucesso, false caso nao
	 *         ocorra sucesso.
	 */
	public boolean cadastrarContato(int posicao, String nome, String sobrenome, String telefone) {

		if (posicao <= 0 || posicao > 100) {
			throw new IllegalArgumentException("Posição Inválida!");
		} else if (nome.trim().equals("")) {
			throw new NullPointerException("Nome Inválido!");
		} else if (sobrenome.trim().equals("")) {
			throw new NullPointerException("Sobrenome Inválido!");
		} else if (telefone.trim().equals("")) {
			throw new NullPointerException("Telefone Inválido!");
		} else {
			Contato contatos = new Contato(nome, sobrenome, telefone);
			this.contatos[posicao - 1] = contatos;
			return true;
		}
	}

	/**
	 * Metodo responsavel por exibir um contato cadastrado na agenda.
	 * 
	 * @param posicao referente a localizacao do contato na agenda.
	 * @return A representacao textual referente ao contato que devera ser exibido.
	 */
	public String exibirContato(int posicao) {
		if (contatos[posicao - 1] == null) {
			throw new NullPointerException("Não há contato nesta posição!");
		}
		return this.contatos[posicao - 1].toString();
	}

	/**
	 * Metodo responsavel por listar todos os contatos cadastrados na agenda ate o
	 * presente momento.
	 * 
	 * @return A representacao textual contendo o nome completo do contato.
	 */
	public String listarContato() {
		String resultado = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] == null) {
				continue;
			} else {
				resultado += i + 1 + " - " + contatos[i].getSaida() + "\n";
			}
		}
		return resultado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contatos);
		return result;
	}

	/**
	 * Metodo que verifica se o objeto em questao e o atual sao iguais.
	 * 
	 * @return true(iguais) ou false(diferentes).
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(contatos, other.contatos))
			return false;
		return true;
	}

}

package sistema;

/**
 * Classe responvel por um contato. Todos os contatos possuem nome, sobrenome e
 * telefone.
 * 
 * @author Matheus Gusmao Lemos - 117210399
 *
 */
public class Contato {

	/**
	 * Atributo responsavel pelo nome do contato.
	 */
	private String nome;
	/**
	 * Atributo responsavel pelo sobrenome do contato.
	 */
	private String sobrenome;
	/**
	 * Atributo responsavel pelo telefone do contato.
	 */
	private String telefone;

	/**
	 * Construtor de um contato.
	 * 
	 * @param nome      referente ao nome de um contato.
	 * @param sobrenome referente ao sobrenome de um contato.
	 * @param telefone  referente ao telefone de um contato.
	 */
	public Contato(String nome, String sobrenome, String telefone) {

		if (nome.trim().equals("")) {
			throw new NullPointerException("Nome Inválido!");
		}
		if (sobrenome.trim().equals("")) {
			throw new NullPointerException("Sobrenome Inválido!");
		}
		if (telefone.trim().equals("")) {
			throw new NullPointerException("Telefone Inválido!");
		}

		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}

	/**
	 * Metodo responsavel por retornar os detalhes do contato.
	 * 
	 * @return Ex: "Matheus Lemos - (83)996260379".
	 */
	public String toString() {
		return this.nome + " " + this.sobrenome + " - " + this.telefone;
	}

	/**
	 * Metodo responsavel por retornar o nome completo de um contato.
	 * 
	 * @return Ex: "Matheus Lemos".
	 */
	public String getSaida() {
		return this.nome + " " + this.sobrenome;
	}
}

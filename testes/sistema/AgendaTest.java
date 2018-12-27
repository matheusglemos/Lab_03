package sistema;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AgendaTest {

	private Agenda a1;
	private Agenda a2;
	private Agenda a3;
	
	@BeforeEach
	public void criaAgenda() {
		a1 = new Agenda();
		a2 = new Agenda();
		a3 = new Agenda();
	}
	
	@Test
	public void testCadastrarContatoPosVazia() {
		assertEquals(a1.cadastrarContato(1, "Matheus", "Gusmão", "83 96260379"), true);
		assertEquals(a2.cadastrarContato(56, "Lucas", "Diniz", "40028922"), true);
	}
	
	@Test
	public void testCadastrarContatoPosExistente() {
		assertEquals(a2.cadastrarContato(56, "João", "Lucas", "546464924"), true);
	}
	
	@Test
	public void testCadastrarContatoPosLimiteInferior() {
		assertEquals(a1.cadastrarContato(1, "Paulo", "Sobreira", "7851561569"), true);
	}
	
	@Test
	public void testCadastrarContatoPosLimiteSuperior() {
		assertEquals(a1.cadastrarContato(100, "Thiago", "Pereira", "789456123"), true);
	}
	
	@Test
	public void testCadastrarContatoPosInvalidaSuperior() {
		assertThrows(IllegalArgumentException.class, () -> a1.cadastrarContato(101, "Cesar", "Cielo", "7894561230"));	
	}
	
	@Test
	public void testCadastrarContatoPosInvalidaInferior() {
		assertThrows(IllegalArgumentException.class, () -> a1.cadastrarContato(0, "Michael", "Phelps", "213549559"));
	}
	
	@Test
	public void testCadastrarContatoNomeNull() {
		assertThrows(NullPointerException.class, () -> a1.cadastrarContato(10, null, "Lemos", "88052584"));
	}
	
	@Test
	public void testCadastrarContatoSobrenomeNull() {
		assertThrows(NullPointerException.class, () -> a1.cadastrarContato(12, "Lima", null, "87032620"));
	}
	
	@Test
	public void testCadastrarContatoTelefoneNull() {
		assertThrows(NullPointerException.class, () -> a1.cadastrarContato(56, "Velmer", "Almeida", null));
	}
	
	@Test
	public void testCadastrarContatoNomeVazio() {
		assertThrows(NullPointerException.class, () -> a1.cadastrarContato(78, "", "Limeira", "845166953"));
	}
	
	@Test
	public void testCadastrarContatoSobrenomeVazio() {
		assertThrows(NullPointerException.class, () -> a1.cadastrarContato(89, "Lucas", "", "7894495482"));
	}
	
	@Test
	public void testCadastrarContatoTelefoneVazio() {
		assertThrows(NullPointerException.class, () -> a1.cadastrarContato(52, "Abdias", "José", ""));
	}
	
	@Test
	public void testCadastrarContatoNomeException() {
		assertThrows(NullPointerException.class, () -> a1.cadastrarContato(46, "     ", "Honoravel", "94562379"));
	}
	
	@Test
	public void testCadastrarContatoSobrenomeException() {
		assertThrows(NullPointerException.class, () -> a1.cadastrarContato(71, "Ziel", "        ", "984546466"));
	}
	
	@Test
	public void testCadastrarContatoTelefoneException() {
		assertThrows(NullPointerException.class, () -> a1.cadastrarContato(63, "Macaco", "Prego", "         "));
	}
	
	@Test
	public void testCadastrarContatoTodosNull() {
		assertThrows(NullPointerException.class, () -> a1.cadastrarContato(50, null, null, null));
	}
	
	@Test
	public void testCadastrarContatoTodosVazios() {
		assertThrows(NullPointerException.class, () -> a1.cadastrarContato(81, "", "", ""));
	}
	
	@Test
	public void testCadastrarContatoTodosExceptions() {
		assertThrows(NullPointerException.class, () -> a1.cadastrarContato(8, "      ", "     " , "        "));
	}
	
	@Test
	public void testListarContatos() {
		a3.cadastrarContato(10, "Batman", "01", "789465231");
		a3.cadastrarContato(16, "Coringa", "01", "426597962");
		System.out.println(a3.listarContato());
		assertEquals(a3.listarContato(), "10 - Batman 01\n16 - Coringa 01\n");
	}
	
	@Test
	public void testExibirContatosPosOcupada() {
		a3.cadastrarContato(17, "Coringa", "01", "426597962");
		assertEquals(a3.exibirContato(17), "Coringa 01 - 426597962");
	}
	
	@Test
	public void testExibirContatoPosVazia() {
		assertThrows(NullPointerException.class, () -> a3.exibirContato(8));
	}
}

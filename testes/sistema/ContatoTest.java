package sistema;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContatoTest {

	private Contato c1;
	
	@BeforeEach
	public void setUp() {
		c1 = new Contato("Matheus", "Gusmão", "(83) 996260379");
	}
	
	@Test
	public void testToString() {
		assertEquals("Matheus Gusmão - (83) 996260379", c1.toString());
	}
	
	@Test
	public void testgetNome() {
		assertEquals("Matheus Gusmão", c1.getSaida());
	}
	
	@Test
	public void testC1NomeNull() {
		assertThrows(NullPointerException.class, () -> new Contato(null, "sobrenome", "telefone"));
	}
	
	@Test
	public void testC1SobrenomeNull() {
		assertThrows(NullPointerException.class, () -> new Contato("nome", null, "telefone"));
	}
	
	@Test
	public void testC1TelefoneNull() {
		assertThrows(NullPointerException.class, () -> new Contato("nome", "sobrenome", null));
	}
	
	@Test
	public void testC1NomeVazio() {
		assertThrows(NullPointerException.class, () -> new Contato("", "sobrenome", "telefone"));
	}
	
	@Test
	public void testC1SobrenomeVazio() {
		assertThrows(NullPointerException.class, () -> new Contato("nome", "", "telefone"));
	}
	
	@Test
	public void testC1TelefoneVazio() {
		assertThrows(NullPointerException.class, () -> new Contato("nome", "sobrenome", ""));
	}
	
	@Test
	public void testC1NomeException() {
		assertThrows(NullPointerException.class, () -> new Contato("      ", "sobrenome", "telefone"));
	}
	
	@Test
	public void testC1SobrenomeException() {
		assertThrows(NullPointerException.class, () -> new Contato("nome", "       ", "telefone"));
	}
	
	@Test
	public void testC1TelefoneException() {
		assertThrows(NullPointerException.class, () -> new Contato("nome", "sobrenome", "        "));
	}
	
	@Test
	public void testeC1TodosNull() {
		assertThrows(NullPointerException.class, () -> new Contato(null, null, null));
	}
	
	@Test
	public void testC1TodosVazios() {
		assertThrows(NullPointerException.class, () -> new Contato ("", "", ""));
	}
	
	@Test
	public void testC1TodosException() {
		assertThrows(NullPointerException.class, () -> new Contato ("     ", "       ", "        "));
	}

}


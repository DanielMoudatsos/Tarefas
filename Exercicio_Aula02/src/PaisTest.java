import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class PaisTest {

	Pais pais, copia;
	static int id = 0;

	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais(3, "Africa do sul",55000000,1220000.00 );
		copia = new Pais(3, "Africa do sul",55000000,1220000.00 );
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		Pais fixture = new Pais(1, "Brasil",200700000, 8516000.00);
		Pais novo = new Pais(1, null, -1, -1);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		pais.criar();
		id = pais.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", pais, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setPopulacao(210000000);
		copia.setPopulacao(210000000);		
		pais.atualizar();
		pais.carregar();
		assertEquals("testa atualizacao", pais, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(-1);
		copia.setArea(-1);
		pais.excluir();
		pais.carregar();
		assertEquals("testa exclusao", pais, copia);
	}
}

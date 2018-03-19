package Test;


	import static org.junit.Assert.assertEquals;
	import Model.Pais;

	import org.junit.Before;
	import org.junit.FixMethodOrder;
	import org.junit.Test;
	import org.junit.runners.MethodSorters;
	import Service.PaisService;

	@FixMethodOrder(MethodSorters.NAME_ASCENDING)
	public class PaisTest {
		Pais pais, copia;
		PaisService paisService;
		static int id = 0;

		@Before
		public void setUp() throws Exception {
			System.out.println("setup");
			pais = new Pais();
			pais.setId(10);
			pais.setNome("Espanha");
			pais.setPopulacao((long)4656000);
			pais.setArea(505.990);
			copia = new Pais();
			copia.setId(10);
			copia.setNome("Espanha");
			copia.setPopulacao((long)4656000);
			copia.setArea(505.990);
			paisService = new PaisService();
			System.out.println(pais);
			System.out.println(copia);
			System.out.println(id);
		}
		
		@Test
		public void test00Carregar() {
			System.out.println("carregar");
			Pais fixture = new Pais();
			fixture.setId(1);
			fixture.setNome("Alemanha");
			fixture.setPopulacao((long)8267000);
			fixture.setArea(357.376);
			PaisService novoService = new PaisService();
			Pais novo = novoService.carregar(1);
			assertEquals("testa inclusao", novo, fixture);
		}

		@Test
		public void test01Criar() {
			System.out.println("criar");
			id = PaisService.criar(pais);
			System.out.println(10);
			copia.setId(10);
			assertEquals("testa criacao", pais, copia);
		}

		@Test
		public void test02Atualizar() {
			System.out.println("atualizar");
			pais.setPopulacao((long)4656000);
			copia.setPopulacao((long)4656000);		
			paisService.atualizar(pais);
			pais = paisService.carregar(pais.getId());
			assertEquals("testa atualizacao", pais, copia);
		}

		@Test
		public void test03Excluir() {
			System.out.println("excluir");
			copia.setId(-1);
			copia.setNome(null);
			copia.setPopulacao(-1);
			copia.setArea(-1);
			paisService.excluir(id);
			pais = paisService.carregar(id);
			assertEquals("testa exclusao", pais, copia);
		}
	}

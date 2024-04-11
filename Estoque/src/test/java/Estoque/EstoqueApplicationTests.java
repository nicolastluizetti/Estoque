package Estoque;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import junit.framework.Assert;

@SpringBootTest
class EstoqueApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("teste");
	}

	@BeforeClass
	public static void iniciarTestes() {
	    System.out.println(">>> public static void iniciarTestes() <<<");
	}
	
	@AfterClass
	public static void encerrarTestes() {
	    System.out.println(">>> public static void encerrarTestes() <<<");
	}
	
	@Before
	public void iniciarTeste() {
	    System.out.println(">>> public void iniciarTeste() <<<");
	}
	
	@After
	public void encerrarTeste() {
	    System.out.println(">>> public void encerrarTeste() <<<");
	}
	
	@Test
	public void testandoAlgo() {
		System.out.println("testando algo");
	}
	
	@Test
	public void testandoOutraCoisa() {
	    System.out.println("testando outra coisa");
	

	}

}

package br.ufsc.ine.leb.sistemaBancario.testes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;
import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

@FixtureSetup(TesteBanco.class)
public class TesteAgencia {
	
	@Fixture private Banco bancoBB;
	@Fixture private SistemaBancario sistemaBancario;
	
	private Agencia bbCentro;
	
	@Before
	public void setUpAgencia() throws Exception{
		
		bbCentro = bancoBB.criarAgencia("Centro");
	}
	
	@Test
	public void testeAgencia(){
		assertEquals("001", bbCentro.obterIdentificador());
		assertEquals("Centro", bbCentro.obterNome());
		assertEquals(bancoBB, bbCentro.obterBanco());
	}

}

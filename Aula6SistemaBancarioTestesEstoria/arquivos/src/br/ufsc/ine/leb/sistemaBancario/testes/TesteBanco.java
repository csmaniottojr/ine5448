package br.ufsc.ine.leb.sistemaBancario.testes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteBanco {
	
	private Banco bancoBB;
	private SistemaBancario sistemaBancario;
	
	@Before
	public void setUpBanco() throws Exception{
		
		sistemaBancario = new SistemaBancario();
		bancoBB = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		
	}
	
	@Test
	public void testeBanco() throws Exception{
		assertEquals("Banco do Brasil", bancoBB.obterNome());
		assertEquals(Moeda.BRL, bancoBB.obterMoeda());
	}

}

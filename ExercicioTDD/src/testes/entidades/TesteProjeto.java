package testes.entidades;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import entidades.Projeto;

public class TesteProjeto {
	
	@Test
	public void piloto() throws Exception{
		Projeto piloto = new Projeto(1, "piloto", "meu projeto piloto");
		assertEquals("piloto - meu projeto piloto", piloto.toString());
	}
	
	@Test
	public void igualdade() throws Exception{
		Projeto piloto = new Projeto(1, "piloto", "meu projeto piloto");
		Projeto piloto1 = new Projeto(1, "piloto1", "meu projeto piloto1");
		assertEquals(piloto, piloto1);
	}

}

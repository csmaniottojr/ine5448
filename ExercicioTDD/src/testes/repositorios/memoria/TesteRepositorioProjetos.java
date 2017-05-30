package testes.repositorios.memoria;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import entidades.Projeto;
import excecoes.ProjetoJaCadastrado;
import repositorios.memoria.RepositorioProjetos;

public class TesteRepositorioProjetos {
	
	RepositorioProjetos repositorio;
	
	@Before
	public void setupRepositorio(){
		repositorio = new RepositorioProjetos();
	}
	
	@Test
	public void repositorioVazio(){
		assertEquals(0, repositorio.listar().size());			
	}
	
	@Test
	public void cadastrarFuncionario() throws Exception{
		Projeto piloto = new Projeto(1, "piloto", "meu projeto piloto");
		repositorio.cadastrar(piloto);
		assertEquals(1, repositorio.listar().size());
		assertEquals(piloto, repositorio.listar().get(0));
	}
	
	@Test(expected=ProjetoJaCadastrado.class)
	public void cadastrarFuncionarioJaExistente() throws Exception{
		Projeto piloto = new Projeto(1, "piloto", "meu projeto piloto");
		repositorio.cadastrar(piloto);
		repositorio.cadastrar(piloto);
	}
	
	

}

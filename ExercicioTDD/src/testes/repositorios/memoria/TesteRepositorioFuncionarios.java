package testes.repositorios.memoria;

import org.junit.Before;
import org.junit.Test;

import entidades.Funcionario;
import excecoes.FuncionarioJaCadastrado;
import static org.junit.Assert.*;
import repositorios.memoria.RepositorioFuncionarios;

public class TesteRepositorioFuncionarios {
	
	private RepositorioFuncionarios repositorio; 
	
	@Before
	public void setupRepositorio() throws Exception{
		repositorio = new RepositorioFuncionarios();
	}
	
	@Test
	public void repositorioVazio(){
		assertEquals(0, repositorio.listar().size());			
	}
	
	@Test
	public void cadastrarFuncionario() throws Exception{
		Funcionario cesar = new Funcionario(1, "Cesar");
		repositorio.cadastrar(cesar);
		assertEquals(1, repositorio.listar().size());
		assertEquals(cesar, repositorio.listar().get(0));
	}
	
	@Test(expected = FuncionarioJaCadastrado.class)
	public void cadastrarFuncionarioJaExistente() throws Exception{
		Funcionario cesar = new Funcionario(1, "Cesar");
		repositorio.cadastrar(cesar);
		repositorio.cadastrar(cesar);
	}

}

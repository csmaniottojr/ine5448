package testes.repositorios.memoria;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import entidades.Funcionario;
import entidades.Ocorrencia;
import entidades.Prioridade;
import entidades.TipoOcorrencia;
import excecoes.OcorrenciaJaCadastrada;
import repositorios.memoria.RepositorioOcorrencias;

public class TesteRepositorioOcorrencias {
	
	RepositorioOcorrencias repositorio;
	
	@Before
	public void setupRepositorio(){
		repositorio = new RepositorioOcorrencias();
	}
	
	@Test
	public void repositorioVazio(){
		assertEquals(0, repositorio.listar().size());			
	}
	
	@Test
	public void cadastrarFuncionario() throws Exception{
		Ocorrencia bugPrioridadeAlta = new Ocorrencia(1, "Bug prioridade Alta", TipoOcorrencia.BUG, Prioridade.ALTA);
		repositorio.cadastrar(bugPrioridadeAlta);
		assertEquals(1, repositorio.listar().size());
		assertEquals(bugPrioridadeAlta, repositorio.listar().get(0));
	}
	
	@Test(expected=OcorrenciaJaCadastrada.class)
	public void cadastrarFuncionarioJaExistente() throws Exception{
		Ocorrencia bugPrioridadeAlta = new Ocorrencia(1, "Bug prioridade Alta", TipoOcorrencia.BUG, Prioridade.ALTA);
		
		repositorio.cadastrar(bugPrioridadeAlta);
		repositorio.cadastrar(bugPrioridadeAlta);
	}
	
	

}

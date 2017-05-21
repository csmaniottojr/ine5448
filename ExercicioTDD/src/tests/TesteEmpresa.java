package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entities.Empresa;
import entities.Funcionario;
import entities.Ocorrencia;
import entities.Prioridade;
import entities.Projeto;
import entities.TipoOcorrencia;
import exceptions.FuncionarioComExcessoDeOcorrencias;


public class TesteEmpresa {
	
	private Empresa empresa;
	
	@Before
	public void setupEmpresa(){
		this.empresa = new Empresa();		
	}
	
	@Test
	public void testeCadastrarFuncionario() throws Exception{
		Funcionario func = this.empresa.cadastrarFuncionario("Cesar");
		assertEquals("Cesar", func.getNome());
	}
	
	@Test
	public void testeCadastrarProjeto() throws Exception{
		Projeto proj = empresa.cadastrarProjeto("MeuProjeto");
		assertEquals("MeuProjeto", proj.getResumo());
	}
	
	@Test
	public void testeCadastrarOcorrencia() throws Exception{
		Projeto proj = empresa.cadastrarProjeto("MeuProjeto");
		Funcionario func = empresa.cadastrarFuncionario("Cesar");
		Ocorrencia oc = proj.cadastrarOcorrencia("MinhaOcorrencia", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		assertEquals("MinhaOcorrencia", oc.getNome());
		assertEquals("Cesar", oc.getResponsavel().getNome());
		assertEquals(TipoOcorrencia.BUG, oc.getTipo());
		assertTrue(oc.estaAberta());
		assertEquals(Prioridade.ALTA, oc.getPrioridade());
		assertTrue(func.funcionarioEstaAtendendoOcorrencia(oc));
	}
	
	@Test(expected=FuncionarioComExcessoDeOcorrencias.class)
	public void testeCadastrarOcorrenciaAlemLimiteFuncionario() throws Exception{
		Projeto proj = empresa.cadastrarProjeto("MeuProjeto");
		Funcionario func = empresa.cadastrarFuncionario("Cesar");

		proj.cadastrarOcorrencia("MinhaOcorrencia1", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia2", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia3", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia4", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia5", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia6", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia7", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia8", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia9", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia10", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia11", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		
	}
	
	@Test
	public void testeConcluirOcorrencia() throws Exception{
		
		Funcionario func = empresa.cadastrarFuncionario("Cesar");
		Projeto proj = empresa.cadastrarProjeto("MeuProjeto");
		Ocorrencia oc = proj.cadastrarOcorrencia("MinhaOcorrencia", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		assertTrue(oc.estaAberta());
		assertTrue(func.funcionarioEstaAtendendoOcorrencia(oc));
		oc.concluirOcorrencia();
		assertFalse(oc.estaAberta());
		assertFalse(func.funcionarioEstaAtendendoOcorrencia(oc));
	}
	

}

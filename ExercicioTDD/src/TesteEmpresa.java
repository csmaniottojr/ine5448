
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


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
		assertEquals(true, oc.estaAberta());
		assertEquals(Prioridade.ALTA, oc.getPrioridade());
	}
	
	@Test(expected=FuncionarioComExcessoDeOcorrencias.class)
	public void testeCadastrarOcorrenciaAlemLimiteFuncionario() throws Exception{
		Projeto proj = empresa.cadastrarProjeto("MeuProjeto");
		Funcionario func = empresa.cadastrarFuncionario("Cesar");

		proj.cadastrarOcorrencia("MinhaOcorrencia", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		proj.cadastrarOcorrencia("MinhaOcorrencia", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		
	}
	
	@Test
	public void testeConcluirOcorrencia() throws Exception{
		
		Funcionario func = empresa.cadastrarFuncionario("Cesar");
		Projeto proj = empresa.cadastrarProjeto("MeuProjeto");
		Ocorrencia oc = proj.cadastrarOcorrencia("MinhaOcorrencia", func, TipoOcorrencia.BUG, Prioridade.ALTA);
		oc.concluirOcorrencia();
		assertEquals(false, oc.estaAberta());
	}
	

}

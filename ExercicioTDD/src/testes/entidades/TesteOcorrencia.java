package testes.entidades;

import static org.junit.Assert.*;

import org.junit.Test;

import entidades.Funcionario;
import entidades.Ocorrencia;
import entidades.Prioridade;
import entidades.Projeto;
import entidades.TipoOcorrencia;
import excecoes.FuncionarioComExcessoDeOcorrencias;

public class TesteOcorrencia {
	
	
	@Test
	public void bugPrioridadeAltaSemResponsavel() throws Exception{
		Ocorrencia bugPrioridadeAlta = new Ocorrencia(1, "Bug prioridade Alta", TipoOcorrencia.BUG, Prioridade.ALTA);
		assertEquals("Bug prioridade Alta", bugPrioridadeAlta.toString());
		assertEquals("Bug prioridade Alta", bugPrioridadeAlta.getNome());
		assertEquals(TipoOcorrencia.BUG, bugPrioridadeAlta.getTipo());
		assertTrue(bugPrioridadeAlta.estaAberta());
		assertEquals(Prioridade.ALTA, bugPrioridadeAlta.getPrioridade());
	}
	
	@Test
	public void igualdade() throws Exception{
		Ocorrencia bugPrioridadeAlta = new Ocorrencia(1, "Bug prioridade Alta", TipoOcorrencia.BUG, Prioridade.ALTA);
		Ocorrencia bugPrioridadeAlta2 = new Ocorrencia(1, "Bug prioridade Alta", TipoOcorrencia.BUG, Prioridade.ALTA);
		assertEquals(bugPrioridadeAlta, bugPrioridadeAlta2);
	}
	
	@Test
	public void definirResponsavel() throws Exception{
		Funcionario responsavel = new Funcionario(1, "Cesar");
		Ocorrencia bugPrioridadeAlta = new Ocorrencia(1, "Bug prioridade Alta", TipoOcorrencia.BUG, Prioridade.ALTA);
		
		assertNull(bugPrioridadeAlta.getResponsavel());
		assertFalse(responsavel.estaAtendendoOcorrencia(bugPrioridadeAlta));
		
		bugPrioridadeAlta.definirResponsavel(responsavel);
		
		assertEquals("Cesar", bugPrioridadeAlta.getResponsavel().getNome());
		assertTrue(responsavel.estaAtendendoOcorrencia(bugPrioridadeAlta));
	}
	
	@Test
	public void testeConcluirOcorrencia() throws Exception{
		
		Funcionario responsavel = new Funcionario(1, "Cesar");
		Ocorrencia bugPrioridadeAlta = new Ocorrencia(1, "Bug prioridade Alta", TipoOcorrencia.BUG, Prioridade.ALTA);
		assertTrue(bugPrioridadeAlta.estaAberta());
		bugPrioridadeAlta.definirResponsavel(responsavel);
		assertTrue(responsavel.estaAtendendoOcorrencia(bugPrioridadeAlta));
		bugPrioridadeAlta.concluirOcorrencia();
		assertFalse(bugPrioridadeAlta.estaAberta());
		assertFalse(responsavel.estaAtendendoOcorrencia(bugPrioridadeAlta));
	}
	
	


}

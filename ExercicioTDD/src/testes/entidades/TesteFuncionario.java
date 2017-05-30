package testes.entidades;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import entidades.Funcionario;
import entidades.Ocorrencia;
import entidades.Prioridade;
import entidades.TipoOcorrencia;
import excecoes.FuncionarioComExcessoDeOcorrencias;
import excecoes.FuncionarioComOcorrenciaJaIncluida;

public class TesteFuncionario {
	
	@Test
	public void funcionarioCesar() throws Exception{
		Funcionario cesar = new Funcionario(1, "Cesar");
		assertEquals("Cesar", cesar.toString());
	}
	
	@Test
	public void igualdade() throws Exception{
		Funcionario cesar = new Funcionario(1, "Cesar");
		Funcionario cesar2 = new Funcionario(1, "Cesar");
		Funcionario cezar = new Funcionario(1, "Cezar");
		assertEquals(cesar, cesar2);
		assertEquals(cesar, cezar);
		
	}
	
	@Test(expected=FuncionarioComExcessoDeOcorrencias.class)
	public void adicionarOcorrenciaFuncionarioComExcesso() throws Exception{
		
		Funcionario responsavel = new Funcionario(1, "Cesar");
		
		for(int i=0; i < 11; i++){
			Ocorrencia bugPrioridadeAlta = new Ocorrencia(i, "Bug prioridade Alta", TipoOcorrencia.BUG, Prioridade.ALTA);
			bugPrioridadeAlta.definirResponsavel(responsavel);
		}
		
	}
	
	@Test(expected=FuncionarioComOcorrenciaJaIncluida.class)
	public void adicionarOcorrenciaDuplicada() throws Exception{
		
		Funcionario responsavel = new Funcionario(1, "Cesar");
		
		for(int i=0; i < 2; i++){
			Ocorrencia bugPrioridadeAlta = new Ocorrencia(1, "Bug prioridade Alta", TipoOcorrencia.BUG, Prioridade.ALTA);
			bugPrioridadeAlta.definirResponsavel(responsavel);
		}
		
	}

}

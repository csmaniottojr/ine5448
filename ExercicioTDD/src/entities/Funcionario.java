package entities;
import java.util.ArrayList;
import java.util.List;

import exceptions.FuncionarioComExcessoDeOcorrencias;


public class Funcionario {
	
	private String nome;
	private List<Ocorrencia> ocorrencias;
	private final int NUM_MAX_OCORRENCIAS = 10;

	public Funcionario(String nome) {
		this.nome = nome;
		this.ocorrencias = new ArrayList<Ocorrencia>();
	}

	public String getNome() {
		return this.nome;
	}
	
	public boolean funcionarioEstaAtendendoOcorrencia(Ocorrencia oc){
		return ocorrencias.contains(oc);
	}
	
	public void adicionarOcorrencia(Ocorrencia oc) throws FuncionarioComExcessoDeOcorrencias{
		
		if(ocorrencias.size() < NUM_MAX_OCORRENCIAS){
			ocorrencias.add(oc);
		}
		else{
			String msg = "Funcionário excedeu número máximo de ocorrências atendidas: " + NUM_MAX_OCORRENCIAS;
			throw new FuncionarioComExcessoDeOcorrencias(msg);
		}
		
	}
	
	public void removerOcorrencia(Ocorrencia oc){
		ocorrencias.remove(oc);
	}

}

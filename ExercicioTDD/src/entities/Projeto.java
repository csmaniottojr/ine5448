package entities;
import java.util.ArrayList;
import java.util.List;

import exceptions.FuncionarioComExcessoDeOcorrencias;

public class Projeto {

	private String resumo;
	private List<Ocorrencia> ocorrencias;
	
	public Projeto(String resumo) {
		this.resumo = resumo;
		this.ocorrencias = new ArrayList<Ocorrencia>();
	}

	public String getResumo() {
		// TODO Auto-generated method stub
		return resumo;
	}

	public Ocorrencia cadastrarOcorrencia(String nomeOcorrencia, Funcionario responsavel, TipoOcorrencia tipo, Prioridade prioridade) throws FuncionarioComExcessoDeOcorrencias {
		Ocorrencia oc = new Ocorrencia(nomeOcorrencia, responsavel, tipo, prioridade);
		responsavel.adicionarOcorrencia(oc);
		ocorrencias.add(oc);
		return oc;
		
	}

}

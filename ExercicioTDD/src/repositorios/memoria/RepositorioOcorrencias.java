package repositorios.memoria;

import java.util.ArrayList;
import java.util.List;

import entidades.Ocorrencia;
import excecoes.FuncionarioJaCadastrado;
import excecoes.OcorrenciaJaCadastrada;
import repositorios.IRepositorio;

public class RepositorioOcorrencias implements IRepositorio<Ocorrencia>{

	private List<Ocorrencia> ocorrencias;
	
	public RepositorioOcorrencias() {
		ocorrencias = new ArrayList<Ocorrencia>();
	}
	
	@Override
	public List<Ocorrencia> listar() {
		return ocorrencias;
	}

	@Override
	public void cadastrar(Ocorrencia ocorrencia) {
		if(ocorrencias.contains(ocorrencia)){
			throw new OcorrenciaJaCadastrada("Ocorrência " + ocorrencia + " já cadastrada anteriormente");
		}
		ocorrencias.add(ocorrencia);			
	}

}

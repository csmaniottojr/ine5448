package repositorios.memoria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import repositorios.IRepositorio;
import entidades.Projeto;
import excecoes.ProjetoJaCadastrado;

public class RepositorioProjetos implements IRepositorio<Projeto>{
	
	private List<Projeto> projetos;
	
	public RepositorioProjetos() {
		projetos = new ArrayList<Projeto>();
	}




	@Override
	public List<Projeto> listar() {
		return projetos;
	}

	@Override
	public void cadastrar(Projeto projeto) {
		if(projetos.contains(projeto)){
			throw new ProjetoJaCadastrado("Projeto " + projeto + " cadastrado anteriormente");
		}
		projetos.add(projeto);
		
	}

}

package entidades;
import java.util.ArrayList;
import java.util.List;

import excecoes.FuncionarioComExcessoDeOcorrencias;

public class Projeto {

	private int id;
	private String nome;
	private String resumo;
	
	public Projeto(int id, String nome, String resumo) {
		this.id = id;
		this.nome = nome;
		this.resumo = resumo;
	}

	@Override
	public String toString() {
		return String.format("%s - %s", nome, resumo);
	}
	
	@Override
	public boolean equals(Object objeto) {
		if(objeto instanceof Projeto){
			Projeto outroProjeto = (Projeto) objeto;
			return id == outroProjeto.getId();
		}
		return false;
	}

	public int getId() {
		return id;
	}

}

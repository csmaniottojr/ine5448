package entidades;

import excecoes.FuncionarioComExcessoDeOcorrencias;

public class Ocorrencia {
	
	private int id;
	private String nome;
	private Funcionario responsavel;
	private TipoOcorrencia tipo;
	private Prioridade prioridade;
	private boolean estaAberta;

	public Ocorrencia(int id, String nome, TipoOcorrencia tipo, Prioridade prioridade) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.prioridade = prioridade;
		this.estaAberta = true;

	}

	@Override
	public String toString() {
		return nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ocorrencia) {
			Ocorrencia outraOcorrencia = (Ocorrencia) obj;
			return id == outraOcorrencia.getId();
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public TipoOcorrencia getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}

	public Funcionario getResponsavel() {
		// TODO Auto-generated method stub
		return responsavel;
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}

	public boolean estaAberta() {
		// TODO Auto-generated method stub
		return estaAberta;
	}
	
	public void definirResponsavel(Funcionario responsavel) throws FuncionarioComExcessoDeOcorrencias{
		responsavel.adicionarOcorrencia(this);
		this.responsavel = responsavel;
	}
	
	public void concluirOcorrencia(){
		estaAberta = false;
		if(responsavel != null){
			responsavel.removerOcorrencia(this);
		}
	}

}

package entities;

public class Ocorrencia {
	
	private String nome;
	private Funcionario responsavel;
	private TipoOcorrencia tipo;
	private Prioridade prioridade;
	private boolean estaAberta;

	public Ocorrencia(String nome, Funcionario responsavel, TipoOcorrencia tipo, Prioridade prioridade) {
		this.nome = nome;
		this.tipo = tipo;
		this.prioridade = prioridade;
		this.responsavel = responsavel;
		this.estaAberta = true;
	}

	public String getNome() {
		return nome;
	}

	public boolean estaAberta() {
		return estaAberta;
	}

	public TipoOcorrencia getTipo() {
		return tipo;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void concluirOcorrencia() {
		estaAberta = false;		
		responsavel.removerOcorrencia(this);
	}

}


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
		// TODO Auto-generated method stub
		return nome;
	}

	public boolean estaAberta() {
		// TODO Auto-generated method stub
		return estaAberta;
	}

	public TipoOcorrencia getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}

	public Prioridade getPrioridade() {
		// TODO Auto-generated method stub
		return prioridade;
	}

	public Funcionario getResponsavel() {
		// TODO Auto-generated method stub
		return responsavel;
	}

	public void concluirOcorrencia() {
		estaAberta = false;		
	}

}

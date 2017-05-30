package excecoes;

@SuppressWarnings("serial")
public class FuncionarioComExcessoDeOcorrencias extends Exception {
	
	public FuncionarioComExcessoDeOcorrencias(String mensagem) {
		super(mensagem);
	}

}

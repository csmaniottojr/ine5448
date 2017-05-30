package excecoes;

public class FuncionarioJaCadastrado extends RuntimeException {
	
	public FuncionarioJaCadastrado(String msg) {
		super(msg);
	}

}

/**
 * 
 */
package br.ufsc.ine.leb.sistemaBancario.testes;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import br.ufsc.ine.leb.sistemaBancario.Conta;

/**
 * @author cesar
 *
 */
public class ContaMatcher extends BaseMatcher<Conta> implements Matcher<Conta>{
	
	String identificador;
	String nomeCliente;
	String nomeBanco;
	String nomeAgencia;


	public ContaMatcher(String identificador, String nomeCliente, String nomeBanco,
			String nomeAgencia) {
		super();
		this.identificador = identificador;
		this.nomeCliente = nomeCliente;
		this.nomeBanco = nomeBanco;
		this.nomeAgencia = nomeAgencia;
	}

	/* (non-Javadoc)
	 * @see org.hamcrest.SelfDescribing#describeTo(org.hamcrest.Description)
	 */
	@Override
	public void describeTo(Description descricao) {
		descricao.appendText("Conta de identificador ");
		descricao.appendValue(this.identificador);
		descricao.appendText(" do cliente ");
		descricao.appendValue(this.nomeCliente);
		descricao.appendText(" da Agência ");
		descricao.appendValue(this.nomeAgencia);
		descricao.appendText(" do banco ");
		descricao.appendValue(this.nomeBanco);
		
	}
	
	public void describeMismatch(Object item, Description descricao) {
		if (item != null && item instanceof Conta){
			Conta conta = (Conta) item;
			
			descricao.appendText("Conta de identificador ");
			descricao.appendValue(conta.obterIdentificador());
			descricao.appendText(" do cliente ");
			descricao.appendValue(conta.obterTitular());
			descricao.appendText(" da Agência ");
			descricao.appendValue(conta.obterAgencia().obterNome());
			descricao.appendText(" do banco ");
			descricao.appendValue(conta.obterAgencia().obterBanco().obterNome());
			
		}else{
			super.describeMismatch(item, descricao);
		}
		
	};

	/* (non-Javadoc)
	 * @see org.hamcrest.Matcher#matches(java.lang.Object)
	 */
	@Override
	public boolean matches(Object item) {
		if (item != null && item instanceof Conta){
			Conta conta = (Conta) item;
			return conta.obterIdentificador().equals(this.identificador) && 
					conta.obterTitular().equals(this.nomeCliente) && 
					conta.obterAgencia().obterNome().equals(this.nomeAgencia) && 
					conta.obterAgencia().obterBanco().obterNome().equals(this.nomeBanco); 
		}
		return false;
	}

}

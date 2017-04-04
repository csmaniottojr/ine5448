/**
 * 
 */
package br.ufsc.ine.leb.sistemaBancario.testes;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.number.OrderingComparison.*;
import static org.junit.Assert.*;
/**
 * @author cesar
 *
 */
public class TesteContaComHamcrest {
	
public SistemaBancario sistemaBancario;
	
	@Before
	public void setUpSistemaBancario(){
		this.sistemaBancario = new SistemaBancario();
	}
	
	public Banco setUpBanco(String nomeBanco, Moeda moeda){
		return this.sistemaBancario.criarBanco(nomeBanco, moeda);
	}

	public Agencia setUpAgencia(String nomeBanco, Moeda moeda, String nomeAg){
		return setUpBanco(nomeBanco, moeda).criarAgencia(nomeAg);
	}
	
	public Conta setUpConta(String nomeBanco, Moeda moeda, String nomeAg, String nomeTitular, Dinheiro saldoInicial){
		Conta ccMaria = setUpAgencia(nomeBanco, moeda, nomeAg).criarConta(nomeTitular);
		this.sistemaBancario.depositar(ccMaria, saldoInicial);
		return ccMaria;
	}
	
	@Test
	public void testContaSucess() throws Exception{
		Conta conta = setUpConta("BB", Moeda.BRL, "Trindade", "Maria", new Dinheiro(Moeda.BRL, 20, 0));
		assertThat(conta, new ContaMatcher("0001-5","Maria","BB", "Trindade"));
	}
	
	@Test
	public void testContaFailure() throws Exception{
		Conta conta = setUpConta("BB", Moeda.BRL, "Trindad", "Maria", new Dinheiro(Moeda.BRL, 20, 0));
		assertThat(conta, not(new ContaMatcher("0001-5","Maria","BB", "Trindade")));
	}

}

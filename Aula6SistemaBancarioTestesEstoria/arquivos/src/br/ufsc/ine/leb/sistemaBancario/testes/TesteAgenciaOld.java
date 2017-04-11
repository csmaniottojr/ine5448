package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Entrada;
import br.ufsc.ine.leb.sistemaBancario.EstadosDeOperacao;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.Operacao;
import br.ufsc.ine.leb.sistemaBancario.Saida;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

public class TesteAgenciaOld {
	
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
	
	public Conta setUpConta(String nomeBanco, Moeda moeda, String nomeAg, Dinheiro saldoInicial){
		Conta ccMaria = setUpAgencia(nomeBanco, moeda, nomeAg).criarConta("Maria");
		this.sistemaBancario.depositar(ccMaria, saldoInicial);
		return ccMaria;
	}
	
	//1
	@Test
	public void criarBancoBB() throws Exception{
		Banco bb = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		
		assertEquals("Banco do Brasil", bb.obterNome());
		assertEquals(Moeda.BRL, bb.obterMoeda());
	}
	//2
	@Test
	public void criarAgenciaBBCentro() throws Exception {
		Banco bb = setUpBanco("Banco do Brasil", Moeda.BRL);
		Agencia bbCentro = bb.criarAgencia("Centro");
		
		assertEquals("001", bbCentro.obterIdentificador());
		assertEquals("Centro", bbCentro.obterNome());
		assertEquals(bb, bbCentro.obterBanco());
	}
	//3
	@Test
	public void criarContaMariaBB() throws Exception{
		Agencia bbCentro = setUpAgencia("Banco do Brasil", Moeda.BRL, "Centro");
		Conta ccMaria = bbCentro.criarConta("Maria");
		
		assertEquals("Maria", ccMaria.obterTitular());
		assertEquals("0001-5", ccMaria.obterIdentificador());
		assertEquals(new ValorMonetario(Moeda.BRL).somar(new Dinheiro(Moeda.BRL, 0, 0)), ccMaria.calcularSaldo());
		assertEquals(bbCentro, ccMaria.obterAgencia());
		
		
	}
	//4
	@Test
	public void depositoEmConta() throws Exception{
		Conta ccMaria = setUpConta("Banco do Brasil", Moeda.BRL, "Centro", new Dinheiro(Moeda.BRL, 0, 0));
		
		Dinheiro _10reais = new Dinheiro(Moeda.BRL, 10, 0);	
		Operacao op = sistemaBancario.depositar(ccMaria, _10reais);
		assertEquals(EstadosDeOperacao.SUCESSO,op.obterEstado());
		assertEquals(ccMaria.calcularSaldo(), new ValorMonetario(Moeda.BRL).somar(_10reais));
	}
	//5
	@Test
	public void saqueEmContaComSaldoSuficiente() throws Exception{
		Conta ccMaria = setUpConta("Banco do Brasil", Moeda.BRL, "Centro", new Dinheiro(Moeda.BRL, 10, 0));

		Dinheiro _6reais = new Dinheiro(Moeda.BRL, 6, 0);
		Operacao op = sistemaBancario.sacar(ccMaria, _6reais);
		assertEquals(EstadosDeOperacao.SUCESSO,op.obterEstado());
		Dinheiro _4reais = new Dinheiro(Moeda.BRL, 4, 0);
		assertEquals(ccMaria.calcularSaldo(), new ValorMonetario(Moeda.BRL).somar(_4reais));
	}
	//6
	@Test
	public void saqueComSaldoInsuficiente() throws Exception{
		Dinheiro _4reais = new Dinheiro(Moeda.BRL, 4, 0);
		Conta ccMaria = setUpConta("Banco do Brasil", Moeda.BRL, "Centro",_4reais);
		
		Dinheiro _6reais = new Dinheiro(Moeda.BRL, 6, 0);
		Operacao op = sistemaBancario.sacar(ccMaria, _6reais);
		assertEquals(op.obterEstado(), EstadosDeOperacao.SALDO_INSUFICIENTE);
		assertEquals(ccMaria.calcularSaldo(), new ValorMonetario(Moeda.BRL).somar(_4reais));
		
	}
}

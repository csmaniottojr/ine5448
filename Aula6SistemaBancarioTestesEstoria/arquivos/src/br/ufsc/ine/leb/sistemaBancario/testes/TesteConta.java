package br.ufsc.ine.leb.sistemaBancario.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;
import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.EstadosDeOperacao;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.Operacao;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

@FixtureSetup(TesteAgencia.class)
public class TesteConta {
	
	@Fixture private Agencia bbCentro;
	@Fixture private SistemaBancario sistemaBancario;
		
	private Conta ccMaria;
	
	@Before 
	public void setUpConta(){
		ccMaria = bbCentro.criarConta("Maria");
	}
	
	@Test
	public void testeConta(){
		assertEquals("Maria", ccMaria.obterTitular());
		assertEquals("0001-5", ccMaria.obterIdentificador());
		assertEquals(new ValorMonetario(Moeda.BRL).somar(new Dinheiro(Moeda.BRL, 0, 0)), ccMaria.calcularSaldo());
		assertEquals(bbCentro, ccMaria.obterAgencia());
	}
	
	//4
		@Test
		public void depositoEmConta() throws Exception{
			
			Dinheiro _10reais = new Dinheiro(Moeda.BRL, 10, 0);	
			Operacao op = sistemaBancario.depositar(ccMaria, _10reais);
			assertEquals(EstadosDeOperacao.SUCESSO,op.obterEstado());
			assertEquals(ccMaria.calcularSaldo(), new ValorMonetario(Moeda.BRL).somar(_10reais));
		}
		//5
		@Test
		public void saqueEmContaComSaldoSuficiente() throws Exception{
			
			Dinheiro _10reais = new Dinheiro(Moeda.BRL, 10, 0);	
			Operacao op = sistemaBancario.depositar(ccMaria, _10reais);
			
			Dinheiro _6reais = new Dinheiro(Moeda.BRL, 6, 0);
			op = sistemaBancario.sacar(ccMaria, _6reais);
			assertEquals(EstadosDeOperacao.SUCESSO,op.obterEstado());
			Dinheiro _4reais = new Dinheiro(Moeda.BRL, 4, 0);
			assertEquals(ccMaria.calcularSaldo(), new ValorMonetario(Moeda.BRL).somar(_4reais));
		}
		//6
		@Test
		public void saqueComSaldoInsuficiente() throws Exception{
			Dinheiro _4reais = new Dinheiro(Moeda.BRL, 4, 0);
			Operacao op = sistemaBancario.depositar(ccMaria, _4reais);
			
			Dinheiro _6reais = new Dinheiro(Moeda.BRL, 6, 0);
			op = sistemaBancario.sacar(ccMaria, _6reais);
			assertEquals(op.obterEstado(), EstadosDeOperacao.SALDO_INSUFICIENTE);
			assertEquals(ccMaria.calcularSaldo(), new ValorMonetario(Moeda.BRL).somar(_4reais));
			
		}
}

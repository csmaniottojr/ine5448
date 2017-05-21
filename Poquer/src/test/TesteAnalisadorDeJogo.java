package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.ufsc.es.projetoPoquer.modelo.torneio.torneioDeUmaMesa.rodada.jogo.AnalisadorDeJogos;
import br.ufsc.es.projetoPoquer.modelo.torneio.torneioDeUmaMesa.rodada.jogo.Carta;
import br.ufsc.es.projetoPoquer.modelo.torneio.torneioDeUmaMesa.rodada.jogo.Naipe;
import br.ufsc.es.projetoPoquer.modelo.torneio.torneioDeUmaMesa.rodada.jogo.RankingDeMao;
import br.ufsc.es.projetoPoquer.modelo.torneio.torneioDeUmaMesa.rodada.jogo.Valor;

public class TesteAnalisadorDeJogo {

	@Test
	public void parDeAs() throws Exception {
		List<Carta> parDeAs = new ArrayList<>();
		parDeAs.add(new Carta(Valor.ÁS, Naipe.ESPADAS));
		parDeAs.add(new Carta(Valor.ÁS, Naipe.COPAS));
		parDeAs.add(new Carta(Valor.CINCO, Naipe.PAUS));
		parDeAs.add(new Carta(Valor.SETE, Naipe.OURO));
		parDeAs.add(new Carta(Valor.NOVE, Naipe.ESPADAS));
		parDeAs.add(new Carta(Valor.VALETE, Naipe.COPAS));
		parDeAs.add(new Carta(Valor.REI, Naipe.PAUS));
		assertEquals(RankingDeMao.PAR, AnalisadorDeJogos.fornecerInstância().fornecerJogo(parDeAs));
	}
	
	@Test
	public void royalFlush() throws Exception{
		List<Carta> royalFlush = new ArrayList<>();
		royalFlush.add(new Carta(Valor.ÁS, Naipe.PAUS));
		royalFlush.add(new Carta(Valor.DEZ, Naipe.PAUS));
		royalFlush.add(new Carta(Valor.VALETE, Naipe.PAUS));
		royalFlush.add(new Carta(Valor.DAMA, Naipe.PAUS));
		royalFlush.add(new Carta(Valor.REI, Naipe.PAUS));
		royalFlush.add(new Carta(Valor.CINCO, Naipe.PAUS));
		royalFlush.add(new Carta(Valor.SETE, Naipe.OURO));
		assertEquals(RankingDeMao.ROYAL_FLUSH, AnalisadorDeJogos.fornecerInstância().fornecerJogo(royalFlush));
	}
	
	@Test
	public void straightFlush() throws Exception{
		List<Carta> straightFlush = new ArrayList<>();
		straightFlush.add(new Carta(Valor.NOVE, Naipe.PAUS));
		straightFlush.add(new Carta(Valor.DEZ, Naipe.PAUS));
		straightFlush.add(new Carta(Valor.VALETE, Naipe.PAUS));
		straightFlush.add(new Carta(Valor.DAMA, Naipe.PAUS));
		straightFlush.add(new Carta(Valor.REI, Naipe.PAUS));
		assertEquals(RankingDeMao.STRAIGHT_FLUSH, AnalisadorDeJogos.fornecerInstância().fornecerJogo(straightFlush));
	}
	
	@Test
	public void quadra() throws Exception{
		List<Carta> quadra = new ArrayList<>();
		quadra.add(new Carta(Valor.NOVE, Naipe.PAUS));
		quadra.add(new Carta(Valor.NOVE, Naipe.COPAS));
		quadra.add(new Carta(Valor.NOVE, Naipe.OURO));
		quadra.add(new Carta(Valor.NOVE, Naipe.ESPADAS));
		quadra.add(new Carta(Valor.REI, Naipe.PAUS));
		assertEquals(RankingDeMao.QUADRA, AnalisadorDeJogos.fornecerInstância().fornecerJogo(quadra));
	}
	
	@Test
	public void fullHouse() throws Exception{
		List<Carta> fullHouse = new ArrayList<>();
		fullHouse.add(new Carta(Valor.NOVE, Naipe.PAUS));
		fullHouse.add(new Carta(Valor.NOVE, Naipe.COPAS));
		fullHouse.add(new Carta(Valor.NOVE, Naipe.OURO));
		fullHouse.add(new Carta(Valor.REI, Naipe.ESPADAS));
		fullHouse.add(new Carta(Valor.REI, Naipe.PAUS));
		assertEquals(RankingDeMao.FULL_HOUSE, AnalisadorDeJogos.fornecerInstância().fornecerJogo(fullHouse));
	}
	
	@Test
	public void flush() throws Exception{
		List<Carta> flush = new ArrayList<>();
		flush.add(new Carta(Valor.NOVE, Naipe.PAUS));
		flush.add(new Carta(Valor.OITO, Naipe.PAUS));
		flush.add(new Carta(Valor.SETE, Naipe.PAUS));
		flush.add(new Carta(Valor.SEIS, Naipe.PAUS));
		flush.add(new Carta(Valor.QUATRO, Naipe.PAUS));
		flush.add(new Carta(Valor.TRÊS, Naipe.ESPADAS));
		flush.add(new Carta(Valor.DOIS, Naipe.OURO));
		assertEquals(RankingDeMao.FLUSH, AnalisadorDeJogos.fornecerInstância().fornecerJogo(flush));
	}
	
	@Test
	public void straight() throws Exception{
		List<Carta> straight = new ArrayList<>();
		straight.add(new Carta(Valor.NOVE, Naipe.PAUS));
		straight.add(new Carta(Valor.OITO, Naipe.OURO));
		straight.add(new Carta(Valor.SETE, Naipe.ESPADAS));
		straight.add(new Carta(Valor.SEIS, Naipe.PAUS));
		straight.add(new Carta(Valor.CINCO, Naipe.PAUS));
		straight.add(new Carta(Valor.REI, Naipe.ESPADAS));
		straight.add(new Carta(Valor.DOIS, Naipe.OURO));
		assertEquals(RankingDeMao.STRAIGHT, AnalisadorDeJogos.fornecerInstância().fornecerJogo(straight));
	}
	
	@Test
	public void trinca() throws Exception{
		List<Carta> trinca = new ArrayList<>();
		trinca.add(new Carta(Valor.NOVE, Naipe.PAUS));
		trinca.add(new Carta(Valor.NOVE, Naipe.COPAS));
		trinca.add(new Carta(Valor.NOVE, Naipe.OURO));
		trinca.add(new Carta(Valor.DOIS, Naipe.ESPADAS));
		trinca.add(new Carta(Valor.REI, Naipe.PAUS));
		assertEquals(RankingDeMao.TRINCA, AnalisadorDeJogos.fornecerInstância().fornecerJogo(trinca));
	}
	
	@Test
	public void doisPares() throws Exception{
		List<Carta> trinca = new ArrayList<>();
		trinca.add(new Carta(Valor.NOVE, Naipe.PAUS));
		trinca.add(new Carta(Valor.NOVE, Naipe.COPAS));
		trinca.add(new Carta(Valor.DEZ, Naipe.OURO));
		trinca.add(new Carta(Valor.REI, Naipe.ESPADAS));
		trinca.add(new Carta(Valor.REI, Naipe.PAUS));
		assertEquals(RankingDeMao.DOIS_PARES, AnalisadorDeJogos.fornecerInstância().fornecerJogo(trinca));
	}
	
	@Test
	public void umPar() throws Exception{
		List<Carta> trinca = new ArrayList<>();
		trinca.add(new Carta(Valor.NOVE, Naipe.PAUS));
		trinca.add(new Carta(Valor.NOVE, Naipe.COPAS));
		trinca.add(new Carta(Valor.CINCO, Naipe.OURO));
		trinca.add(new Carta(Valor.DOIS, Naipe.ESPADAS));
		trinca.add(new Carta(Valor.REI, Naipe.PAUS));
		assertEquals(RankingDeMao.PAR, AnalisadorDeJogos.fornecerInstância().fornecerJogo(trinca));
	}
	
	@Test
	public void cartaMaisAlta() throws Exception{
		List<Carta> trinca = new ArrayList<>();
		trinca.add(new Carta(Valor.NOVE, Naipe.PAUS));
		trinca.add(new Carta(Valor.ÁS, Naipe.COPAS));
		trinca.add(new Carta(Valor.CINCO, Naipe.OURO));
		trinca.add(new Carta(Valor.DOIS, Naipe.ESPADAS));
		trinca.add(new Carta(Valor.REI, Naipe.PAUS));
		assertEquals(RankingDeMao.CARTA_ALTA, AnalisadorDeJogos.fornecerInstância().fornecerJogo(trinca));
	}

}

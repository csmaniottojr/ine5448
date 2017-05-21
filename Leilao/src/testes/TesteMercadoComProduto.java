package testes;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import interfaces.ILeiloavel;
import interfaces.IMercadoLeilao;
import modelo.Lance;
import modelo.MercadoLeilao;

public class TesteMercadoComProduto {
	
	private IMercadoLeilao mercado;
	private Date dataLimiteProduto;
	private String cpfLeiloadorProduto;
	private String nomeProduto;
	private String descricaoProduto;
	private Double valorMinimoProduto;
	private String nomeUsuario;
	private String enderecoUsuario;
	private String emailUsuario;
	
	@Before
	public void setup(){
		mercado = new MercadoLeilao();
	}
	
	
	
	@Test(expected=Exception.class)
	public void testeDaLanceValorAbaixoMinimo() throws Exception{
		mercado.cadastrarUsuario("CesarComprador", "Rua tal", "cc@gmail.com", "999.999.999");
		mercado.cadastrarUsuario("CesarVendedor", "Rua tal tal", "cv@gmail.com", "999.999.998");
		mercado.cadastrarProduto("casa", "3 quartos", 20000.0, "999.999.998", new Date(new Date().getTime() + 3000));
		mercado.daLance("casa", "999.999.999", 19000.0);
	}
	
	@Test(expected=Exception.class)
	public void testeDaLanceValorAbaixoMaior() throws Exception{
		mercado.cadastrarUsuario("CesarComprador", "Rua tal", "cc@gmail.com", "999.999.999");
		mercado.cadastrarUsuario("CesarVendedor", "Rua tal tal", "cv@gmail.com", "999.999.998");
		mercado.cadastrarProduto("casa", "3 quartos", 20000.0, "999.999.998", new Date(new Date().getTime() + 3000));
		mercado.daLance("casa", "999.999.999", 20100.0);
		mercado.daLance("casa", "999.999.999", 20050.0);
		
	}
	
	@Test(expected=Exception.class)
	public void testeDaLanceCompradorInexistente() throws Exception{
		mercado.cadastrarUsuario("CesarVendedor", "Rua tal tal", "cv@gmail.com", "999.999.998");
		mercado.cadastrarProduto("casa", "3 quartos", 20000.0, "999.999.998", new Date(new Date().getTime() + 3000));
		mercado.daLance("casa", "999.999.999", 20100.0);
		
	}
	
	@Test(expected=Exception.class)
	public void testeDaLanceProdutoInexistente() throws Exception{
		mercado.daLance("casa", "999.999.999", 20100.0);
		
	}
	
	@Test(expected=Exception.class)
	public void testeDaLanceProdutoExpirado() throws Exception{
		mercado.cadastrarUsuario("CesarComprador", "Rua tal", "cc@gmail.com", "999.999.999");
		mercado.cadastrarUsuario("CesarVendedor", "Rua tal tal", "cv@gmail.com", "999.999.998");
		mercado.cadastrarProduto("casa", "3 quartos", 20000.0, "999.999.998", new Date(new Date().getTime() - 3000));
		mercado.daLance("casa", "999.999.999", 21000.0);
	}
	
	@Test(expected=Exception.class)
	public void testeDaLanceProdutoJaVendido() throws Exception{
		mercado.cadastrarUsuario("CesarComprador1", "Rua tal", "cc1@gmail.com", "999.999.999");
		mercado.cadastrarUsuario("CesarComprador2", "Rua tal", "cc1@gmail.com", "999.999.997");
		mercado.cadastrarUsuario("CesarVendedor", "Rua tal tal", "cv@gmail.com", "999.999.998");
		mercado.cadastrarProduto("casa", "3 quartos", 20000.0, "999.999.998", new Date(new Date().getTime() + 1000));
		mercado.daLance("casa", "999.999.999", 21000.0);
		Thread.sleep(2000);
		mercado.daLance("casa", "999.999.997", 22000.0);
	}
	
	@Test
	public void testeDaLance() throws Exception{
		
		mercado.cadastrarUsuario("CesarComprador", "Rua tal", "cc@gmail.com", "999.999.999");
		mercado.cadastrarUsuario("CesarVendedor", "Rua tal tal", "cv@gmail.com", "999.999.998");
		mercado.cadastrarProduto("casa", "3 quartos", 20000.0, "999.999.998", new Date(new Date().getTime() + 3000));
		mercado.daLance("casa", "999.999.999", 21000.0);
		
		List<? extends ILeiloavel> produtosLeilao = mercado.getProdutosQueDeuLance("999.999.999");
		assertTrue(produtosLeilao.size() == 1);
		
		ILeiloavel casaLeilao = produtosLeilao.get(0);
		
		assertEquals("casa", casaLeilao.getNome());
		assertEquals("999.999.998", casaLeilao.getCpfLeiloador());
		assertEquals(new Double(21000.0), casaLeilao.getValorUltimoLance());
		assertEquals("3 quartos", casaLeilao.getDescricao());
		
		List<Lance> lancesUsuario = ((MercadoLeilao) mercado).retornaLancesDeUmUsuario("999.999.999");
		assertTrue(lancesUsuario.size() == 1);
		
		Lance lanceCasa = lancesUsuario.get(0);
		
		assertEquals("casa", lanceCasa.getNomeProdutoQueRecebeuOLance());
		assertEquals("999.999.999", lanceCasa.getCpfDonoDoLance());
		assertEquals(new Double(21000.0), lanceCasa.getValorDoLance());
		assertEquals(casaLeilao, lanceCasa.getProdutoQueRecebeuOLance());
		assertEquals("CesarComprador", lanceCasa.getNomeDonoDoLance());

	}

}

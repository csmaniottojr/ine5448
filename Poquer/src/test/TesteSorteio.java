package test;
import static org.junit.Assert.*;

import org.junit.Test;

import br.ufsc.es.projetoPoquer.modelo.utilidades.Sorteio;

public class TesteSorteio {
	
	@Test
	public void sorteioDoisInteirosPositivosDiferentes() throws Exception{
		int num1 = 2;
		int num2 = 5;
		
		int sorteado = Sorteio.sortear(num1, num2);
		
		assertTrue(sorteado >= num1 && sorteado <= num2);
	}
	
	@Test
	public void sorteioDoisInteirosPositivosIguais() throws Exception{
		int num1 = 2;
		int num2 = 2;
		
		int sorteado = Sorteio.sortear(num1, num2);
		
		assertTrue(sorteado >= num1 && sorteado <= num2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void sorteioNegativoComoMenorPositivoComoMaior() throws Exception{
		
		int num1 = -5;
		int num2 = 2;
		
		int sorteado = Sorteio.sortear(num1, num2);
		
		assertTrue(num1 >= sorteado && sorteado <= num2);
		
	}
	
	@Test
	public void sorteioPositivoComoMenorNegativoComoMaior() throws Exception{
		
		int num1 = 2;
		int num2 = -5;
		
		int sorteado = Sorteio.sortear(num1, num2);

		assertTrue(Math.abs(sorteado) >= num1 && sorteado <= Math.abs(num2));
		
	}
	
	@Test
	public void sorteioMenorPositivoRepresentavel() throws Exception{
		
		int num1 = Integer.MIN_VALUE;
		int num2 = 2;
		
		int sorteado = Sorteio.sortear(num1, num2);
		System.out.println(sorteado);
		assertTrue(sorteado >= num1 && sorteado <= num2);
		
	}
	
	@Test
	public void sorteioMaiorPositivoRepresentavel() throws Exception{
		//falha: soma que ultrapasse maior valor inteiro representável, é transformada no menor valor representável.
		
		int num1 = 0;
		int num2 = Integer.MAX_VALUE;
		
		int sorteado = Sorteio.sortear(num1, num2);
		System.out.println(sorteado);
		assertTrue(sorteado >= num1 && sorteado <= num2);
		
	}

}

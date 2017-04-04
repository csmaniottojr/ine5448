import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.number.OrderingComparison.*;
import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;
public class TesteComHamcrest {

	@Test
	public void testObject() throws Exception{
		assertThat(new Integer(20), instanceOf(Integer.class));
	}
	
	@Test
	public void testNumber() throws Exception{
		assertThat(3, greaterThan(2));
	}
	
	@Test
	public void testText() throws Exception{
		assertThat("AAA", endsWith("A"));
	}
	
	@Test
	public void testArray() throws Exception{
		List<String> list = Arrays.asList("A","B","C");
		assertThat(list, not(hasItems("D","A")));
	}
	
	@Test
	public void testAnyOf() throws Exception{
		List<String> list = Arrays.asList("A","B","C");
		assertThat(list, anyOf(not(hasItems("D","A")), hasItems("X","Z")));
	}
	
	@Test
	public void testAllOf() throws Exception{
		List<String> list = Arrays.asList("A","B","C");
		assertThat(list, allOf(not(hasItems("D","A")), hasItems("A","B")));
	
	}
	
	@Test
	public void testAllString() throws Exception{
		
		assertThat("AbC", allOf(startsWith("Ab"), endsWith("bC"), not(containsString("Abc"))));
	
	}
}

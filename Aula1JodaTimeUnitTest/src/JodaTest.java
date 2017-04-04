import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.junit.Test;

/**
 * 
 */

/**
 * @author cesar
 *
 */
public class JodaTest {
	
	@Test
	public void criarData() throws Exception {
		LocalDate catorzeMarco2017 = new LocalDate(2017,3,14);
		assertEquals(14, catorzeMarco2017.getDayOfMonth());
		assertEquals(DateTimeConstants.MARCH, catorzeMarco2017.getMonthOfYear());
		assertEquals(2017, catorzeMarco2017.getYear());
	}
	
	@Test(expected = IllegalFieldValueException.class)
	public void criarDataInvalida() throws Exception {
		new LocalDate(2017,3,-5);
	}
	
	@Test(expected = IllegalFieldValueException.class)
	public void dataAnoBissextoEmAnoNaoBissexto() throws Exception{
		new LocalDate(2017, 2, 29);
		
	}
	
	@Test
	public void meioDia() throws Exception{
		
		LocalTime meioDia = new LocalTime(12, 0, 0);
		assertEquals(12, meioDia.getHourOfDay());
		assertEquals(0, meioDia.getMinuteOfHour());
		assertEquals(0, meioDia.getSecondOfMinute());
	}
	
	@Test
	public void quaseMeiaNoite() throws Exception{
		
		LocalTime quaseMeiaNoite = new LocalTime(23,59,59, 999);
		assertEquals(23, quaseMeiaNoite.getHourOfDay());
		assertEquals(59, quaseMeiaNoite.getMinuteOfHour());
		assertEquals(59, quaseMeiaNoite.getSecondOfMinute());
		assertEquals(999, quaseMeiaNoite.getMillisOfSecond());
	}
	
	@Test
	public void add1MsMeiaNoite() throws Exception{
		assertEquals(new LocalTime(23,59,59, 999).plusMillis(1),new LocalTime(0,0));
		
	}
	@Test
	public void add1MinMeioDia() throws Exception {
		
		assertEquals(new LocalTime(12, 0).plusMinutes(1), new LocalTime(12, 1));
	}
	@Test
	public void meioDiaAntesMeioDiaUm() throws Exception{
		assertFalse(new LocalTime(12, 0).isAfter(new LocalTime(12, 1) ));
		assertTrue(new LocalTime(12, 0).isBefore(new LocalTime(12, 1) ));
	}
	@Test
	public void meioDiaEUmDepoisMeioDia() throws Exception{
		assertTrue(new LocalTime(12, 1).isAfter(new LocalTime(12, 0) ));
		assertFalse(new LocalTime(12, 1).isBefore(new LocalTime(12, 0) ));
		
	}
	
	@Test
	public void noveAoMeioDia() throws Exception{
		DateTime _9Horas = new DateTime(2017,3,2,9,0);
		DateTime _12Horas = new DateTime(2017,3,2,12,0);
		
		Interval _9As12Horas = new Interval(_9Horas, _12Horas);
		assertTrue(_9As12Horas.contains(_9Horas));
		assertFalse(_9As12Horas.contains(_12Horas));
		
	}
	
	
	
	
	


}

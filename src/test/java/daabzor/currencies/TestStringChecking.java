package daabzor.currencies;
import static org.junit.Assert.*;
import org.junit.Test;



public class TestStringChecking {

	@Test
	public void testIsValidCurrency1() {
		 
		assertEquals(true, StringChecking.isValidStringCurrency("100 usd"));	
		assertEquals(true, StringChecking.isValidStringCurrency("1000000 usd"));
		assertEquals(true, StringChecking.isValidStringCurrency("1 usd"));
		assertEquals(true, StringChecking.isValidStringCurrency("0000001 usd"));
		assertEquals(false, StringChecking.isValidStringCurrency("0 usd"));
		assertEquals(false, StringChecking.isValidStringCurrency("100usd"));	
		assertEquals(false, StringChecking.isValidStringCurrency("10 0 usd"));
		assertEquals(false, StringChecking.isValidStringCurrency("100 usda"));
		assertEquals(false, StringChecking.isValidStringCurrency("100 us"));
		assertEquals(false, StringChecking.isValidStringCurrency("100 u"));
		assertEquals(false, StringChecking.isValidStringCurrency("100"));
		assertEquals(false, StringChecking.isValidStringCurrency("10 0"));
		assertEquals(false, StringChecking.isValidStringCurrency("10 000"));
		assertEquals(false, StringChecking.isValidStringCurrency("100 sd9"));
		assertEquals(false, StringChecking.isValidStringCurrency("100 u8d"));
		assertEquals(false, StringChecking.isValidStringCurrency("100 0ss"));
		assertEquals(false, StringChecking.isValidStringCurrency("usd 100"));
		assertEquals(false, StringChecking.isValidStringCurrency("usd usd"));
		assertEquals(false, StringChecking.isValidStringCurrency("usd"));
		assertEquals(false, StringChecking.isValidStringCurrency("1 1us"));
		assertEquals(false, StringChecking.isValidStringCurrency("100u usd"));
		assertEquals(false, StringChecking.isValidStringCurrency("1 00usd"));
		assertEquals(false, StringChecking.isValidStringCurrency("1a1111 usd"));
		assertEquals(false, StringChecking.isValidStringCurrency("1 00usd"));
		assertEquals(false, StringChecking.isValidStringCurrency("1 00 usd"));
		assertEquals(false, StringChecking.isValidStringCurrency("100 usd usd"));
	}
}

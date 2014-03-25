package net.lioneldev.mathables;

import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/** General test cases on Numbers class
 * @author lionel ngounou
 */
public class GeneralNumbersTest {
	
	public GeneralNumbersTest() {
	}
	
	protected static void clearAndPopulateSet(Set<? super Long> set, long... values){
		set.clear();
		for(int x=0; x<values.length; x++)
			set.add(values[x]);
	}

	/**
	 * Test of isEven method, of class Numbers.
	 */
	@Test
	public void testIsEven() {
		System.out.println("isEven");
		assertTrue(Numbers.isEven(0));
		assertTrue(Numbers.isEven(-0));
		assertTrue(Numbers.isEven(2));
		assertTrue(Numbers.isEven(20)); 
		
		assertFalse(Numbers.isEven(-1));
		assertFalse(Numbers.isEven(1));
		assertFalse(Numbers.isEven(9));
		assertFalse(Numbers.isEven(-9));
		assertFalse(Numbers.isEven(3));
	}

	/**
	 * Test of isRational method, of class Numbers.
	 */
	@Test
	public void testIsNonPrimeRational() {
		System.out.println("isNonPrimeRational");
		assertTrue(Numbers.isNonPrimeRational(6));
		assertTrue(Numbers.isNonPrimeRational(9));
		assertTrue(Numbers.isNonPrimeRational(15));
		
		assertFalse(Numbers.isNonPrimeRational(0));
		assertFalse(Numbers.isNonPrimeRational(1));
		assertFalse(Numbers.isNonPrimeRational(2));
		assertFalse(Numbers.isNonPrimeRational(7));
	}

	/**
	 * Test of hasDecimal method, of class Numbers.
	 */
	@Test
	public void testHasDecimal() {
		System.out.println("hasDecimal");
		assertTrue(Numbers.hasDecimal(4.1));
		assertTrue(Numbers.hasDecimal(4.0001));
		
		assertFalse(Numbers.hasDecimal(4.000));
		assertFalse(Numbers.hasDecimal(-4.000));
		assertFalse(Numbers.hasDecimal(-0.000));
		assertFalse(Numbers.hasDecimal(6));
	}

	/**
	 * Test of isWhole method, of class Numbers.
	 */
	@Test
	public void testIsWhole() {
		System.out.println("isWhole");
		assertTrue(Numbers.isWhole(4.000));
		assertTrue(Numbers.isWhole(-4.000));
		assertTrue(Numbers.isWhole(-0.000));
		assertTrue(Numbers.isWhole(6));
		
		assertFalse(Numbers.isWhole(4.1));
		assertFalse(Numbers.isWhole(4.0001));
	}
	
}

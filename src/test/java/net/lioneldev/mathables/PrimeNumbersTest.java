
package net.lioneldev.mathables;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *Test cases on prime number methods in Numbers class
 * @author lionel.ngounou
 */
public class PrimeNumbersTest {

	public PrimeNumbersTest() {
	}
	
	/**
	 * Test of primeNumbersInRange method, of class Numbers.
	 */
	@Test
	public void testPrimeNumbersInRange() {
		System.out.println("primeNumbersInRange");
		Set<Long> expectedPrimes = new HashSet<Long>();
		
		// test primes between 0 and 10 
		GeneralNumbersTest.clearAndPopulateSet(expectedPrimes, 0,1,2,3,5,7);
		assertTrue(expectedPrimes.equals(Numbers.primeNumbersInRange(0,10)));
		
		// test primes between 10 and 30 
		GeneralNumbersTest.clearAndPopulateSet(expectedPrimes, 11,13,17,19,23,29);
		assertTrue(expectedPrimes.equals(Numbers.primeNumbersInRange(10,30)));
	}
	
	
	/**
	 * Test of isPrime method, of class Numbers.
	 */
	@Test
	public void testIsPrime() {
		System.out.println("isPrime");
		assertTrue(Numbers.isPrime(0));
		assertTrue(Numbers.isPrime(1));
		assertTrue(Numbers.isPrime(2));
		assertTrue(Numbers.isPrime(3));
		assertTrue(Numbers.isPrime(5));
		assertTrue(Numbers.isPrime(7));
		assertTrue(Numbers.isPrime(11));
		assertTrue(Numbers.isPrime(13));
		assertTrue(Numbers.isPrime(17));
		assertTrue(Numbers.isPrime(19));
		assertTrue(Numbers.isPrime(23));
		assertTrue(Numbers.isPrime(-29));
		assertTrue(Numbers.isPrime(29));
		
		assertFalse(Numbers.isPrime(9));
		assertFalse(Numbers.isPrime(-9));
		assertFalse(Numbers.isPrime(12));
		assertFalse(Numbers.isPrime(21));
		assertFalse(Numbers.isPrime(121));
	}
}

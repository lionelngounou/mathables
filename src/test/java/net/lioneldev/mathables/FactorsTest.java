package net.lioneldev.mathables;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 * Test cases for methods on factors in Numbers class
 * @author lionel.ngounou
 */
public class FactorsTest {

	public FactorsTest() {
	}
	
	@Test
	public void isFactorTest() {
		System.out.println("isFactorTest");
		assertTrue(Numbers.isFactor(12, 1));
		assertTrue(Numbers.isFactor(12, 2));
		assertTrue(Numbers.isFactor(12, 3));
		assertTrue(Numbers.isFactor(12, 4));
		
		assertFalse(Numbers.isFactor(12, 0));
		assertFalse(Numbers.isFactor(12, 5));
		assertFalse(Numbers.isFactor(12, 7));
	}
	
	@Test
	public void isMultipleTest() {
		System.out.println("isMultipleTest");
		assertTrue(Numbers.isMultiple(1, 12));
		assertTrue(Numbers.isMultiple(2, 12));
		assertTrue(Numbers.isMultiple(3, 12));
		assertTrue(Numbers.isMultiple(4, 12));
		
		assertTrue(Numbers.isMultipleOf3(6));
		assertTrue(Numbers.isMultipleOf3(9));
		assertTrue(Numbers.isMultipleOf3(12));
		
		assertFalse(Numbers.isMultiple(0, 12));
		assertFalse(Numbers.isMultiple(5, 12));
		assertFalse(Numbers.isMultiple(7, 12));
	}

	
	/**
	 * Test of positiveFactors method, of class Numbers.
	 */
	@Test
	public void testPositiveFactors() {
		System.out.println("positiveFactors");
		Set<Long> expectedFactors = new HashSet<Long>();
		long number = 0;
		GeneralNumbersTest.clearAndPopulateSet(expectedFactors, 0);
		assertTrue(expectedFactors.equals(Numbers.positiveFactors(number)));
		assertTrue(expectedFactors.equals(Numbers.positiveFactors(number*-1)));
		
		number = 1;
		GeneralNumbersTest.clearAndPopulateSet(expectedFactors, 1);
		assertTrue(expectedFactors.equals(Numbers.positiveFactors(number)));
		assertTrue(expectedFactors.equals(Numbers.positiveFactors(number*-1)));
		
		number = 30;
		GeneralNumbersTest.clearAndPopulateSet(expectedFactors, 1,2,3,5,6,10,15,30);
		assertTrue(expectedFactors.equals(Numbers.positiveFactors(number)));
		assertTrue(expectedFactors.equals(Numbers.positiveFactors(number*-1)));
		
		number = 47;
		GeneralNumbersTest.clearAndPopulateSet(expectedFactors, 1, 47);
		assertTrue(expectedFactors.equals(Numbers.positiveFactors(number)));
		assertTrue(expectedFactors.equals(Numbers.positiveFactors(number*-1)));
	}

	/**
	 * Test of negativeFactors method, of class Numbers.
	 */
	@Test
	public void testNegativeFactors() {
		System.out.println("negativeFactors");
		Set<Long> expectedFactors = new HashSet<Long>();
		long number = 0;
		GeneralNumbersTest.clearAndPopulateSet(expectedFactors, 0);
		assertTrue(expectedFactors.equals(Numbers.negativeFactors(number)));
		assertTrue(expectedFactors.equals(Numbers.negativeFactors(number*-1)));
		
		number = 1;
		GeneralNumbersTest.clearAndPopulateSet(expectedFactors, -1);
		assertTrue(expectedFactors.equals(Numbers.negativeFactors(number)));
		assertTrue(expectedFactors.equals(Numbers.negativeFactors(number*-1)));
		
		number = 30;
		GeneralNumbersTest.clearAndPopulateSet(expectedFactors, -1,-2,-3,-5,-6,-10,-15,-30);
		assertTrue(expectedFactors.equals(Numbers.negativeFactors(number)));
		assertTrue(expectedFactors.equals(Numbers.negativeFactors(number*-1)));
		
		number = 47;
		GeneralNumbersTest.clearAndPopulateSet(expectedFactors, -1, -47);
		assertTrue(expectedFactors.equals(Numbers.negativeFactors(number)));
		assertTrue(expectedFactors.equals(Numbers.negativeFactors(number*-1)));
	}

	/**
	 * Test of allFactors method, of class Numbers.
	 */
	@Test
	public void testAllFactors() {
		System.out.println("allFactors");
		Set<Long> expectedFactors = new HashSet<Long>();
		long number = 0;
		GeneralNumbersTest.clearAndPopulateSet(expectedFactors, 0);
		assertTrue(expectedFactors.equals(Numbers.allFactors(number)));
		assertTrue(expectedFactors.equals(Numbers.allFactors(number*-1)));
		
		number = 1;
		GeneralNumbersTest.clearAndPopulateSet(expectedFactors, -1, 1);
		assertTrue(expectedFactors.equals(Numbers.allFactors(number)));
		assertTrue(expectedFactors.equals(Numbers.allFactors(number*-1)));
		
		number = 30;
		GeneralNumbersTest.clearAndPopulateSet(expectedFactors, -1,-2,-3,-5,-6,-10,-15,-30,1,2,3,5,6,10,15,30);
		assertTrue(expectedFactors.equals(Numbers.allFactors(number)));
		assertTrue(expectedFactors.equals(Numbers.allFactors(number*-1)));
		
		number = 47;
		GeneralNumbersTest.clearAndPopulateSet(expectedFactors, -1, -47, 1, 47);
		assertTrue(expectedFactors.equals(Numbers.allFactors(number)));
		assertTrue(expectedFactors.equals(Numbers.allFactors(number*-1)));
	}

	/**
	 * Test of factors method, of class Numbers.
	 */
	@Test
	public void testFactors() {
		System.out.println("factors");
		Set<Long> expectedFactors = new HashSet<Long>();
		long number = 16;
		GeneralNumbersTest.clearAndPopulateSet(expectedFactors, 1,2,4,8,16);
		assertTrue(expectedFactors.equals(Numbers.factors(number, Numbers.FactorType.POSIIVE)));
		GeneralNumbersTest.clearAndPopulateSet(expectedFactors, -1,-2,-4,-8,-16);
		assertTrue(expectedFactors.equals(Numbers.factors(number, Numbers.FactorType.NEGATIVE)));
		GeneralNumbersTest.clearAndPopulateSet(expectedFactors, -1,-2,-4,-8,-16,1,2,4,8,16);
		assertTrue(expectedFactors.equals(Numbers.factors(number, Numbers.FactorType.ALL)));
	}
}

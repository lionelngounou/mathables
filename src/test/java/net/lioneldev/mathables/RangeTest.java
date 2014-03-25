package net.lioneldev.mathables;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *Test cases for Range class
 * @author lionel.ngounou
 */
public class RangeTest {
	
	public RangeTest() {
	}

	/**
	 * Test of create Range.
	 */
	@Test
	public void testRangeCreation() {
		System.out.println("range creation");
		int min = 4, max = 4;
		Range<Integer> r1 = new Range<Integer>(min, max);
		assertTrue(r1.getMax()==min);
		assertTrue(r1.getMin()==max);
	}

	/**
	 * Test of illegal Range creation.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalRangeValues() {
		System.out.println("illegal range creation");
		new Range<Integer>(4, -6);
	}
	
	/**
	 * Test of hashCode method, of class Range.
	 */
	@Test
	public void testHashCode() {
		System.out.println("hashCode");
		Range<Integer> r1 = new Range<Integer>(3,7), r2 = new Range<Integer>(3,7);
		assertTrue(r1.hashCode() == r2.hashCode());
	}

	/**
	 * Test of equals method, of class Range.
	 */
	@Test
	public void testEquals() {
		System.out.println("equals");
		Range<Integer> r1 = new Range<Integer>(3,7), r2 = new Range<Integer>(3,7);
		assertTrue(r1.equals(r2));
		assertTrue(r1.hashCode() == r2.hashCode());
		r2 = new Range<Integer>(0,7);
		assertFalse(r1.equals(r2));
	}
	
}

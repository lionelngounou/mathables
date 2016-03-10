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
	
	@Test
	public void testContains() {
		System.out.println("testContains");
		Range<Integer> r1 = Range.valueOf(3, 7);
		assertTrue(r1.contains(3));
		assertTrue(r1.contains(4));
		assertTrue(r1.contains(5));
		assertTrue(r1.contains(7));
		assertFalse(r1.contains(2));
		assertFalse(r1.contains(8));
	}
	
	@Test
	public void testSplitWithOneValue() {
		System.out.println("testSplitWithOneValue");
		testSplitRangeWithValue(3,7,5);
		testSplitRangeWithValue(3,7,7);
		testSplitRangeWithValue(3,7,3);
		testSplitRangeWithOutsideValue(3,7,2);
		testSplitRangeWithOutsideValue(3,7,8);
	}
	
	private <T extends Comparable<T>> void testSplitRangeWithValue(T min, T max, T value){
		Range<T> range = Range.valueOf(min, max);
		Range[] splitRange = range.split(value);
		assertTrue(splitRange.length==2);
		assertTrue(splitRange[0].equals(Range.valueOf(min, value)));
		assertTrue(splitRange[1].equals(Range.valueOf(value, max)));
	}
	
	private <T extends Comparable<T>> void testSplitRangeWithOutsideValue(T min, T max, T value){
		Range<T> range = Range.valueOf(min, max);
		Range[] splitRange = range.split(value);
		assertTrue(splitRange.length==1);
		assertTrue(splitRange[0].equals(Range.valueOf(min, max)));
	}
	
	@Test
	public void testSplitWithMultipleValues() {
		System.out.println("testSplitWithMultipleValues");
	}
	
	private <V extends Comparable<V>> void testOverlaps(Range<V> r1, Range<V> r2, boolean yesNo){
		assertTrue(r1.overlaps(r2)==yesNo);
		assertTrue(r2.overlaps(r1)==yesNo);//test symetry
	}
	
	@Test
	public void testOverlaps() {
		System.out.println("testIntersects");
		Range<Integer> r1 = Range.valueOf(3, 9), r2, r3;
		testOverlaps(r1, r1, true); //test reflection
		
		r2 = Range.valueOf(4, 12);
		testOverlaps(r1, r2, true);
		
		r2 = Range.valueOf(6, 8);
		testOverlaps(r1,r2,true);
		
		r2 = Range.valueOf(2, 10);
		testOverlaps(r1,r2,true);
		
		/*test: It is transitive*/
		r3 = Range.valueOf(5, 7);
		testOverlaps(r1,r2,true);
		testOverlaps(r2,r3,true);
		testOverlaps(r1,r3,true);
		
		r2 = Range.valueOf(10, 20);
		testOverlaps(r1,r2,false);
		
	}
	
}

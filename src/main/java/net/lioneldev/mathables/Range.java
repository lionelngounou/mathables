package net.lioneldev.mathables;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that represents a range between two <code>Comparables</code>, where the lowest value is the minimum (<code>min</code>), 
 * and the highest is the maximum (<code>max</code>)
 * @author lionel.ngounou
 * @param <T>
 * 
 */
public class Range<T extends Comparable<T>> implements Serializable {
	private static final long serialVersionUID = 88428439312211L;
	
	private T min , max; 
	public Range(T min, T max) {
		set(min, max);
	}
	
	public final void set(T min, T max){
		if(min.compareTo(max)>0)
			throw new IllegalArgumentException("The range minimum (min) cannot be greater than maximum (max)");
		this.min = min;
		this.max = max;
	}
	
	
	public T getMax() { return max; }

	public T getMin() { return min; }

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 11 * hash + (this.min == null? 0 : this.min.hashCode());
		hash = 11 * hash + (this.max == null? 0 : this.max.hashCode());
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || (getClass() != obj.getClass()))  return false;
		final Range<?> other = (Range<?>) obj;
		if (this.min != other.min && (this.min == null || !this.min.equals(other.min)))
			return false;
		if (this.max != other.max && (this.max == null || !this.max.equals(other.max)))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Range{" + "min=" + min + ", max=" + max + '}';
	}
	
	/**Returns true if this range contains the given value
	 * @param value
	 * @return  boolean*/
	public boolean contains(T value){
		return (min.compareTo(value)<=0 && max.compareTo(value)>=0);
	}
	
	public boolean contains(Range<T> other){
		return (contains(other.min) && contains(other.max));
	}
	
	/**Returns true if this range contains the given value excluding the Limits min and max
	 * @param value
	 * @return  boolean*/
	public boolean containsWithinLimits(T value){
		return (min.compareTo(value)<0 && max.compareTo(value)>0);
	}
	
	public boolean containsWithinLimits(Range<T> other){
		return (containsWithinLimits(other.min) && containsWithinLimits(other.max));
	}
	
	public boolean isWithinLimits(Range<T> other){
		return other.containsWithinLimits(this);
	}
	
	public boolean isWithin(Range<T> other){
		return other.contains(this);
	}
	
	/**Returns true if this range overlaps the other range. It overlaps when both ranges have at least 
	 * one common value within their range.
	 * It is reflexive: for range r, r.overlaps(r) should return true.
	 * It is symmetric: for ranges r1 and r2, r1.overlaps(r2) should return true if and only if r2.overlaps(r1) returns true.
	 * It is transitive: for ranges r1, r2, and r3, 
	 * if r1.overlaps(r2) returns true and r2.overlaps(r3) returns true, then r1.overlaps(r3) should return true. 
	 * It is consistent: for ranges r1 and r2, multiple invocations of r1.overlaps(r2) consistently return true or consistently return false, 
	 * provided no information used in the overlaps method on the objects is modified.
	 * @param other
	 * @return boolean
	 */
	public boolean overlaps(Range<T> other){
		return containsWithinLimits(other.min) || containsWithinLimits(other.max) 
				|| other.containsWithinLimits(min) || other.containsWithinLimits(max);
	}
	
	/** Splits the range into multiple ranges around the given value within the range.
	 * If the given value is not within the range, it returns an array with a single range equals to this one
	 * @param value
	 * @return array of range */
	public Range<T>[] split(T value){
		if(containsWithinLimits(value))
			return new Range[]{new Range<T>(min, value), new Range<T>(value,max) };
		return new Range[]{new Range<T>(min, max)};
	}
	
	/** Splits the range into multiple ranges around the given values within the range. 
	 * Any of the given values not within the range will not be included in the split
	 * If the given values are not within the range, it returns an array with a single range equals to this one
	 * @param values
	 * @return array of range */
	public Range<T>[] split(T[] values){
		java.util.Arrays.sort(values);
		Set<Range<T>> ranges = new HashSet<Range<T>>(values.length);
		T previous = min;
		for(T v: values){
			if(!v.equals(previous) && containsWithinLimits(v)){
				ranges.add(new Range<T>(previous, v));
				previous = v;
			}
		}
		ranges.add(new Range<T>(previous, max));
		return ranges.toArray(new Range[]{});
	}
	
	public boolean isAfter(Range<T> other){
		return (min.compareTo(other.min)>0);
	}
	
	public boolean isBefore(Range<T> other){
		return other.isAfter(this);
	}
	
	
	/**Returns the range representation of the given min and max values
	 * @param <V>.
	 * @param min
	 * @param max
	 * @return Range*/
	public static <V extends Comparable<V>> Range<V> valueOf(V min, V max){
		return new Range<V>(min,max);
	}
	
	/**Comparator that compares the given ranges by their min (minimum)value */
	public static final Comparator<Range> MIN_VAL_COMPARATOR = new Comparator<Range>(){
		@Override
		public int compare(Range r1, Range r2){
			return r1.min.compareTo(r2.min); 
		}
	};
	
	/**Comparator that compares the given ranges by their min (minimum)value */
	public static final Comparator<Range> MAX_VAL_COMPARATOR = new Comparator<Range>(){
		@Override
		public int compare(Range r1, Range r2){
			return r1.max.compareTo(r2.max); 
		}
	};
}

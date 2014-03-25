package net.lioneldev.mathables;

/**
 * Class that represents a range between two <code>Comparables</code>, where the lowest value is the minimum (<code>min</code>), 
 * and the highest is the maximum (<code>max</code>)
 * @author lionel.ngounou
 * 
 */
public class Range<T extends Comparable<T>> {
	private final T min , max; 

	public Range(T min, T max) {
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
}

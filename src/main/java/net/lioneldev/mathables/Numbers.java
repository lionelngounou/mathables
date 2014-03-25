package net.lioneldev.mathables;

import java.util.HashSet;
import java.util.Set;

/**
 * This class contains static utility methods operating on numbers. 
 * @author lionel ngounou
 */
public class Numbers {
	
	/*Returns true if the given <code>number</code> has no positive factors other than 1 and itself*/
	public static boolean isPrime(long number){
		number = Math.abs(number); //ensure positivity
		if(number<4 && number>=0) return true;
		if(isEven(number) || isMultipleOf3(number)) return false; //early optimisation
		final long quarter = (long) Math.ceil(number*0.25);
		for(long x=4; x<=quarter; x++){
			if(isFactor(number,x)) return false;
		}
		return true;
	}
	
	/**Returns true if the given number is even (divisible by 2 without a remainder)*/
	public static boolean isEven(long number){
		return (number==0 || isFactor(number,2));
	}
	
	/**Returns true if the given number is odd (divisible by 2 with a remainder)*/
	public static boolean isOdd(long number){
		return (number==0 || !isEven(number));
	}
	
	public static Set<Long> primeNumbersInRange(Range<Long> range){
		Set<Long> numbers = new HashSet<Long>(); // TODO: optimise initial capacity
		for(long x=range.getMin(); x<=range.getMax(); x++)
			if(isPrime(x)) numbers.add(x);
		return numbers;
	}
	
	/**Returns a set of prime numbers within the given range. The <code>set</code> would be empty 
	 * if no prime is found. */
	public static Set<Long> primeNumbersInRange(long min , long max){
		return primeNumbersInRange(new Range<Long>(min,max));
	}
	
	/**Returns true if this number is non prime and can be expressed as a fraction of two 
	 * integers whose denominator is a non zero value*/
	public static boolean isNonPrimeRational(long number){
		number = Math.abs(number); //ensure positivity
		if(number<4 && number>=0) return false;
		if(isEven(number) || isMultipleOf3(number)) return true; //early optimisation
		final long quarter = (long) Math.ceil(number*0.25);
		for(long x= 4; x<=quarter; x++){
			if(isFactor(number,x)) return true;
		}
		return false; 
	}
	
	/**Returns true if the given <code>number</code> has a decimal part, false otherwise*/
	public static boolean hasDecimal(double number){
		return number%1.0 != 0.0;
	}
	
	/**Returns true if the given <code>number</code> has no decimal part, false otherwise*/
	public static boolean isWhole(double number){
		return !hasDecimal(number);
	}
	
	/**This function returns the positive factors of the given whole number*/
	public static Set<Long> positiveFactors(long number){
		return factors(number, FactorType.POSIIVE);
	}
	
	/**This function returns the negative factors of the given whole number*/
	public static Set<Long> negativeFactors(long number){
		return factors(number, FactorType.NEGATIVE);
	}
	
	/**This function returns all factors(both positive and negative) of the given whole number*/
	public static Set<Long> allFactors(long number){
		return factors(number, FactorType.ALL);
	}
	
	/**Returns true if the given <code>value</code> is a factor of the given <code>number</code>
	 * @param number
	 * @param value the value to evaluate as factor of <code>number</code>
	 * @return boolean*/
	public static boolean isFactor(long number, long value){
		if(number==0 || value==0) return false;
		return number%value==0;
	}
	
	/**Returns true if the given <code>value</code> is a multiple of the given <code>number</code>
	 * @param number
	 * @param value the value to evaluate as multiple of <code>number</code>
	 * @return boolean*/
	public static boolean isMultiple(long number, long value){
		return isFactor(value, number);
	}
	
	/**Returns true if the given number is a multiple of 3*/
	public static boolean isMultipleOf3(long number){
		return isMultiple(3, number);
	}
	
	/**Returns all the factors of the given <code>number</code>, given the <code>factorType</code>. 
	 Every non zero number has a positive factors of itself and 1, and negative factors of (itself * -1) 
	 * and -1. is a factor of itself. */
	public static Set<Long> factors(final long number, final FactorType factorType){
		final int quarter = (int)Math.abs(Math.ceil(number*0.25));
		Set<Long> factors = new HashSet<Long>(Math.min(500, quarter));//optimise capacity
		addFactorByFactorType(factors, number, factorType); //number is factor of itself
		if(number==0 || Math.abs(number)==1) return factors; //no need to continue if number is 1 or 0
		addFactorByFactorType(factors, 1, factorType); //1 is a factor of all whole numbers
		final long half = (long)Math.ceil(number*0.5);
		boolean negative = number<0;
		long maxIteration = negative? -1:half;
		for(long x=(negative? half:2); x<=maxIteration; x++){
			double factor = number/Math.abs((double)x);
			if(isWhole(factor)){
				addFactorByFactorType(factors, x, factorType); // number = (x) . (factor)
				addFactorByFactorType(factors, factor, factorType); // number = (x) . (factor)
			}
			maxIteration = (long)Math.ceil(factor); //attempt to reduce the number of iterations
		}
		return factors;
	}
	
	private static void addFactorByFactorType(Set<? super Long> factors, double number, FactorType factorType){
		if(factorType==FactorType.ALL) {
			factors.add((long)number);
			factors.add((long)(number * -1)); //flip and add symmetric value
		} 
		else if(factorType==FactorType.POSIIVE) 
			factors.add((long)Math.abs(number));
		else /*negative value*/
			factors.add((long)((number<0)? number: (number * -1)));
	}
	
	/**POSITIVE - denoting a positive factor >=0. 
	 *NEGATIVE - denoting a negative factor <0 .
	 * ALL - denoting both a positive and negative factor
	 */
	public enum FactorType{
		POSIIVE, NEGATIVE, ALL
	}
	
	private Numbers(){}
}

package net.lioneldev.mathables;

public class App 
{
    public static void main( String[] args )
    {
		/*
		Numbers.positiveFactors((Integer.MAX_VALUE)+2); System.gc();
		Numbers.positiveFactors((Integer.MAX_VALUE)+3); System.gc();
		Numbers.positiveFactors((Integer.MAX_VALUE)+4); System.gc();
		Numbers.positiveFactors((Integer.MAX_VALUE)+5); System.gc();
		Numbers.positiveFactors((Integer.MAX_VALUE)+6); System.gc();
		Numbers.positiveFactors((Integer.MAX_VALUE)+7); System.gc();
		Numbers.positiveFactors((Integer.MAX_VALUE)+8); System.gc();
		Numbers.positiveFactors((Integer.MAX_VALUE)+9); System.gc();
		Numbers.positiveFactors((Integer.MAX_VALUE)+11); System.gc();
		Numbers.positiveFactors((Integer.MAX_VALUE)+12); System.gc();
		*/
		//System.out.println(Numbers.positiveFactors(825874596));
		Integer[] v= new Integer[]{4, 7, 9, 12, 11, 25, 17, 20};
		Range[] ranges = Range.valueOf(2, 23).split(v);
		for(Range r: ranges)
			System.out.println(r);
    }
}

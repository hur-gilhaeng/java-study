package chapter03;

public class ArrayUtils {
	static double [] intToDouble( int[] source ) {
		double[] result = null;
		
		if(source==null) {
			return result;
		}
		
		int size = source.length;
		result = new double[size];
		for(int i=0;i<size;i++) {
			result[i] = source[i];
		}
		
		return result;
	}
	
	static int [] doubleToInt( double[] source ) {
		int[] result = null;
		
		if(source==null) {
			return result;
		}
		
		int size = source.length;
		result = new int[size];
		for(int i=0;i<size;i++) {
			result[i] = (int)source[i];
		}
		
		return result;
	}
	
	static int [] concat( int[] s1, int[] s2 ) {
		int[] result = null;
		
		
		int size = s1.length + s2.length;
		result = new int[size];
		for(int i=0;i<size-s2.length;i++) {
			result[i] = s1[i];
		}
		for(int i=0;i<size-s1.length;i++) {
			result[i+s1.length] = s2[i];
		}
		
		return result;
	}
}

package prob01;

public class Printer{
	
	public <T> void println(T input) {
		System.out.println(input);
	}
	
//	public void println(int inputInt) {
//		System.out.println(inputInt);
//	}
//
//	public void println(double inputDouble) {
//		System.out.println(inputDouble);
//	}
//
//	public void println(boolean inputBoolean) {
//		System.out.println(inputBoolean);
//	}
//
//	public void println(String inputString) {
//		System.out.println(inputString);
//	}

	
	// 이하 가변변수
	// ...은 가변변수를 의미한다.
	// 가변변수는 여러변수들의 묶음이라고 
	// 생각하면 된다.
	public int sum(int... nums) {
		int sum = 0;
		for(int n : nums){
			sum += n;
		}
		return sum;
	}
	// 순회가능한(Iterable - List나 Set등등 포함)묶음의 sum 
	public int sum(Iterable<Integer> nums) {
		int sum = 0;
		for(int n : nums){
			sum += n;
		}
		return sum;
	}
	
	// 제네릭 타입 T의 배열은 Object를 이용해서 
	// 표현하는 방법밖에 없기에 경고가 붙는다.
	@SuppressWarnings("unchecked")
	public <T> void println(T... ts) {
		for(T t : ts){
			System.out.println(t);
		}
	}


	
//	public void println(int i, int j, int k, int l, int m, String string, StringBuffer stringBuffer) {
//		System.out.println(i);
//		System.out.println(j);
//		System.out.println(k);
//		System.out.println(l);
//		System.out.println(m);
//		System.out.println(string);
//		System.out.println(stringBuffer);
//	}

}

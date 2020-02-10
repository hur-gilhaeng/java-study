package thread;

public class UppercaseAlphabet {
	
	public void print() {
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.print(c+" ");			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

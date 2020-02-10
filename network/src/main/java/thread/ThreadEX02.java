package thread;

public class ThreadEX02 {

	public static void main(String[] args) {
		Thread thread1 = new DigitalThread();
		Thread thread2 = new AlphabatThread();
		Thread thread3 = new DigitalThread();
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}

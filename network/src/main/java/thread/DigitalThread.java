package thread;

public class DigitalThread extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.print(i+" ");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

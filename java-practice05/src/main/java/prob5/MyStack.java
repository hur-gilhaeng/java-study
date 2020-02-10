package prob5;

public class MyStack<T> {

	private int top;
	private int max;
	private T[] buffer;

	@SuppressWarnings("unchecked")
	public MyStack(int max) {
		this.top = -1;
		this.max = max;
		buffer = (T[]) new Object[max];
	}

	public void push(T t) {
		if(isFulled()) {
			reSize();
		}

		buffer[++top] = t;
	}

	public T pop() throws MyStackException {

		if(isEmpty()) {
			throw new MyStackException("stack is empty");
		}

		T result = buffer[top];
		buffer[top--] = null;

		return result;
	}

	public boolean isEmpty() {
		if(top==-1) { return true; }
		else { return false; }
	}
	
	public boolean isFulled() {
		if(top==(max-1)) { return true; }
		else { return false; }
	}
	
	@SuppressWarnings("unchecked")
	private void reSize() {
		this.max = max+max;
		T[] newBuffer = (T[]) new Object[max];
		int i = 0;
		for(T t : buffer) {
			newBuffer[i] = t;
			i++;
		}
		buffer = newBuffer;
	}
	
}
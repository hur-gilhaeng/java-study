package prob03;

public class Money {
	private int amount;

	public Money(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Money add(Money m) {
		int result = this.amount + m.getAmount();
		return new Money(result);
	}
	
	public Money minus(Money m) {
		int result = this.amount - m.getAmount();
		return new Money(result);
	}

	public Money multiply(Money m) {
		int result = this.amount * m.getAmount();
		return new Money(result);
	}

	public Money devide(Money m) {
		int result = this.amount / m.getAmount();
		return new Money(result);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (amount != other.amount)
			return false;
		return true;
	}
    
}

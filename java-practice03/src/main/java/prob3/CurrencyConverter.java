package prob3;

public class CurrencyConverter {
	private static double rate;

	public static double toDollar(double KRW) {
		return KRW/rate;
	}

	public static double toKRW(double Dollar) {
		return Dollar*rate;
	}

	public static void setRate(double rate) {
		CurrencyConverter.rate = rate;
	}

}

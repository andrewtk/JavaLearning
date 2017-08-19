public class Calculator {
	private int result;

	/**
	суммирование аргументов
	*/

	public void add(int ... params) {
		for (Integer param : params) {
			this.result += param;
		}

	}
	/**
	получить результат
	*/
	public int getResult() {
		return this.result;
	}

	/**
	очистить результат вычисления
	*/
	public void clearResult() {
		this.result = 0;
	}

}
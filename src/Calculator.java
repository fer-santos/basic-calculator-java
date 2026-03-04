public class Calculator {

	public float sum(float firstNumber, float secondNumber) {
		return firstNumber + secondNumber;
	}
	public float res(float firstNumber, float secondNumber) {
		return firstNumber - secondNumber;
	}
	public float mult(float firstNumber, float secondNumber) {
		return firstNumber * secondNumber;
	}
	public float div(float firstNumber, float secondNumber) {
		return firstNumber / secondNumber;
	}
	public float mod(float firstNumber, float secondNumber) {
		return firstNumber % secondNumber;
	}
	public float pow(float firstNumber, float secondNumber) {
		return (float) Math.pow((double) firstNumber, (double) secondNumber);
	}
	public float sqrt(float number) {
		return (float) Math.sqrt(number);
	}
}

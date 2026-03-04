public class Calculator {

	private float firstNumber;
	private float secondNumber;

	public float sum() {
		return this.firstNumber + this.secondNumber;
	}
	public float res() {
		return this.firstNumber - this.secondNumber;
	}
	public float mult() {
		return this.firstNumber * this.secondNumber;
	}
	public float div() {
		return this.firstNumber / this.secondNumber;
	}
	public float mod() {
		return this.firstNumber % this.secondNumber;
	}
	public float pow() {
		return (float) Math.pow((double) this.firstNumber, (double) this.secondNumber);
	}
	public float sqrt() {
		return (float) Math.sqrt(this.firstNumber);
	}


	// ### Getter & Setter ###
	public float getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(float firstNumber) {
		this.firstNumber = firstNumber;
	}

	public float getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(float secondNumber) {
		this.secondNumber = secondNumber;
	}
}

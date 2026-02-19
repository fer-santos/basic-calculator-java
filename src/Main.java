import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- |BASIC CALCULATOR JAVA| ---");
        System.out.print("\nEnter a Number: ");
        float firstNumber = Float.parseFloat(scanner.nextLine());

        System.out.printf("Indicate the Operation to Be Performed to %.1f", firstNumber);
        System.out.println("\n(+)\n(-)\n(*)\n(/)");
        System.out.print("Option: ");
        char operation = scanner.nextLine().charAt(0);

        System.out.printf("%n%.1f %c ", firstNumber, operation);
        float secondNumber = Float.parseFloat(scanner.nextLine());
        float result = Main.optionSelected(operation, firstNumber, secondNumber);
        System.out.printf("Result: %.1f", result);

        scanner.close();
    }

    public static float optionSelected(char option, float firstNumber, float secondNumber) {
        float result = 0;
        switch (option) {
            case '+' -> result = Main.sum(firstNumber, secondNumber);
            case '-' -> result = Main.res(firstNumber, secondNumber);
            case '*' -> result = Main.mult(firstNumber, secondNumber);
            case '/' -> result = Main.div(firstNumber, secondNumber);
        }
        return result;
    }

    public static float sum(float firstNumber, float secondNumber) {
        return firstNumber + secondNumber;
    }
    public static float res(float firstNumber, float secondNumber) {
        return firstNumber - secondNumber;
    }
    public static float mult(float firstNumber, float secondNumber) {
        return firstNumber * secondNumber;
    }
    public static float div(float firstNumber, float secondNumber) {
        return firstNumber / secondNumber;
    }
}
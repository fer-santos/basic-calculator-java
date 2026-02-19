import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- |WELCOME TO BASIC CALCULATOR JAVA| ---");
        System.out.print("\nEnter a Number: ");
        float firstNumber = Float.parseFloat(scanner.nextLine());

        char operator;
        boolean isValid = true;
        do {

        } while ();
        do {
            System.out.printf("Indicate the Operation to Be Performed to %.1f", firstNumber);
            System.out.println("\n(+)\n(-)\n(*)\n(/)");
            System.out.print("Option: ");
            operator = scanner.nextLine().charAt(0);
            isValid = (operator == '+' || operator == '-' || operator == '*' || operator == '/');
            if (!isValid) {
                System.out.println("*** ENTER A CORRECTOR OPERATOR! ***\n");
            }
        } while (!isValid);

        float secondNumber;
        if (operator == '/') {
            isValid = true;
            do {
                System.out.printf("%n%.1f %c ", firstNumber, operator);
                secondNumber = Float.parseFloat(scanner.nextLine());
                isValid = secondNumber != 0;
                if (!isValid) {
                    System.out.println("\n*** IT IS NOT POSSIBLE TO DIVIDE BY ZERO! ***");
                }
            } while (!isValid);
        } else {
            System.out.printf("%n%.1f %c ", firstNumber, operator);
            secondNumber = Float.parseFloat(scanner.nextLine());
        }

        float result = Main.optionSelected(operator, firstNumber, secondNumber);
        System.out.printf("%nResult: %.1f", result);

        char optionContinue;
        isValid = true;
        do {
            System.out.printf("%nContinue doing operations on %.1f Y/n: ", result);
            optionContinue = scanner.nextLine().charAt(0);
            isValid = optionContinue == 'Y' || optionContinue == 'y' || optionContinue == 'n' || optionContinue == 'N';
            System.out.println("*** ENTER A CORRECT OPTION! (Y/n) ***");
        } while (!isValid);

        if (optionContinue == 'Y' || optionContinue == 'y') {
            firstNumber = result;
        }

        scanner.close();
    }

    // ### METHODS ###
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
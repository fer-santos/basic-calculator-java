import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- |WELCOME TO BASIC CALCULATOR JAVA| ---");

        ArrayList<String> history = new ArrayList<>();
        String auxString;
        char optionContinue = ' ';
        char operator;
        float firstNumber;
        float secondNumber;
        boolean isValid;

        do {
            firstNumber = Main.enterNumber("Enter a Number: ");
            do {
                operator = ' ';
                do {
                    try {
                        System.out.printf("Indicate the Operation to Be Performed to %.1f", firstNumber);
                        System.out.println("\n(+)\n(-)\n(*)\n(/)\n(%)\n(^)\n(r)");
                        System.out.print("Option: ");
                        operator = scanner.nextLine().charAt(0);
                    } catch (StringIndexOutOfBoundsException e) {
                    }
                    isValid = (operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '%' || operator == '^' || operator == 'r');
                    if (!isValid) {
                        System.out.println("\n*** ENTER A CORRECTOR OPERATOR! ***\n");
                    }
                } while (!isValid);

                float result = 0;
                if (operator != 'r') {
                    auxString = String.format("%n%.1f %c ", firstNumber, operator);

                    if (operator == '/' || operator == '%') {
                        boolean isNotZero;
                        do {
                            secondNumber = Main.enterNumber(auxString);
                            isNotZero = secondNumber != 0;
                            if (!isNotZero) System.out.println("\n*** OPERATION NOT POSSIBLE ***");
                        } while (!isNotZero);
                    } else {
                        secondNumber = Main.enterNumber(auxString);
                    }

                    result = Main.optionSelected(operator, firstNumber, secondNumber);
                    System.out.printf("%nResult: %.1f%n", result);
                    history.add("%.1f %c %.1f = %.1f".formatted(firstNumber, operator, secondNumber, result));
                } else {
                    if (firstNumber >= 0) {
                        // result = Main.sqrt(firstNumber);
                        result = Main.optionSelected(operator, firstNumber, secondNumber = 0);
                        System.out.println("\u221A" + firstNumber + "=" + result);
                        history.add("\u221A%.1f = %.1f".formatted(firstNumber, result));
                    } else {
                        System.out.println("\n *** IT IS NOT POSSIBLE TO DISPLAY A RESULT WITH A NEGATIVE NUMBER \n***");
                        break;
                    }
                }
                optionContinue = Main.continueProgram("%nContinue doing operations on %.1f? Y/n: ".formatted(result));
                firstNumber = Main.continueOperationWithSqrt(optionContinue, result);
            } while (optionContinue == 'Y' || optionContinue == 'y');

            optionContinue = Main.continueProgram("New Operation? Y/n: ");
        } while (optionContinue == 'Y' || optionContinue == 'y');
        Main.printHistory(history);
        System.out.println("\n=== End of Program ===\n");

        scanner.close();
    }

    // ###### METHODS ######
    public static float optionSelected(char option, float firstNumber, float secondNumber) {
        Calculator calculator = new Calculator();
        float result = 0;
        switch (option) {
            case '+' -> result = calculator.sum(firstNumber, secondNumber);
            case '-' -> result = calculator.res(firstNumber, secondNumber);
            case '*' -> result = calculator.mult(firstNumber, secondNumber);
            case '/' -> result = calculator.div(firstNumber, secondNumber);
            case '%' -> result = calculator.mod(firstNumber, secondNumber);
            case '^' -> result = calculator.pow(firstNumber, secondNumber);
            case 'r' -> result = calculator.sqrt(firstNumber);
        }
        return result;
    }

    public static float enterNumber (String string) {

        float number = 0;
        boolean isValid = false;
        do {
            try {
                System.out.printf("%s", string);
                number = Float.parseFloat(scanner.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("\n*** ENTER A NUMERIC VALUE ***");
            }
        } while (!isValid);
        return number;
    }

    public static char continueProgram(String string) {
        char optionContinue = ' ';
        boolean isValid = false;
        do {
            try {
                System.out.printf(string);
                optionContinue = scanner.nextLine().charAt(0);
                isValid = optionContinue == 'Y' || optionContinue == 'y' || optionContinue == 'n' || optionContinue == 'N';
            } catch (StringIndexOutOfBoundsException e) { }

            if (!isValid) {
                System.out.println("\n*** ENTER A CORRECT OPTION! (Y/n) ***\n");
            }
        } while (!isValid);
        return optionContinue;
    }

    public static float continueOperationWithSqrt(char optionContinue, float result) {
        float firstNumber = 0;
        if (optionContinue == 'Y' || optionContinue == 'y') {
            firstNumber = result;
        }
        return firstNumber;
    }

    public static void printHistory(ArrayList<String> history) {
        System.out.println("\n --- |OPERATION HISTORY| ---");
        for (String operation : history) {
            System.out.println(operation);
        }
    }
}
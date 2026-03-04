import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- |WELCOME TO BASIC CALCULATOR JAVA| ---");
        char optionContinue = ' ';
        float firstNumber;
        float secondNumber;
        boolean isValid;
        String auxString;
        char operator;

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
                } else {
                    if (firstNumber >= 0) {
                        result = Main.sqrt(firstNumber);
                        System.out.println("\u221A" + firstNumber + "=" + result);
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
        System.out.println("\n=== End of Program ===\n");

        scanner.close();
    }

    // ###### METHODS ######
    public static float optionSelected(char option, float firstNumber, float secondNumber) {
        float result = 0;
        switch (option) {
            case '+' -> result = Main.sum(firstNumber, secondNumber);
            case '-' -> result = Main.res(firstNumber, secondNumber);
            case '*' -> result = Main.mult(firstNumber, secondNumber);
            case '/' -> result = Main.div(firstNumber, secondNumber);
            case '%' -> result = Main.mod(firstNumber, secondNumber);
            case '^' -> result = Main.pow(firstNumber, secondNumber);
            case 'r' -> result = Main.sqrt(firstNumber);
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
    public static float mod(float firstNumber, float secondNumber) {
        return firstNumber % secondNumber;
    }
    public static float pow(float firstNumber, float secondNumber) {
        return (float) Math.pow((double) firstNumber, (double) secondNumber);
    }
    public static float sqrt(float number) {
        return (float) Math.sqrt(number);
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
}
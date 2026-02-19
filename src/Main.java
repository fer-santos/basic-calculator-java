import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- |WELCOME TO BASIC CALCULATOR JAVA| ---");
        char optionContinue = ' ';
        float firstNumber;
        boolean isValid;
        do {
            firstNumber = 0;
            isValid = false;
            do {
                try {
                    System.out.print("\nEnter a Number: ");
                    firstNumber = Float.parseFloat(scanner.nextLine());
                    isValid = true;
                } catch (NumberFormatException e) {
                    System.out.println("\n*** ENTER A NUMERIC VALUE ***");
                }
            } while (!isValid);

            char operator = ' ';
            isValid = true;
            do {
                operator = ' ';
                do {
                    try {
                        System.out.printf("Indicate the Operation to Be Performed to %.1f", firstNumber);
                        System.out.println("\n(+)\n(-)\n(*)\n(/)");
                        System.out.print("Option: ");
                        operator = scanner.nextLine().charAt(0);
                    } catch (StringIndexOutOfBoundsException e) { }
                    isValid = (operator == '+' || operator == '-' || operator == '*' || operator == '/');
                    if (!isValid) {
                        System.out.println("\n*** ENTER A CORRECTOR OPERATOR! ***\n");
                    }
                } while (!isValid);

                float secondNumber = 0;
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
                    isValid = false;
                    do {
                        try {
                            System.out.printf("%n%.1f %c ", firstNumber, operator);
                            secondNumber = Float.parseFloat(scanner.nextLine());
                            isValid = true;
                        } catch (NumberFormatException e) {
                            System.out.println("*** INPUT A CORRECT VALUE ***");
                        }
                    } while (!isValid);
                }

                float result = Main.optionSelected(operator, firstNumber, secondNumber);
                System.out.printf("%nResult: %.1f%n", result);

                isValid = false;
                do {
                    try {
                        System.out.printf("%nContinue doing operations on %.1f Y/n: ", result);
                        optionContinue = scanner.nextLine().charAt(0);
                        isValid = optionContinue == 'Y' || optionContinue == 'y' || optionContinue == 'n' || optionContinue == 'N';
                    } catch (StringIndexOutOfBoundsException e) { }

                    if (!isValid) {
                        System.out.println("\n*** ENTER A CORRECT OPTION! (Y/n) ***");
                    }
                } while (!isValid);

                if (optionContinue == 'Y' || optionContinue == 'y') {
                    firstNumber = result;
                }
            } while (optionContinue == 'Y' || optionContinue == 'y');

            isValid = true;
            do {
                try {
                    System.out.println("(1) New Operation\n(2) Exit");
                    System.out.print("Option: ");
                    optionContinue = scanner.nextLine().charAt(0);
                } catch (StringIndexOutOfBoundsException e) { }
                isValid = optionContinue == '1' || optionContinue == '2';

                if (!isValid) {
                    System.out.println("\n*** ENTER VALID OPTIONS (1, 2)***\n");
                }
            } while (!isValid);
        } while (optionContinue != '2');
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
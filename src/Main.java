import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- |BASIC CALCULATOR JAVA| ---");
        System.out.print("\nEnter a Number: ");
        float firstNumber = Float.parseFloat(scanner.nextLine());
        System.out.printf("Indicate the Operation to Be Performed to %.1f", firstNumber);
        System.out.println("\n(+)\n(-)\n(*)\n(/)");
        char operation = scanner.next().charAt(0);
        Main.optionSelected(operation);

        System.out.print("Enter a Second Number: ");

    }

    public static void optionSelected(char option) {

    }

    public static float sum() {
        return 0;
    }
}
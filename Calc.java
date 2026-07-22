import java.util.InputMismatchException;
import java.util.Scanner;

public class Calc {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("=== Better Calculator ===");

        boolean continueRunning = true;
        while (continueRunning) {
            double num1 = readNumber(in, "Input first number: ");
            double num2 = readNumber(in, "Input second number: ");

            System.out.println("\nChoose an operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Modulus");
            System.out.println("6. Power");
            System.out.println("7. Show all basic operations");

            int choice = readMenuChoice(in);
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.println(formatBinaryResult(num1, "+", num2, num1 + num2));
                    break;
                case 2:
                    System.out.println(formatBinaryResult(num1, "-", num2, num1 - num2));
                    break;
                case 3:
                    System.out.println(formatBinaryResult(num1, "x", num2, num1 * num2));
                    break;
                case 4:
                    if (num2 == 0) {
                        System.out.println("Cannot divide by zero.");
                    } else {
                        System.out.println(formatBinaryResult(num1, "/", num2, num1 / num2));
                    }
                    break;
                case 5:
                    if (num2 == 0) {
                        System.out.println("Cannot calculate modulus with zero.");
                    } else {
                        System.out.println(formatBinaryResult(num1, "%", num2, num1 % num2));
                    }
                    break;
                case 6:
                    System.out.println(formatBinaryResult(num1, "^", num2, Math.pow(num1, num2)));
                    break;
                case 7:
                    printBasicOperations(num1, num2);
                    break;
                default:
                    System.out.println("Invalid option selected.");
                    break;
            }

            continueRunning = askToContinue(in);
            System.out.println();
        }

        System.out.println("Thanks for using the calculator.");
        in.close();
    }

    private static double readNumber(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return in.nextDouble();
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid number.");
                in.nextLine();
            }
        }
    }

    private static int readMenuChoice(Scanner in) {
        while (true) {
            System.out.print("Enter your choice (1-7): ");
            try {
                int choice = in.nextInt();
                if (choice >= 1 && choice <= 7) {
                    return choice;
                }
                System.out.println("Please choose a number between 1 and 7.");
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid menu option.");
                in.nextLine();
            }
        }
    }

    private static boolean askToContinue(Scanner in) {
        while (true) {
            System.out.print("Do you want to perform another calculation? (y/n): ");
            String answer = in.next().trim().toLowerCase();
            if (answer.equals("y") || answer.equals("yes")) {
                return true;
            }
            if (answer.equals("n") || answer.equals("no")) {
                return false;
            }
            System.out.println("Please enter y or n.");
        }
    }

    private static void printBasicOperations(double num1, double num2) {
        System.out.println(formatBinaryResult(num1, "+", num2, num1 + num2));
        System.out.println(formatBinaryResult(num1, "-", num2, num1 - num2));
        System.out.println(formatBinaryResult(num1, "x", num2, num1 * num2));
        if (num2 == 0) {
            System.out.println(formatNumber(num1) + " / " + formatNumber(num2) + " = undefined (division by zero)");
        } else {
            System.out.println(formatBinaryResult(num1, "/", num2, num1 / num2));
        }
    }

    private static String formatBinaryResult(double num1, String operator, double num2, double result) {
        return formatNumber(num1) + " " + operator + " " + formatNumber(num2) + " = " + formatNumber(result);
    }

    private static String formatNumber(double value) {
        if (value == (long) value) {
            return String.format("%d", (long) value);
        }
        return String.format("%.2f", value);
    }
}

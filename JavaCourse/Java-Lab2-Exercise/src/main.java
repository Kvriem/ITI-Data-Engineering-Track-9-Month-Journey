import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Even or Odd Number Checker");
        System.out.println("===========================\n");
        String continueChecking;

        do {
            System.out.print("Enter a number to check: ");
            int number = scanner.nextInt();

            if (isEven(number)) {
                System.out.println("The number " + number + " is EVEN.");
            } else {
                System.out.println("The number " + number + " is ODD.");
            }

            System.out.println("Verification: " + number + " % 2 = " + (number % 2));
            System.out.print("\nDo you want to check another number? (yes/no): ");
            continueChecking = scanner.next().toLowerCase();

        } while (continueChecking.equals("yes") || continueChecking.equals("y"));

        System.out.println("\nProgram closed");
        scanner.close();
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

}
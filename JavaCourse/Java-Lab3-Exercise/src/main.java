import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("IP Address Parser");
        System.out.println("==================\n");

        System.out.print("Enter an IP address : ");
        String ipAddress = scanner.nextLine();


            System.out.println("\nParsed Components:");
            System.out.println("==================");

            String[] parts = ipAddress.split("\\.");

            for (int i = 0; i < parts.length; i++) {
                System.out.println("Octet " + (i + 1) + ": " + parts[i]);
            }


    }

}
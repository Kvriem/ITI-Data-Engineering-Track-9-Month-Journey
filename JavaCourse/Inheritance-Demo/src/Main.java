import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num1: ");
        int n1 = sc.nextInt();
        System.out.print("Enter num2: ");
        int n2 = sc.nextInt();

        Parent p = new Parent(n1, n2);
        System.out.println("Parent sum = " + p.sum());

        System.out.print("Enter num3: ");
        int n3 = sc.nextInt();
        Child c = new Child(p.num1, p.num2, n3);
        System.out.println("Child sum = " + c.sum());
    }
}
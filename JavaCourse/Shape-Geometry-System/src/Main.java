public class Main {
    public static void main(String[] args) {
        Shape r = new Rectangle(5, 10);
        Shape t = new Triangle(6, 4);
        Shape c = new Circle(3);

        Picture p = new Picture();
        System.out.println("Total Areas = " + p.sumAreas(r, t, c));
    }
}
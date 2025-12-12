public class Heloo {
    public static void main(String[] args) {
       task1 t1 = new task1();
       t1.print();

        complexnum n1 = new complexnum(5,6);
        complexnum n2 = new complexnum(2,3);

        complexnum sum1 = n1.sum(n2);
        complexnum sub2 = n2.sub(n1);

        sum1.print();
        sub2.print();

    }
}

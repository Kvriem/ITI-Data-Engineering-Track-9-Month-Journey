class Child extends Parent {
    int num3;

    Child(int n1, int n2, int n3) {
        super(n1, n2);
        this.num3 = n3;
    }

    @Override
    int sum() {
        return num1 + num2 + num3;
    }
}
class Triangle extends Shape {
    Triangle(double base, double height) {
        super(base, height);
    }

    double calculateArea() {
        return 0.5 * dim1 * dim2;
    }
}
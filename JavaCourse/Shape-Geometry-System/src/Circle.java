class Circle extends Shape {
    Circle(double radius) {
        super(radius, 0);
    }

    double calculateArea() {
        return Math.PI * dim1 * dim1;
    }
}
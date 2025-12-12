class Rectangle extends Shape {
    Rectangle(double w, double h) {
        super(w, h);
    }
    @Override
    double calculateArea() {
        return dim1 * dim2;
    }
}
package solid.isp;

public class Figure2D implements Figure {
    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public double square() {
        return 0;
    }

    @Override
    public double volume() {
        throw new UnsupportedOperationException();
    }
}

interface Figure {
    double perimeter();

    double square();

    double volume();
}
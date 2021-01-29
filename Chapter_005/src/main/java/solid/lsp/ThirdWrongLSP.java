package solid.lsp;

public class ThirdWrongLSP {
    private static class Rectangle {
        protected int a;
        protected int b;

        public Rectangle(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public void square() {
            System.out.println(a * b);
        }
    }

    private static class SquareRectangle extends Rectangle {
        public SquareRectangle(int a, int b) {
            super(a, b);
        }

        @Override
        public void square() {
            System.out.println(a * a);
        }
    }

    public static void main(String[] args) {
        Rectangle rectangle = new SquareRectangle(5, 10);
        rectangle.square();
    }
}

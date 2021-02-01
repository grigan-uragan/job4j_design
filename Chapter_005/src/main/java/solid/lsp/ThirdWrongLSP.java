package solid.lsp;

public class ThirdWrongLSP {
    private static class Rectangle {
        private int a;
        private int b;

        public Rectangle(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public void square() {
            System.out.println(a * b);
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }

    private static class SquareRectangle extends Rectangle {
        public SquareRectangle(int a, int b) {
            super(a, b);
        }

        @Override
        public void square() {
            System.out.println(this.getA() * this.getA());
        }
    }

    public static void main(String[] args) {
        Rectangle rectangle = new SquareRectangle(5, 10);
        rectangle.square();
    }
}

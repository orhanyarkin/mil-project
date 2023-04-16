package hw2;

public class Test {
    public static void main(String[] args) {
        Drawer drawer = new Drawer();

        Polynomial f1 = new Polynomial(-6, 5, 1);
        drawer.draw(f1, -10, 10, 100);

        Sinusoidal f2 = new Sinusoidal(10, 2, Math.PI / 6);
        drawer.draw(f2, 0, 10, 100);

        double[] newCoefficients = {1, 2, 3, 4};
        f1.setCoefficients(newCoefficients);
        drawer.draw(f1, -10, 10, 100);

        f2.setA(5);
        f2.setB(3);
        f2.setC(Math.PI / 3);
        drawer.draw(f2, 0, 10, 100);
    }
}

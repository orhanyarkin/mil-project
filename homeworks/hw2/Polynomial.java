package hw2;

public class Polynomial implements Function {
    private double[] coefficients;

    public Polynomial(double... coefficients) {
        this.coefficients = coefficients;
    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(double... coefficients) {
        this.coefficients = coefficients;
    }
}
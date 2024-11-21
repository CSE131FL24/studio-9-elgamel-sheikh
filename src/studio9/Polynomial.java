package studio9;

import java.util.LinkedList;

public class Polynomial {
    private LinkedList<Double> coefficients;

    // Constructor initializes an empty polynomial (empty list of coefficients)
    public Polynomial() {
        coefficients = new LinkedList<>();
    }

    // Adds a term to the polynomial. Assumes that terms are added in increasing power order.
    public void addTerm(double coefficient) {
        coefficients.add(coefficient);
    }

    // Returns the string representation of the polynomial
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < coefficients.size(); i++) {
            double coefficient = coefficients.get(i);
            int power = coefficients.size() - 1 - i;

            if (coefficient != 0) {
                if (sb.length() > 0) {
                    sb.append(coefficient > 0 ? " + " : " - ");
                } else if (coefficient < 0) {
                    sb.append("-");
                }

                sb.append(Math.abs(coefficient));

                if (power > 0) {
                    sb.append("x");
                    if (power > 1) {
                        sb.append("^").append(power);
                    }
                }
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    // Evaluates the polynomial at a given value of x
    public double evaluate(double x) {
        double result = 0;
        int power = coefficients.size() - 1;

        for (double coefficient : coefficients) {
            result += coefficient * Math.pow(x, power);
            power--;
        }

        return result;
    }

    // Computes the derivative of the polynomial using the power rule
    public Polynomial derivative() {
        Polynomial derivative = new Polynomial();

        for (int i = 0; i < coefficients.size(); i++) {
            double coefficient = coefficients.get(i);
            int power = coefficients.size() - 1 - i;

            if (power > 0) {
                derivative.addTerm(coefficient * power);
            }
        }

        return derivative;
    }

    // Override equals to compare two polynomials
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Polynomial that = (Polynomial) obj;

        // Compare coefficients list for equality
        return this.coefficients.equals(that.coefficients);
    }

    // Override hashCode to ensure proper hashing of polynomial objects
    @Override
    public int hashCode() {
        return coefficients.hashCode();
    }
}

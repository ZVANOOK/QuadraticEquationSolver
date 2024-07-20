public class QuadraticEquationSolver {

    public static double[] solve(double a, double b, double c, double delta) {
        if (Math.abs(a) < delta) {
            throw new IllegalArgumentException("Коэфициент не может быть 0.");
        }
        
        if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c) ||
            Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c)) {
            throw new IllegalArgumentException("Неверный коэфициент.");
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant < -delta) {
            return new double[]{};
        } else if (Math.abs(discriminant) < delta) {
            double x = -b / (2 * a);
            return new double[]{x, x};
        } else {
            double sqrtDiscriminant = Math.sqrt(discriminant);
            double x1 = (-b + sqrtDiscriminant) / (2 * a);
            double x2 = (-b - sqrtDiscriminant) / (2 * a);
            return new double[]{x1, x2};
        }
    }

    public static double[] solve(double a, double b, double c) {
        return solve(a, b, c, 1e-10);
    }
}


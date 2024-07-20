import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationSolverTest {

    @Test
    void testNoRoots() {
        double delta = 1e-10;
        double[] roots = QuadraticEquationSolver.solve(1, 0, 1, delta);
        assertEquals(0, roots.length, "Ожидалось, что уравнение x^2 + 1 = 0 не будет иметь корней.");
    }
    
    @Test
    void testTwoDistinctRoots() {
        double delta = 1e-10;
        double[] roots = QuadraticEquationSolver.solve(1, 0, -1, delta);
        assertEquals(2, roots.length, "Ожидалось, что уравнение x^2 - 1 = 0 будет иметь два корня.");
        assertArrayEquals(new double[]{1.0, -1.0}, roots, delta);
    }

    @Test
    void testOneDoubleRoot() {
        double delta = 1e-10;
        double[] roots = QuadraticEquationSolver.solve(1, 2, 1, delta);
        assertArrayEquals(new double[]{-1.0, -1.0}, roots, delta);
    }

    @Test
    void testCoefficientANotZero() {
        double delta = 1e-10;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            QuadraticEquationSolver.solve(0, 2, 1, delta);
        });
        assertEquals("Коэффициент \"а\" не может быть равен нулю.", exception.getMessage());
    }

    @Test
    void testDoubleRootWithSmallDelta() {
        double delta = 1e-10;
        double[] roots = QuadraticEquationSolver.solve(1, 2.0000000001, 1.0000000001, delta);
        assertEquals(roots[0], roots[1], delta);
    }

    @Test
    void testInvalidCoefficients() {
        double delta = 1e-10;
        assertThrows(IllegalArgumentException.class, () -> {
            QuadraticEquationSolver.solve(Double.NaN, 2, 1, delta);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            QuadraticEquationSolver.solve(1, Double.POSITIVE_INFINITY, 1, delta);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            QuadraticEquationSolver.solve(1, 2, Double.NEGATIVE_INFINITY, delta);
        });
    }
}

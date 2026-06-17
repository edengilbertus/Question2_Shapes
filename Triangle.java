public class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) throws InvalidShapeException {
        super("white", false);
        validateSides(sideA, sideB, sideC);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public Triangle(double sideA, double sideB, double sideC, String color, boolean filled)
            throws InvalidShapeException {
        super(color, filled);
        validateSides(sideA, sideB, sideC);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    private void validateSides(double a, double b, double c) throws InvalidShapeException {
        if (a <= 0) {
            throw new InvalidShapeException("Side A must be positive. Got: " + a);
        }
        if (b <= 0) {
            throw new InvalidShapeException("Side B must be positive. Got: " + b);
        }
        if (c <= 0) {
            throw new InvalidShapeException("Side C must be positive. Got: " + c);
        }
        // Triangle inequality theorem: sum of any two sides must be greater than the third
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new InvalidShapeException(
                    "Triangle inequality violated: sides " + a + ", " + b + ", " + c + " cannot form a triangle.");
        }
    }

    @Override
    public double getArea() {
        // Heron's formula
        double s = (sideA + sideB + sideC) / 2.0;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public void resize(double factor) throws InvalidShapeException {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize factor must be positive. Got: " + factor);
        }
        this.sideA *= factor;
        this.sideB *= factor;
        this.sideC *= factor;
    }

    // Getters and Setters
    public double getSideA() { return sideA; }
    public double getSideB() { return sideB; }
    public double getSideC() { return sideC; }

    public void setSideA(double sideA) throws InvalidShapeException {
        validateSides(sideA, this.sideB, this.sideC);
        this.sideA = sideA;
    }

    public void setSideB(double sideB) throws InvalidShapeException {
        validateSides(this.sideA, sideB, this.sideC);
        this.sideB = sideB;
    }

    public void setSideC(double sideC) throws InvalidShapeException {
        validateSides(this.sideA, this.sideB, sideC);
        this.sideC = sideC;
    }

    @Override
    public String toString() {
        return "Triangle[sides=(" + sideA + ", " + sideB + ", " + sideC
                + "), color=" + color + ", filled=" + filled + "]";
    }
}

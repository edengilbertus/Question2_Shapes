public class Circle extends Shape {
    private double radius;

    public Circle(double radius) throws InvalidShapeException {
        super("white", false);
        if (radius <= 0) {
            throw new InvalidShapeException("Radius must be positive. Got: " + radius);
        }
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) throws InvalidShapeException {
        super(color, filled);
        if (radius <= 0) {
            throw new InvalidShapeException("Radius must be positive. Got: " + radius);
        }
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void resize(double factor) throws InvalidShapeException {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize factor must be positive. Got: " + factor);
        }
        this.radius *= factor;
    }

    // Getters and Setters
    public double getRadius() { return radius; }
    public void setRadius(double radius) throws InvalidShapeException {
        if (radius <= 0) {
            throw new InvalidShapeException("Radius must be positive. Got: " + radius);
        }
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color + ", filled=" + filled + "]";
    }
}

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) throws InvalidShapeException {
        super("white", false);
        if (width <= 0) {
            throw new InvalidShapeException("Width must be positive. Got: " + width);
        }
        if (height <= 0) {
            throw new InvalidShapeException("Height must be positive. Got: " + height);
        }
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled) throws InvalidShapeException {
        super(color, filled);
        if (width <= 0) {
            throw new InvalidShapeException("Width must be positive. Got: " + width);
        }
        if (height <= 0) {
            throw new InvalidShapeException("Height must be positive. Got: " + height);
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void resize(double factor) throws InvalidShapeException {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize factor must be positive. Got: " + factor);
        }
        this.width *= factor;
        this.height *= factor;
    }

    // Getters and Setters
    public double getWidth() { return width; }
    public double getHeight() { return height; }

    public void setWidth(double width) throws InvalidShapeException {
        if (width <= 0) {
            throw new InvalidShapeException("Width must be positive. Got: " + width);
        }
        this.width = width;
    }

    public void setHeight(double height) throws InvalidShapeException {
        if (height <= 0) {
            throw new InvalidShapeException("Height must be positive. Got: " + height);
        }
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle[width=" + width + ", height=" + height
                + ", color=" + color + ", filled=" + filled + "]";
    }
}

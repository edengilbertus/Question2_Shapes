public abstract class Shape {
    protected String color = "white";
    protected boolean filled;

    public Shape() {
        this.color = "white";
        this.filled = false;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void resize(double factor) throws InvalidShapeException;

    // Getters
    public String getColor() { return color; }
    public boolean isFilled() { return filled; }

    // Setters
    public void setColor(String color) { this.color = color; }
    public void setFilled(boolean filled) { this.filled = filled; }

    @Override
    public String toString() {
        return "Shape[color=" + color + ", filled=" + filled + "]";
    }
}

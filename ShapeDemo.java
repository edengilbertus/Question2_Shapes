public class ShapeDemo {

    /**
     * Prints the area of each shape through the superclass reference (dynamic binding).
     */
    public static void printAreas(Shape[] shapes) {
        System.out.println("--- Shape Areas ---");
        for (Shape shape : shapes) {
            // Dynamic binding: getArea() is resolved at runtime based on actual object type
            System.out.println(shape.getClass().getSimpleName() + ": area = " + String.format("%.2f", shape.getArea()));
        }
    }

    /**
     * Returns the shape with the largest area by comparing getArea() values.
     */
    public static Shape largest(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) {
            return null;
        }
        Shape maxShape = shapes[0];
        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getArea() > maxShape.getArea()) {
                maxShape = shapes[i];
            }
        }
        return maxShape;
    }

    public static void main(String[] args) {
        try {
            // Create shapes
            Circle circle = new Circle(5, "red", true);
            Rectangle rectangle = new Rectangle(4, 6, "blue", false);
            Triangle triangle = new Triangle(3, 4, 5, "green", true);

            // Array of Shape references (polymorphism)
            Shape[] shapes = { circle, rectangle, triangle };

            // Print areas using dynamic binding
            System.out.println("=== DYNAMIC BINDING DEMONSTRATION ===");
            printAreas(shapes);
            System.out.println();

            // Find and print the largest shape
            Shape biggest = largest(shapes);
            System.out.println("--- Largest Shape ---");
            System.out.println(biggest.getClass().getSimpleName() + " with area = "
                    + String.format("%.2f", biggest.getArea()));
            System.out.println();

            // Demonstrate resize
            System.out.println("=== RESIZE DEMONSTRATION ===");
            System.out.println("Before resize: " + circle);
            circle.resize(2); // Double the radius
            System.out.println("After resize (factor=2): " + circle);
            System.out.println("New area: " + String.format("%.2f", circle.getArea()));
            System.out.println();

            // Demonstrate exception handling with invalid triangle
            System.out.println("=== EXCEPTION HANDLING DEMONSTRATION ===");
            System.out.println("Attempting to create a triangle with sides 1, 2, 10...");
            try {
                Triangle invalidTriangle = new Triangle(1, 2, 10);
                System.out.println("This line should not be printed.");
            } catch (InvalidShapeException e) {
                System.out.println("Caught InvalidShapeException: " + e.getMessage());
            }

            // Demonstrate exception handling with non-positive resize factor
            System.out.println();
            System.out.println("Attempting to resize a rectangle with factor = -3...");
            try {
                rectangle.resize(-3);
                System.out.println("This line should not be printed.");
            } catch (InvalidShapeException e) {
                System.out.println("Caught InvalidShapeException: " + e.getMessage());
            }

            // Demonstrate exception handling with zero radius circle
            System.out.println();
            System.out.println("Attempting to create a circle with radius = 0...");
            try {
                Circle invalidCircle = new Circle(0);
                System.out.println("This line should not be printed.");
            } catch (InvalidShapeException e) {
                System.out.println("Caught InvalidShapeException: " + e.getMessage());
            }

        } catch (InvalidShapeException e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}

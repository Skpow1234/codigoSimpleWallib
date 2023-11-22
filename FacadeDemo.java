// Paso 1: Crear la interfaz Shape
interface Shape {
    void draw();
}

// Paso 2: Implementar la interfaz Shape con las clases Circle, Rectangle y Square
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

// Paso 3: Crear la clase ShapeFactory usando el patrón Factory Method
class ShapeFactory {
    public Shape createShape(String shapeType) {
        switch (shapeType.toLowerCase()) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "square":
                return new Square();
            default:
                throw new IllegalArgumentException("Invalid shape type");
        }
    }
}

// Paso 4: Refactorizar ShapeMaker para usar el patrón Facade
class ShapeMaker {
    private ShapeFactory shapeFactory;

    public ShapeMaker() {
        this.shapeFactory = new ShapeFactory();
    }

    public void drawShape(String shapeType) {
        Shape shape = shapeFactory.createShape(shapeType);
        shape.draw();
    }
}

// Paso 5: Crear la clase FacadeDemo
public class FacadeDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

       // Usar Facade para dibujar las formas
        shapeMaker.drawShape("circle");
        shapeMaker.drawShape("rectangle");
        shapeMaker.drawShape("square");
    }
}


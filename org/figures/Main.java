package org.figures;

public class Main {
    public static void main(String[] args) {
        try {
            Canvas canvas = new Canvas();

            Point p1 = new Point(1, 1);
            Point p2 = new Point(4, 4);
            Rectangle rect1 = new Rectangle(p1, p2);

            Point p3 = new Point(2, 2);
            Point p4 = new Point(5, 5);
            Rectangle rect2 = new Rectangle(p3, p4);

            Point p5 = new Point(3, 3);
            Circle circle1 = new Circle(p5, 1);
            Triangle triangle1 = new Triangle(new Point(102,112), new Point(105,112), new Point(103,115));

            canvas.addShape(rect1);
            canvas.addShape(rect2);
            canvas.addShape(circle1);
            canvas.addShape(triangle1);
            canvas.printShapes();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
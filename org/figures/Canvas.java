package org.figures;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    private List<ShapeWithDepth> shapes;

    public Canvas() {
        this.shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) throws Exception {
        int depth = 0;
        for (ShapeWithDepth existingShape : shapes) {
            if (shape.overlaps(existingShape.shape)) {
                depth = Math.max(depth, existingShape.depth + 1);
            }
        }
        shapes.add(new ShapeWithDepth(shape, depth));
    }

    public void printShapes() {
        for (ShapeWithDepth shapeWithDepth : shapes) {
            System.out.println(shapeWithDepth.shape + " with depth " + shapeWithDepth.depth);
        }
    }
    public void moveShapeUp(Shape shape) {
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i).shape.equals(shape) && i > 0) {
                ShapeWithDepth temp = shapes.get(i);
                shapes.set(i, shapes.get(i - 1));
                shapes.set(i - 1, temp);
                break;
            }
        }
    }
    public void moveShapeDown(Shape shape) {
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i).shape.equals(shape) && i < shapes.size() - 1) {
                ShapeWithDepth temp = shapes.get(i);
                shapes.set(i, shapes.get(i + 1));
                shapes.set(i + 1, temp);
                break;
            }
        }
    }

    private static class ShapeWithDepth {
        Shape shape;
        int depth;

        ShapeWithDepth(Shape shape, int depth) {
            this.shape = shape;
            this.depth = depth;
        }
    }
}

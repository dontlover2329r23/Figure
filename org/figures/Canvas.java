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

    private static class ShapeWithDepth {
        Shape shape;
        int depth;

        ShapeWithDepth(Shape shape, int depth) {
            this.shape = shape;
            this.depth = depth;
        }
    }

}


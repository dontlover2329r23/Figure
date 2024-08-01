package org.figures;

public class Circle extends Shape {
    private Point center;
    private int radius;
    private Rectangle rect;

    public Circle(Point center, int radius) throws Exception {
        if (!isValidCircle(radius)) {
            throw new Exception("Invalid radius! Radius must be greater than zero.");
        }
        this.center = center;
        this.radius = radius;
        calculateBoundingRectangle(center, radius);
    }

    private void calculateBoundingRectangle(Point center, int radius) throws Exception {
        int minX = center.getX() - radius;
        int minY = center.getY() - radius;
        int maxX = center.getX() + radius;
        int maxY = center.getY() + radius;

        Point topLeft = new Point(minX, minY);
        Point bottomRight = new Point(maxX, maxY);

        this.rect = new Rectangle(topLeft, bottomRight);
    }

    private boolean isValidCircle(int radius) {
        return radius > 0;
    }

    @Override
    public void moveX(int xPoint) throws Exception {
        int initialX = center.getX();
        try {
            center.moveX(xPoint);
            calculateBoundingRectangle(center, radius);
        } catch (Exception e) {
            center.setX(initialX);
            throw e;
        }
    }

    @Override
    public void moveY(int yPoint) throws Exception {
        int initialY = center.getY();
        try {
            center.moveY(yPoint);
            calculateBoundingRectangle(center, radius);
        } catch (Exception e) {
            center.setY(initialY);
            throw e;
        }
    }

    @Override
    public void move(int xPoint, int yPoint) throws Exception {
        int initialX = center.getX();
        int initialY = center.getY();
        try {
            center.moveX(xPoint);
            center.moveY(yPoint);
            calculateBoundingRectangle(center, radius);
        } catch (Exception e) {
            center.setX(initialX);
            center.setY(initialY);
            throw e;
        }
    }

    @Override
    public String toString() {
        return "Circle{" + "center=" + center + ", radius=" + radius + '}';
    }

    @Override
    public Circle clone() throws CloneNotSupportedException {
        Circle newCircle = (Circle) super.clone();
        newCircle.center = (Point) center.clone();
        newCircle.radius = radius;
        return newCircle;
    }



    @Override
    public boolean overlaps(Shape other) {
        if (other instanceof Rectangle) {
            Rectangle r = (Rectangle) other;
            return rect.overlaps(r);
        } else if (other instanceof Circle) {
            Circle c = (Circle) other;
            return rect.overlaps(c.rect);
        } else if (other instanceof Triangle) {
            Triangle t = (Triangle) other;
            return rect.overlaps(t.getBoundingRectangle());
        }
        return false;
    }

    public Rectangle getBoundingRectangle() {
        return rect;
    }
}

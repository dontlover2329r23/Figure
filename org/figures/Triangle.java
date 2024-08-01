package org.figures;

public class Triangle extends Shape {
    private Point p1;
    private Point p2;
    private Point p3;
    private Rectangle rect;

    public Triangle(Point p1, Point p2, Point p3) throws Exception {
        if (!isValidTriangle(p1, p2, p3)) {
            throw new Exception("Points do not form a valid triangle!");
        }
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        calculateRect(p1, p2, p3);
    }

    private void calculateRect(Point p1, Point p2, Point p3) throws Exception {
        int minX = Math.min(Math.min(p1.getX(), p2.getX()), p3.getX());
        int minY = Math.min(Math.min(p1.getY(), p2.getY()), p3.getY());
        int maxX = Math.max(Math.max(p1.getX(), p2.getX()), p3.getX());
        int maxY = Math.max(Math.max(p1.getY(), p2.getY()), p3.getY());

        Point topLeft = new Point(minX, minY);
        Point bottomRight = new Point(maxX, maxY);

        this.rect = new Rectangle(topLeft, bottomRight);
    }

    private boolean isValidTriangle(Point p1, Point p2, Point p3) {
        int area = p1.getX() * (p2.getY() - p3.getY()) +
                p2.getX() * (p3.getY() - p1.getY()) +
                p3.getX() * (p1.getY() - p2.getY());
        return area != 0;
    }

    @Override
    public void move(int xPoint, int yPoint) throws Exception {
        moveX(xPoint);
        moveY(yPoint);
    }

    @Override
    public void moveX(int xPoint) throws Exception {
        int initialP1X = p1.getX();
        int initialP2X = p2.getX();
        int initialP3X = p3.getX();
        try {
            p1.moveX(xPoint);
            p2.moveX(xPoint);
            p3.moveX(xPoint);
            calculateRect(p1, p2, p3);
        } catch (Exception e) {
            p1.setX(initialP1X);
            p2.setX(initialP2X);
            p3.setX(initialP3X);
            throw e;
        }
    }

    @Override
    public void moveY(int yPoint) throws Exception {
        int initialP1Y = p1.getY();
        int initialP2Y = p2.getY();
        int initialP3Y = p3.getY();
        try {
            p1.moveY(yPoint);
            p2.moveY(yPoint);
            p3.moveY(yPoint);
            calculateRect(p1, p2, p3);
        } catch (Exception e) {
            p1.setY(initialP1Y);
            p2.setY(initialP2Y);
            p3.setY(initialP3Y);
            throw e;
        }
    }

    @Override
    public String toString() {
        return "Triangle{" + "p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + '}';
    }

    public Triangle clone() throws CloneNotSupportedException {
        Triangle newTria = (Triangle) super.clone();
        newTria.p1 = (Point) p1.clone();
        newTria.p2 = (Point) p2.clone();
        newTria.p3 = (Point) p3.clone();
        return newTria;
    }

    @Override
    public boolean overlaps(Shape other) {
        if (other instanceof Rectangle) {
            Rectangle r = (Rectangle) other;
            return rect.overlaps(r);
        } else if (other instanceof Triangle) {
            Triangle t = (Triangle) other;
            return rect.overlaps(t.rect);
        } else if (other instanceof Circle) {
            Circle c = (Circle) other;
            return rect.overlaps(c.getBoundingRectangle());
        }
        return false;
    }

    public Rectangle getBoundingRectangle() {
        return rect;
    }
}

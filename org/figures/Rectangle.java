package org.figures;

public class Rectangle extends Shape implements Move {
    private Point topLeft;
    private Point bottomRight;
    final Rectangle rect=null;

    public Rectangle(Point topLeft, Point bottomRight) throws Exception {
        if (!isValidRectangle(topLeft, bottomRight)) {
            throw new Exception("Points do not form a valid rectangle!");
        }
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    private boolean isValidRectangle(Point topLeft, Point bottomRight) {
        return topLeft.getX() != bottomRight.getX() && topLeft.getY() != bottomRight.getY();
    }

    @Override
    public void move(int xPoint, int yPoint) throws Exception {
        moveX(xPoint);
        moveY(yPoint);
    }

    @Override
    public void moveX(int xPoint) throws Exception {
        int initialTopLeftX = topLeft.getX();
        int initialBottomRightX = bottomRight.getX();
        try {
            topLeft.moveX(xPoint);
            bottomRight.moveX(xPoint);
        } catch (Exception e) {
            topLeft.setX(initialTopLeftX);
            bottomRight.setX(initialBottomRightX);
            throw e;
        }
    }

    @Override
    public void moveY(int yPoint) throws Exception {
        int initialTopLeftY = topLeft.getY();
        int initialBottomRightY = bottomRight.getY();
        try {
            topLeft.moveY(yPoint);
            bottomRight.moveY(yPoint);
        } catch (Exception e) {
            topLeft.setY(initialTopLeftY);
            bottomRight.setY(initialBottomRightY);
            throw e;
        }
    }

    @Override
    public String toString() {
        return "Rectangle{" + "topLeft=" + topLeft + ", bottomRight=" + bottomRight + '}';
    }

    public Rectangle clone() throws CloneNotSupportedException {
        Rectangle newRect = (Rectangle) super.clone();
        newRect.topLeft = (Point) topLeft.clone();
        newRect.bottomRight = (Point) bottomRight.clone();
        return newRect;
    }

    @Override
    public boolean overlaps(Shape other) {
        if (other instanceof Rectangle) {
            Rectangle r = (Rectangle) other;
            return !(this.bottomRight.getX() < r.topLeft.getX() || this.topLeft.getX() > r.bottomRight.getX()
                    || this.bottomRight.getY() < r.topLeft.getY() || this.topLeft.getY() > r.bottomRight.getY());
        }

        return false;
    }
}

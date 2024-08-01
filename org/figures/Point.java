package org.figures;

public class Point implements Move,Cloneable {
    private int x=0;
    private int y=0;

    public Point(int x, int y) throws Exception {
        move(x,y);

    }
    public Point clone() throws CloneNotSupportedException{

        return (Point) super.clone();
    }
    public Point() {
        this.x = 0;
        this.y = 0;
    }


    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }




    public int getY() {
        return y;
    }



    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
    @Override
    public void moveX(int xPoint) throws Exception{
        if(x+xPoint<0){
            throw new Exception("X не может быть меньше 0");
        }
        x=x+xPoint;
    }
    @Override
    public void moveY(int yPoint)throws Exception {
        if(y+yPoint<0){
            throw new Exception("Y не может быть меньше 0");
        }
        y=y+yPoint;
    }
    @Override
    public void move(int xPoint, int yPoint)throws Exception {
        moveX(xPoint);
        moveY(yPoint);

    }
}

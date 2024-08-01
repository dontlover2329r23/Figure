package org.figures;

public abstract class Shape implements Move,Cloneable {
    protected Rectangle rect;

        protected int depth = 0;

        public abstract void move(int xPoint, int yPoint) throws Exception;
        public int getDepth() {
            return depth;
        }
        public void setDepth(int depth) {
            this.depth = depth;
        }

        public abstract boolean overlaps(Shape other);


}

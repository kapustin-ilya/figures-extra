package com.epam.rd.autotasks.figures;

class Triangle extends Figure{
    Point a;
    Point b;
    Point c;
    double ab;
    double ac;
    double bc;

    public Triangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null) throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
        this.c = c;
        ab = Math.sqrt((a.getX()- b.getX())*(a.getX()- b.getX())+(a.getY()- b.getY())*(a.getY()- b.getY()));
        ac = Math.sqrt((a.getX()- c.getX())*(a.getX()- c.getX())+(a.getY()- c.getY())*(a.getY()- c.getY()));
        bc = Math.sqrt((c.getX()- b.getX())*(c.getX()- b.getX())+(c.getY()- b.getY())*(c.getY()- b.getY()));
        if ((ab+ac) - bc <= 0.000001 && (ab+bc) - ac <= 0.000001 && (ac+bc) - ab <= 0.000001) throw new IllegalArgumentException();
        if (this.area() <= 0.000001) throw new IllegalArgumentException();

    }

    public double area() {
        double s = (ab+ac+bc)/2;
        return Math.sqrt(s*(s-ab)*(s-bc)*(s-ac));
    }

    @Override
    public Point centroid() {
        Point pointA = new Point((b.getX()+c.getX())/2,(b.getY()+c.getY())/2);
        Point pointB = new Point((a.getX()+c.getX())/2,(a.getY()+c.getY())/2);

        double x1 = a.getX(); double y1 = a.getY();
        double x2 = pointA.getX(); double y2 = pointA.getY();
        double x3 = b.getX(); double y3 = b.getY();
        double x4 = pointB.getX(); double y4 = pointB.getY();

        double d = ((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
        if (d == 0) return null;

        double t = ((x1-x3)*(y3-y4)-(y1-y3)*(x3-x4))/d;
        double u = ((x1-x3)*(y1-y2)-(y1-y3)*(x1-x2))/d;
        if (!(t >= 0.0 && t <= 1.0 && u >= 0.0 && u <= 1.0)) return null;

        double x = x1 + t * (x2-x1);
        double y = y1 + t * (y2-y1);


        Point point = new Point(x,y);

        return point;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return false;
    }
}

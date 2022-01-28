package com.epam.rd.autotasks.figures;

import static java.lang.Double.NaN;
import static java.lang.Double.isNaN;

class Quadrilateral extends Figure{
    Point a;
    Point b;
    Point c;
    Point d;
    double ab;
    double bc;
    double cd;
    double da;
    double ac;
    double bd;
    public Quadrilateral(Point a, Point b, Point c, Point d) {
        if (a == null || b == null || c == null || d == null) throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

        double x1 = a.getX(); double y1 = a.getY();
        double x2 = b.getX(); double y2 = b.getY();
        double x3 = c.getX(); double y3 = c.getY();
        double x4 = d.getX(); double y4 = d.getY();
        double d1 = ((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
        if (d1 != 0) {

            double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / d1;
            double u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / d1;
            if ((t >= 0.0 && t <= 1.0 && u >= 0.0 && u <= 1.0)) throw new IllegalArgumentException();

            double x = x1 + t * (x2 - x1);
            double y = y1 + t * (y2 - y1);

            Point point = new Point(x, y);
        }

         x1 = a.getX();  y1 = a.getY();
         x2 = d.getX();  y2 = d.getY();
         x3 = c.getX();  y3 = c.getY();
         x4 = b.getX();  y4 = b.getY();
         d1 = ((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
        if (d1 != 0) {

            double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / d1;
            double u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / d1;
            if ((t >= 0.0 && t <= 1.0 && u >= 0.0 && u <= 1.0)) throw new IllegalArgumentException();

            double x = x1 + t * (x2 - x1);
            double y = y1 + t * (y2 - y1);

            Point point = new Point(x, y);
        }


        ab = Math.sqrt((a.getX()- b.getX())*(a.getX()- b.getX())+(a.getY()- b.getY())*(a.getY()- b.getY()));
        bc = Math.sqrt((c.getX()- b.getX())*(c.getX()- b.getX())+(c.getY()- b.getY())*(c.getY()- b.getY()));
        cd = Math.sqrt((d.getX()- c.getX())*(d.getX()- c.getX())+(d.getY()- c.getY())*(d.getY()- c.getY()));
        da = Math.sqrt((a.getX()- d.getX())*(a.getX()- d.getX())+(a.getY()- d.getY())*(a.getY()- d.getY()));

        ac = Math.sqrt((a.getX()- c.getX())*(a.getX()- c.getX())+(a.getY()- c.getY())*(a.getY()- c.getY()));
        bd = Math.sqrt((b.getX()- d.getX())*(b.getX()- d.getX())+(b.getY()- d.getY())*(b.getY()- d.getY()));

        double s1 = (ab+bc+ac)/2;
        double s2 = (ac+cd+da)/2;

        double temp1 = Math.sqrt(s1*(s1-ab)*(s1-bc)*(s1-ac))+Math.sqrt(s2*(s2-ac)*(s2-cd)*(s2-da));

        double s3 = (ab+bd+da)/2;
        double s4 = (bc+cd+bd)/2;
        double temp2 = Math.sqrt(s3*(s3-ab)*(s3-bd)*(s3-da))+Math.sqrt(s4*(s4-bc)*(s4-cd)*(s4-bd));
        if (Math.abs(s1-ab) <= 0.00001 || Math.abs(s1-bc) <= 0.00001 || Math.abs(s1-ac) <= 0.00001 || Math.abs(s2-ac) <= 0.00001 || Math.abs(s2-cd) <= 0.00001 || Math.abs(s2-da) <= 0.00001) throw new IllegalArgumentException();
        if (Math.abs(s3-ab) <= 0.00001 || Math.abs(s3-bd) <= 0.00001 || Math.abs(s3-da) <= 0.00001 || Math.abs(s4-bc) <= 0.00001 || Math.abs(s4-cd) <= 0.00001 || Math.abs(s4-bd) <= 0.00001) throw new IllegalArgumentException();

        if (temp2-temp1 >= 0.00001 || isNaN(temp2) || isNaN(temp1) )
            throw new IllegalArgumentException();

    }


    public double area() {
        double s1 = (ab+ac+bc)/2;
        double s2 = (ac+cd+da)/2;
        return (Math.sqrt(s1*(s1-ab)*(s1-bc)*(s1-ac))+Math.sqrt(s2*(s2-ac)*(s2-cd)*(s2-da)));
    }


    @Override
    public Point centroid() {
        Point pointA = new Point((b.getX()+c.getX())/2,(b.getY()+c.getY())/2);
        Point pointC = new Point((b.getX()+a.getX())/2,(b.getY()+a.getY())/2);

        double x1 = a.getX(); double y1 = a.getY();
        double x2 = pointA.getX(); double y2 = pointA.getY();
        double x3 = c.getX(); double y3 = c.getY();
        double x4 = pointC.getX(); double y4 = pointC.getY();

        double d1 = ((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
        if (d1 == 0) return null;

        double t = ((x1-x3)*(y3-y4)-(y1-y3)*(x3-x4))/d1;
        double u = ((x1-x3)*(y1-y2)-(y1-y3)*(x1-x2))/d1;
        if (!(t >= 0.0 && t <= 1.0 && u >= 0.0 && u <= 1.0)) return null;

        double x = x1 + t * (x2-x1);
        double y = y1 + t * (y2-y1);

        Point point1 = new Point(x,y);

        pointA = new Point((d.getX()+c.getX())/2,(d.getY()+c.getY())/2);
        pointC = new Point((d.getX()+a.getX())/2,(d.getY()+a.getY())/2);

        x1 = a.getX();  y1 = a.getY();
        x2 = pointA.getX();  y2 = pointA.getY();
        x3 = c.getX();  y3 = c.getY();
        x4 = pointC.getX();  y4 = pointC.getY();

         d1 = ((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
        if (d1 == 0) return null;

         t = ((x1-x3)*(y3-y4)-(y1-y3)*(x3-x4))/d1;
         u = ((x1-x3)*(y1-y2)-(y1-y3)*(x1-x2))/d1;
        if (!(t >= 0.0 && t <= 1.0 && u >= 0.0 && u <= 1.0)) return null;

         x = x1 + t * (x2-x1);
         y = y1 + t * (y2-y1);

        Point point2 = new Point(x,y);

        Point pointB = new Point((a.getX()+d.getX())/2,(a.getY()+d.getY())/2);
        Point pointD = new Point((a.getX()+b.getX())/2,(a.getY()+b.getY())/2);

        x1 = b.getX();  y1 = b.getY();
        x2 = pointB.getX();  y2 = pointB.getY();
        x3 = d.getX();  y3 = d.getY();
        x4 = pointD.getX();  y4 = pointD.getY();

        d1 = ((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
        if (d1 == 0) return null;

        t = ((x1-x3)*(y3-y4)-(y1-y3)*(x3-x4))/d1;
        u = ((x1-x3)*(y1-y2)-(y1-y3)*(x1-x2))/d1;
        if (!(t >= 0.0 && t <= 1.0 && u >= 0.0 && u <= 1.0)) return null;

        x = x1 + t * (x2-x1);
        y = y1 + t * (y2-y1);

        Point point3 = new Point(x,y);

        pointB = new Point((c.getX()+d.getX())/2,(c.getY()+d.getY())/2);
        pointD = new Point((c.getX()+b.getX())/2,(c.getY()+b.getY())/2);

        x1 = b.getX();  y1 = b.getY();
        x2 = pointB.getX();  y2 = pointB.getY();
        x3 = d.getX();  y3 = d.getY();
        x4 = pointD.getX();  y4 = pointD.getY();

        d1 = ((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
        if (d1 == 0) return null;

        t = ((x1-x3)*(y3-y4)-(y1-y3)*(x3-x4))/d1;
        u = ((x1-x3)*(y1-y2)-(y1-y3)*(x1-x2))/d1;
        if (!(t >= 0.0 && t <= 1.0 && u >= 0.0 && u <= 1.0)) return null;

        x = x1 + t * (x2-x1);
        y = y1 + t * (y2-y1);

        Point point4 = new Point(x,y);


        x1 = point1.getX();  y1 = point1.getY();
        x2 = point2.getX();  y2 = point2.getY();
        x3 = point3.getX();  y3 = point3.getY();
        x4 = point4.getX();  y4 = point4.getY();

        d1 = ((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
        if (d1 == 0) return null;

        t = ((x1-x3)*(y3-y4)-(y1-y3)*(x3-x4))/d1;
        u = ((x1-x3)*(y1-y2)-(y1-y3)*(x1-x2))/d1;
        if (!(t >= 0.0 && t <= 1.0 && u >= 0.0 && u <= 1.0)) return null;

        x = x1 + t * (x2-x1);
        y = y1 + t * (y2-y1);

        return new Point(x,y);
    }
    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null) return false;
        if (figure == this) return true;
        if (figure instanceof Quadrilateral) {
            if (a.isTheSame(((Quadrilateral)figure).a) || a.isTheSame(((Quadrilateral)figure).b) || a.isTheSame(((Quadrilateral)figure).c) || a.isTheSame(((Quadrilateral)figure).d)){
                if (b.isTheSame(((Quadrilateral)figure).a) || b.isTheSame(((Quadrilateral)figure).b) || b.isTheSame(((Quadrilateral)figure).c) || b.isTheSame(((Quadrilateral)figure).d)){
                    if (c.isTheSame(((Quadrilateral)figure).a) || c.isTheSame(((Quadrilateral)figure).b) || c.isTheSame(((Quadrilateral)figure).c) || c.isTheSame(((Quadrilateral)figure).d)){
                        if (d.isTheSame(((Quadrilateral)figure).a) || d.isTheSame(((Quadrilateral)figure).b) || d.isTheSame(((Quadrilateral)figure).c) || d.isTheSame(((Quadrilateral)figure).d)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;

    }
}

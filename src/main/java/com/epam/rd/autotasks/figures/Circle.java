package com.epam.rd.autotasks.figures;

class Circle extends Figure{
    Point a;
    double radius;
    public Circle(Point a, double radius) {
        if (a == null) throw new IllegalArgumentException();
        this.a = a;
        this.radius = radius;
        if (radius <= 0) throw new IllegalArgumentException();
    }
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public Point centroid() {
        return a;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null) return false;
        if (figure == this) return true;
        if (figure instanceof Circle) {
            if (this.a.isTheSame(((Circle) figure).a) && this.a.isTheSame(((Circle) figure).a) && Math.abs(((Circle) figure).radius - this.radius) <= 0.0001) return true;
        }
        return false;
    }
}

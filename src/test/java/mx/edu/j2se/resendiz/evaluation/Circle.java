package mx.edu.j2se.resendiz.evaluation;

public class Circle {
    //Attributes
    private double radius;

    //Constructor
    public Circle(){
        this.radius = 1;
    }

    public Circle(double radius){
        if (radius <= 0)
            throw new IllegalArgumentException();
        this.radius = radius;
    }

    //Methods
    public void setRadius(double radius){
        if (radius <= 0)
            throw new IllegalArgumentException();
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }

    public double getArea(){
        return Math.PI*radius*radius;
    }
}

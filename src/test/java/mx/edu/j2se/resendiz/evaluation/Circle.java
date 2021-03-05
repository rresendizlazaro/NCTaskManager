package mx.edu.j2se.resendiz.evaluation;

public class Circle {
    //Attributes
    private double radius;

    //Constructor
    public Circle(){
        this.radius = 1;
    }

    public Circle(double radius){
        try{
            if (radius <= 0) {
                throw new IllegalArgumentException();
            }else{
                this.radius = radius;
            }
        }catch (Exception e){
            System.out.println("The value is invalid, try another");
        }
    }

    //Methods
    public void setRadius(double radius){
        try{
            if (radius <= 0) {
                throw new IllegalArgumentException();
            }else{
                this.radius = radius;
            }
        }catch (Exception e){
            System.out.println("The value is invalid, try another");
        }
    }

    public double getRadius(){
        return this.radius;
    }

    public double getArea(){
        return Math.PI*radius*radius;
    }
}

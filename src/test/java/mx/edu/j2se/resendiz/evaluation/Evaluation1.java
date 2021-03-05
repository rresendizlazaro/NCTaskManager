package mx.edu.j2se.resendiz.evaluation;

import java.lang.reflect.Array;

public class Evaluation1 {
    public static void main(String[] args) {
        //Creating an invalid circle...
        Circle circle1 = new Circle(-5);

        //Like the song
        Circle circlesPM[] = new Circle[3];
        circlesPM[0] = new Circle();
        circlesPM[1] = new Circle(10);
        circlesPM[2] = new Circle(100);

        System.out.println(circlesPM[(int)biggestCircle(circlesPM)].getRadius());
    }

    public static double biggestCircle(Circle circles[]){
        Circle currentCircle = new Circle(1);
        double index = 0;
        for (int i = 0; i < circles.length; i++){
            if(currentCircle.getRadius() < circles[i].getRadius()){
                index = i;
                currentCircle = circles[i];
            }
        }
        return index;
    }
}

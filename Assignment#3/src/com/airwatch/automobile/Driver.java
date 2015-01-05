package com.airwatch.automobile;

/**
 * Created by ABhat on 12 Aug 2014 - 12/08/14.
 */
public class Driver {
    public static void main(String[] args) {
//The commented code can't be run in IntelliJ

        Bike b = new Bike();
        Car c = new Car();
        System.out.println(c instanceof Car);//true
        //System.out.println(c instanceof Bike); //simplified by IntelliJ to false as inconvertible types
        //System.out.println(c instanceof TwoWheeler);  //simplified by IntelliJ to false as inconvertible types
        System.out.println(c instanceof FourWheeler);//true
        System.out.println(c instanceof Automobile);//true
        System.out.println(c.getClass().isAssignableFrom(Car.class));//true
        System.out.println(c.getClass().isAssignableFrom(Bike.class));//false
        //System.out.println(AutoMobile.class.isAssignableFrom(FourWheeler.class));
        //System.out.println(AutoMobile.class.isAssignableFrom(Car.class));
        System.out.println(FourWheeler.class.isAssignableFrom(Car.class));//true

    }
}

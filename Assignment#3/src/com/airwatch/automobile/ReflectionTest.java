package com.airwatch.automobile;

import java.lang.reflect.Method;

/**
 * Created by ABhat on 14 Aug 2014 - 14/08/14.
 */
public class ReflectionTest {

    public static void main(String[] args) {
        Method[] automobileMethods = Car.class.getMethods();
        for (Method method : automobileMethods)
        {
            System.out.println(method.getName());
        }
    }
}

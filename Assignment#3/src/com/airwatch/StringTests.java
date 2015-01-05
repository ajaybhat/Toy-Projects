package com.airwatch;

/**
 * Created by ABhat on 12 Aug 2014 - 12/08/14.
 */
public class StringTests {
    public static void main(String[] args) {
        String s1 = new String("XYZ"),s2 = new String("XYZ");
        String s3 = "ABC",s4 = "ABC";

        System.out.println(s1 == s2); //false
        System.out.println(s1.equals(s2)); //true
        System.out.println(s3 == s4); //true
        System.out.println(s3.equals(s4)); //true
    }

}

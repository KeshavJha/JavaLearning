package javaExamples;

import java.io.IOException;

public class CentimetersToInches {
  public static void main(String[] args) throws IOException {
    double centimeters ;
    System.out.println("Enter the value to convert");
    // @TODO How to read input entered here ??? Need to really understand the input and output stream and buffers this time
    centimeters = System.in.read( );
    System.out.println("Value in inches would be : " + (centimeters / 2.54) );
    System.out.println(System.getProperties());
  }
}

// @TODO Write a test class for this class ...
// Will need to test boundary conversions ... should negative numbers be converted , what is the max value conversion possible .
// What other tests should I try ???

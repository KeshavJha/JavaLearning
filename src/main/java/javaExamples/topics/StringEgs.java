package javaExamples.topics;

import java.util.StringTokenizer;

public class StringEgs {
    public static void main(String[] args) {
        // usingStringBuilder();
        usingStringTokenizer();
//        usingStringTokenizerDefaultDelim();
    }

    public static void usingStringBuilder() {
        StringBuilder strBld = new StringBuilder();
        strBld.append("hello");
        System.out.println(strBld.toString());
    }

    public static void usingStringTokenizer() {
        StringTokenizer strToken = new StringTokenizer("What is new in Java 11 from Java 8", "t", true);

        System.out.println(strToken.countTokens());
        while(strToken.hasMoreTokens()) {
            System.out.println(strToken.nextToken());
        }
        System.out.println(strToken.countTokens());
    }

    public static void usingStringTokenizerDefaultDelim() {
        StringTokenizer strToken = new StringTokenizer("What is     new in Java 11 from Java 8");
        while(strToken.hasMoreTokens()) {
            System.out.println(strToken.nextToken());
        }
    }
}

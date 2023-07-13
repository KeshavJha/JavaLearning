package javaExamples.topics.lambdasNstreams;

import java.util.function.*;

public class LambdasEgs {
    // Try using method reference with multiple arguments ... possible ???
    public static void main(String[] args) {
        System.out.println(moreThan10.test(5));
        System.out.println(moreThan10.test(11));
//        printIt.accept(moreThan10.test(12));

        System.out.println(length5OrMore.test("hello"));
        System.out.println(length5OrMore.test("zero"));

        System.out.println(lengthOfString.apply("hello world"));

        printIt.accept("hello ji");
        printInt.accept(lengthOfString.apply("Testing this sting"));

        printDouble.accept(randomFloat.get());

        helloWorld.run();

//        assert(1==1);

    }
    static Predicate<Integer> moreThan10 = value -> value > 10;
    static Predicate<String> length5OrMore = str -> str.length() >= 5;

//    static Function<String, Integer> lengthOfString = str -> str.length(); // Use method reference String::length
    static Function<String, Integer> lengthOfString = String::length;

//    static Consumer<String> printIt = str -> System.out.println(str); // Using method reference printIt = System.out::println
    static Consumer<String> printIt = System.out::println;
    static Consumer<Integer> printInt = str -> System.out.println(str);
    static Consumer<Double> printDouble = str -> System.out.println(str);

    static Supplier<Double> randomFloat = () -> Math.random();
    static IntSupplier randomInt = () -> randomFloat.get().intValue();

    static Runnable helloWorld = () -> System.out.println("Hello from new Thread");
}

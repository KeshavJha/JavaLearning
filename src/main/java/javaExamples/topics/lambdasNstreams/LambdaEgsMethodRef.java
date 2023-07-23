package javaExamples.topics.lambdasNstreams;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaEgsMethodRef<C,T> {
    public static void main(String[] args) {
        LambdasEgs.printIt.accept(mergeString.apply("any ", "two"));

        peekingAndForEachOnCharacter("our lamdba world starts here");
        characterCountInString("our lamdba world starts here");

        peekingAndForEachOnCharacter("our different lamdba never world starts here");
        characterCountInString("our different lamdba never world starts here");

    }

    private void checkSupplierForBiFunction() {

//        BiFunction<Stream<T>, Supplier<C>, List<T>> generateValues = (x, y) -> y.add(x); // @Check : Can we have a Function of Supplier to Consumer ???
        // or a BiFunction of Supplier, Supplier .... basically can one type of function have types of other function ?

        LambdaEgsMethodRef<List<Integer>, Integer> l1 = new LambdaEgsMethodRef<>();
        l1.checkSupplierForBiFunction();
        Set<Integer> ints = new HashSet<>();

    }

    private static void peekingAndForEachOnCharacter(String str) {
        long characters = str.chars().map(c -> (char) c).peek(x -> System.out.println(x)).count(); // @Note : peek() does not print here , as it is lazy ... but despite count() ?? how to make it print
//        long characters = str.chars().map(c -> (char) c).peek(x -> System.out.println(x)).sorted().collect(Collectors.toCollection(ArrayList::new));  // @TODO why is collect() not worknig with any of the collectors here ?
// Answer -- An implementation may choose to not execute the stream pipeline (either sequentially or in parallel) 
//if it is capable of computing the count directly from the stream source.
//In such cases no source elements will be traversed and no intermediate operations will be evaluated.
// To make it work -- use filter or other operations that changes the stream length from to make it work with count() , else to make just peek() work , instead of count() use other terminal operations.
// Refer -- https://www.concretepage.com/java/java-8/java-stream-peek , https://mkyong.com/java8/java-8-stream-the-peek-is-not-working-with-count/
//        str.chars().map(c -> (char) c).forEach(x -> System.out.println((char) x)); // forEach print works
        System.out.println(characters);
    }

    private static void characterCountInString(String str) {
        HashMap<Character,Integer> map= str.chars().filter(x -> x != ' ').collect(HashMap::new, (hashMap, value) -> hashMap.put((char)value,hashMap.containsKey((char)value) ? hashMap.get((char)value) + 1 : 1), (hashMap, hashMap2) -> hashMap.putAll(hashMap2));
        System.out.println(map.entrySet());
    }

    private static BinaryOperator<String> mergeString = (x,y) -> x.toUpperCase().concat(y.toLowerCase());//String::concat;
}

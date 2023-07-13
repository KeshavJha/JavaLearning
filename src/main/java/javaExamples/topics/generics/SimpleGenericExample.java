package javaExamples.topics.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SimpleGenericExample {
    public static void main(String[] args) {
//        forEachUsingIterator();
//        forEachUsingIteratorConcurrentModifcation();
        genericExamples();
    }
    public static void forEachUsingIterator() {
        List<Integer> sampleList = Arrays.asList(100, 101, 102, 103, 104);
        for(Iterator<Integer> iterator = sampleList.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
    public static void forEachUsingIteratorConcurrentModifcation() {
        List<Integer> sampleList = Arrays.asList(100, 101, 102, 103, 104);
        for(Iterator<Integer> iterator = sampleList.iterator(); iterator.hasNext(); ) {
            int value = iterator.next();
            System.out.println(value);
            if(value == 104) {
                iterator.remove();
            }
        }
    }

    public static <T> void genericExamples() {
        /**
         * 1) Not allowed to assign ArrayList of Integer to List of Object / Number
         *          * Subtyping is for collection only , NOT the data type of collection variable
         *    For same data type it is allowed to add / get / remove all its subtype values though
         */
        // List<Object> objs = new ArrayList<Integer>();
        List<Number> numbersList = new ArrayList<>();
        numbersList.add(12);
        numbersList.add(3.4);

        /**
         * 2) It is okay to add values to collection with 'super' wildcard
         *          * All Subtypes of 'super'ed type can be added
         *    Values can also be fetched and removed for 'super' wildcard
         */
        List<? super Number> superNumbersList = new ArrayList<>();
        superNumbersList.add(Integer.valueOf(34));
        superNumbersList.add(Double.valueOf(3.4));
        System.out.println(superNumbersList.get(0));
        System.out.println(superNumbersList.get(superNumbersList.size() - 1));
        System.out.println(superNumbersList.remove(0));

        /**
         * 3) Not allowed to add values to collection with 'extends' wildcard
         *          * Null value is an exception.
         *    Values can be fetched and removed though.
         */
        List<? extends Number> numbersExtended = new ArrayList<>();
//        numbersExtended.add(Integer.valueOf(34));
//        numbersExtended.add(Double.valueOf(3.4));
        numbersExtended.add(null);
        numbersExtended.get(0);
        numbersExtended.remove(0);

        /**
         * 4) integer and double list can be passed as parameters to functions that use '? extends Number' argument
         *          * We can't use addAll on a list of '? extends Number' type.
         */
        List<Integer> integerList = Arrays.asList(1,2);
        List<Double> doublesList = List.of(3.4, 5.6);
//        numbersExtended.addAll(integerList);
        numbersList.addAll(integerList);
        numbersList.addAll(doublesList);
    }

    public static void comparablesExamples() {
//        Compara
    }
}

class SuperClass {}
//class SubClass1 extends SuperClass implements Comparable<? extends SubClass1> {
//    @Override
//    public int compareTo(SubClass1 subClass1) {
//        return 0;
//    }
//}
//class SubClass2<T> extends SuperClass implements Comparable<T extends SubClass2> {
//
//    @Override
//    public int compareTo(T t) {
//        return 0;
//    }
//}
//class Subclass3 extends SuperClass implements Comparable<SubClass1> , Comparable<SubClass2> , Comparable<Subclass3>, Comparable<SuperClass> {
//
//    @Override
//    public int compareTo(SuperClass superClass) {
//        return 0;
//    }
//}

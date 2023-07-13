package javaExamples.topics.collections;

import javaExamples.topics.ExampleUtils;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

public class SetEgs {
    public static void main(String[] args) {
//        navigatingTreeSet();
//        differentImplementations();
        navigableSetFunctions();
    }
    public static void SetExample() {
        Map<Integer, String> intToStrMap = new TreeMap<>();
        Set<String> intToStrSet = new TreeSet<>();
    }
    public static void navigatingTreeSet() {
        ExampleUtils.printHeader("Verifying ordering of elements in a TreeSet");
        NavigableSet<String> treeSetStrings = new TreeSet<>();
        treeSetStrings.add("hello");
        treeSetStrings.add("world");
        treeSetStrings.add("i");
        treeSetStrings.add("am");
        treeSetStrings.add("here");

        System.out.println(treeSetStrings.toString());
    }
    public static void differentImplementations() {
        Set<String> hashSet = new HashSet<>(12);
        Set<String> linkedHashSet = new LinkedHashSet<>(12);
        Set<String> treeSet = new TreeSet<>();

        linkedHashSet.add("a");linkedHashSet.add("d");linkedHashSet.add("c");linkedHashSet.add("b");linkedHashSet.add("e");
        System.out.println("\n\tList of elements in LinkedHashSet ");
        linkedHashSet.forEach(x -> System.out.println(x));

        hashSet.add("a");hashSet.add("d");hashSet.add("c");hashSet.add("b");hashSet.add("e");
        Collections.addAll(hashSet,"x","y","z","u","v","w","s","t","u");
        System.out.println("\n\tList of elements in HashSet ");
        hashSet.stream().peek(x -> System.out.println(x)).collect(Collectors.toList());

        Collections.addAll(treeSet, "a", "d", "c", "e", "b");
        Collections.addAll(treeSet,"x","y","z","u","v","w","s","t","u");
        ExampleUtils.printHeader("List of elements in TreeSet");
        treeSet.forEach(x -> System.out.println(x));
    }

    public static void navigableSetFunctions() {
        NavigableSet<String> navSet = new ConcurrentSkipListSet<>();
        Collections.addAll(navSet,"x","y","z","u","v","w","s","t","u");
        Collections.addAll(navSet,"a","c","b","d","f","e","1","2","3");
        System.out.printf("First , last elements of set are %s, %s\n",  navSet.first(), navSet.last());
        System.out.printf("Ceiling and floor for first , last elements of set are %s, %s ; and %s %s\n",  navSet.ceiling(navSet.first()), navSet.floor(navSet.first()), navSet.ceiling(navSet.last()), navSet.floor(navSet.last()));
        System.out.printf("Higher and Lower for first , last elements of set are %s, %s ; and %s %s\n",  navSet.higher(navSet.first()), navSet.lower(navSet.first()), navSet.higher(navSet.last()), navSet.lower(navSet.last()));
        System.out.printf("HeadSet of numbers, TailSet of all chars and Subset( from 2 to d ) %s, %s %s\n",  navSet.headSet("3",true), navSet.tailSet("a", true), navSet.subSet("2",true, "x", true));
//        System.out.printf("Higher and Lower for first , last elements of set are %s, %s ; and %s %s\n",  navSet.higher(navSet.first()), navSet.lower(navSet.first()), navSet.higher(navSet.last()), navSet.lower(navSet.last()));
    }
}

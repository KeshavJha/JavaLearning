package javaExamples.topics.collections;

//import com.google.common.collect.Sets;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ListsEgs {
    List<String> strList = new ArrayList<>();

    public static void main(String[] args) {
//        listOfExample();
//        iteratorOfList();
//        Sets;
//        Collections.
        differentImplementationsOfList();
    }

    private static void listExample() {
        Collection<String> strList1 = new ArrayList<>();
        strList1.add("keshav");
        String s1 = "keshav";
        System.out.println( strList1.contains(new String("keshav")) );
        System.out.println( strList1.contains(s1) );
    }

    private static void listOfExample() {
        Collection<String> strList1 = List.of("listOfExample");
        strList1.addAll(List.of("user1"));
        String s1 = "keshav";
        System.out.println( strList1.contains(new String("keshav")) );
        System.out.println( strList1.contains(s1) );
    }

    public static void iteratorOfList() {
        List<String> employeeNames = new LinkedList<>();
        Iterator<String> strListIterator = employeeNames.iterator();
        employeeNames.add("SuperClass");
        employeeNames.size();
        ListIterator<String> listIterator = employeeNames.listIterator();
        listIterator.hasNext();
    }

    public static void differentImplementationsOfList() {
        List<String> arrLst = new ArrayList<>(12);
        List<String> linkedLst = new LinkedList<>();
        List<String> copyOnWriteLst = new CopyOnWriteArrayList<>();

        linkedLst.add("a");linkedLst.add("d");linkedLst.add("c");linkedLst.add("b");linkedLst.add("e");
        System.out.println("\n\tList of elements in LinkedList ");
        linkedLst.forEach(x -> System.out.println(x));

        arrLst.add("a");arrLst.add("d");arrLst.add("c");arrLst.add("b");arrLst.add("e");
        System.out.println("\n\tList of elements in ArrayList ");
        arrLst.stream().peek(x -> System.out.println(x)).collect(Collectors.toList());
    }

}

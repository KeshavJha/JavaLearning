package javaExamples.topics.collections;

//import com.google.common.collect.Sets;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListsEgs {
    List<String> strList = new ArrayList<>();

    public static void main(String[] args) {
//        listOfExample();
//        iteratorOfList();
//        Sets;
//        Collections.
//        differentImplementationsOfList();
        listIterator();
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

    public static void listIterator() {
        // @Note :: stream.toList() returns an UnmodifiableList , updating that list throw UnsupportedOperationException
//        List<String> itrsComps = Stream.of("s1","s2","s5","s3","s9","s4").sorted().toList();
        // Instead use collect(toList()) as that list can be edited.
        List<String> itrsComps = Stream.of("s1","s2","s5","s3","s9","s4").sorted().collect(Collectors.toList());
        ListIterator<String> lstItr = itrsComps.listIterator();
        int mods = 0;
        while(lstItr.hasNext()) {
            if(mods > 1 && mods%2 == 0) {
                lstItr.remove(); // -- jo last .next() call se return hua tha wahi remove hua.
                // If I keep this uncommented , s1,s3,s5,s9 rahega , kyunki s2 and s4 are last .next() returns at this point.
            }
            System.out.println(lstItr.next());
            System.out.println(lstItr.nextIndex());
//            if(mods > 1 && mods%2 == 0) {
//                lstItr.remove(); // If I keep this uncommented , s1,s2,s4,s9 rahega , kyunki s3 and s5 are last .next() returns at this point.
//            }
            mods++;
        }
        System.out.println(itrsComps);
    }

}

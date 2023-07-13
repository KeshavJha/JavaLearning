package javaExamples.topics.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class CollectionEgs {
    public static void main(String[] args) {
        allCollectionOperations();
    }
    private static void allCollectionOperations() {
        Collection<String> stringCollection1 = new ConcurrentLinkedDeque<>();
        Collection<String> stringCollection2 = new ConcurrentLinkedDeque<>();
        Collection<Integer> integerCollection1 = new ConcurrentLinkedDeque<>();
        stringCollection2.add("dad");
        stringCollection2.add("mom");
        stringCollection2.add("child1");
        stringCollection2.add("child2");
        stringCollection1.addAll(stringCollection2);
//        stringCollection1.addAll(integerCollection1);  -- Causes compile error that Integer can't be added to String collection
        Iterator<String> stringIterator = stringCollection1.iterator();
        String[] strArrayFromCollection = stringCollection2.toArray(new String[0]);
//        String[] strArrayFromCollection2 = (String[]) stringCollection2.toArray();  -- Causes compile error that Object[] can't be cast to String[]
        stringCollection2.remove("dad");
        stringCollection1.retainAll(stringCollection2);
        System.out.println(" strList1 after retaining (after removal of dad from strList2 ) :: " + stringCollection1);
        integerCollection1.clear();
        System.out.println(" strList1 contains all of strList2 :: " + stringCollection1.containsAll(stringCollection2));
        System.out.println(" strList2, itrList1 -- are empty :: " + stringCollection2.isEmpty() + ", " + integerCollection1.isEmpty());
        System.out.println(" size of strList1, strList2, itrList1 :: " + stringCollection1.size() + ", " + stringCollection2.size() + ", " + integerCollection1.size());
        System.out.println(" strList2, itrList1 -- are empty :: " + stringCollection2.isEmpty() + ", " + integerCollection1.isEmpty());

        System.out.println(" strList1 after retaining" + stringCollection1);
        System.out.println(" strList2 after retaining" + stringCollection2);
        System.out.println( "strList2 equals strList1, intList1 :: " + stringCollection2.equals(stringCollection1) + ", " + stringCollection2.equals(integerCollection1));
        // even stringCollection2.equals(stringCollection1) is false when using ConcurrentLinkedDeque , it ArrayList is used comparision will be true
        stringCollection2.removeIf(x -> x.length() < 6);
        System.out.println("\n strList2 after removeIf" + stringCollection2);
        System.out.println( "strList2 equals strList1 after removeIf() :: " + stringCollection2.equals(stringCollection1));
    }

    private static void mergeTwoCollections() {
        Collection<String> strColl = List.of("abc", "def", "hij", "klm", "nop", "xyz");
        Collection<String> strColl2 = List.of("bcd","cde","efg","ghi","tuv");
        Collection<String> strMerged = new ArrayList<>();
        Iterator<String> it1 = strColl.iterator();
        Iterator<String> it2 = strColl2.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            String val1 = it1.next(), val2 = it2.next();
     //       ???   --- This about this algorithm
        }
    }
}

package javaExamples.topics.lambdasNstreams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsEgs {
    public static void main(String[] args) {
//        int option =
        joiningStrings();
    }
    public static void collectingToList() {
        Stream.of(1,2,3,4).collect(Collectors.toList());
        Arrays.asList(1,2,3,4).stream().map(x -> x*x);
        Collections.emptyList().stream().toList();
//        Streams
    }

    public static void joiningStrings()  {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");

        // Following gives error -- becase "of" returns a stream of list . Next line creates a stream of strings from the list
//        Stream.of(strings).collect(Collectors.joining(",", "[", "]"));
        String combined = strings.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(" combined with prefix and suffix :: " + combined);

        System.out.println(" combined to list " + Stream.of(strings).peek(x -> System.out.println("The peeked value from 'Stream.of(strings)' is : "+ x)).collect(Collectors.toList()).toString());
        System.out.println(" combined to list " + Stream.of(strings).peek(x -> System.out.println("The peeked value from 'Stream.of(strings)' is : "+ x)).collect(Collectors.toList()).toString());

//        combined = Stream.of(strings).collect(Collectors.joining(",", "[" , "]"));
        // what is the difference between strings.stream() & Stream.of(strings) ... above line gives compile error on joining
        combined = strings.stream().collect(Collectors.joining());
        System.out.println(" combined to with no args joining ::  " + combined);
        combined = strings.stream().collect(Collectors.joining(","));
        System.out.println(" joined with only the delimiter ::  " + combined);
    }
}

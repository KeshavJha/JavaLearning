package javaExamples.topics.lambdasNstreams;

//import com.google.common.collect.Streams;

import java.util.stream.Stream;

public class StreamsEgs {
    public static void main(String[] args) {
        int productOfAll = Stream.of(1,2,3,4,5,6)
                .filter(x -> (x % 2 == 0))
                .map(x->x+1).peek(x -> System.out.println(x))
                .reduce(Integer.valueOf(1),(a,b)->a*b);
        System.out.println(productOfAll);
    }
}

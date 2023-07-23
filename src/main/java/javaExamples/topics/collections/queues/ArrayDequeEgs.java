package javaExamples.topics.collections.queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ArrayDequeEgs {
    public static void main(String[] args) {
        iterator();
    }

    public static void iterator() {
        BlockingDeque<String> strs = new LinkedBlockingDeque<>();
        Iterator<String> strItr = strs.descendingIterator();  // @Note :: Iterator of BlockingDeque is snapshot iterator. `strItr` doesn't have any elements but `strItr2` has the elements that were added to it
        strs.add("hello1");
        strs.push("bye1");
        strs.offer("hello2");
        while (strItr.hasNext()) {
            System.out.println(strItr.next());
        }
        Iterator<String> strItr2 = strs.dxescendingIterator();
        strs.remove("hello1");  //  @Note :: removals are immediately reflected in snapshot iterator
        while (strItr2.hasNext()) {
            System.out.println(strItr2.next());
        }
    }
    public static void offerPushPopPoll(String[] args) {
        Deque<Integer> ints = new ArrayDeque<>();
        ints.offerFirst(23);
        ints.offerLast(13);
        ints.push(34);
        System.out.println(ints);
        ints.push(23);
        System.out.println(ints);
        ints.pop();
        System.out.println(ints);
        ints.poll();
        System.out.println(ints);
        ints.pollLast();
        System.out.println(ints);
    }
}

package javaExamples.topics.collections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueEgs {
    public static void main(String[] args) {
        Queue<String> strQ1 = priorityQueueAddRemoveTest();
        iterateQueue(strQ1);
    }

    private static Queue<String> priorityQueueAddRemoveTest() {
//        Queue<String> names = new PriorityQueue<>(16);
        Queue<String> names = new PriorityQueue<>(16, Comparator.nullsFirst(Comparator.reverseOrder()));

        System.out.println(names.add("hello")); // collection is modified so returning true;
        names.add("name1");
        names.add("hello");
        names.add("name2");
        System.out.println(names.offer("hello"));  // collection is modified so returning true;
        names.offer("name3");
//        names.offer(null);  --- gives NullPointer=Exception , both offer and add do
        System.out.println(names.remove());
        System.out.println(names.remove());
        System.out.println(names.remove());
        System.out.println(names.remove());
        System.out.println(names.element()); //
        System.out.println(names.remove());
        System.out.println(names.remove());
        System.out.println(names.peek());
        System.out.println(names.poll());
//        System.out.println(names.remove()); // gives NoSuchElementException for empty element
        System.out.println(names.poll()); // gives null for empty queue
        System.out.println(names.peek()); // gives null for empty queue -- element() will throw NoSuchElementException

        names.add("hello");
        names.add("name2");
        return names;
    }

    private static <T> void iterateQueue( Queue<T> tQueue) {
        for (T item : tQueue) {
            System.out.printf("Iterating element %s\n", item );
        }
    }

}

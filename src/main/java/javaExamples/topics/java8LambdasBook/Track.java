package javaExamples.topics.java8LambdasBook;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Track {
    String name;

    public static void main(String[] arr) {
        //  removeThis -- PriorityQueueCheck
        Queue<String> strQ = new PriorityQueue<>(Comparator.reverseOrder());
//        Queue<String> strQ = new PriorityQueue<>();

        // Fixed size waala kaise implement karoge ??
        strQ.add("hello");
        strQ.add("gone");
        strQ.add("aao");
        strQ.add("world");
        strQ.add("here");
        System.out.println(strQ.remove());
        System.out.println(strQ.remove());
        System.out.println(strQ.remove());
        System.out.println(strQ.remove());
        System.out.println(strQ.remove());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

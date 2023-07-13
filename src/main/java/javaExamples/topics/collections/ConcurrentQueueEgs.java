package javaExamples.topics.collections;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueueEgs {
    public static void main(String[] args) {
        concurrentLinkedQueue();
    }

    private static void concurrentLinkedQueue() {
        Queue<String> strs = new ConcurrentLinkedQueue<>();
        List<Thread> submitters = new ArrayList<>(10);
        List<Thread> receivers = new ArrayList<>(10);
        for (int i = 0; i < 5; i++) {
            submitters.add(new Thread( new ThreadedSubmitter<>(strs, String.valueOf(i))));
            receivers.add(new Thread( new ThreadedReceiver<>(strs, String.valueOf(i))));
        }
//        submitters.stream().forEach(x -> new ThreadedSubmitter<>(strs, String.valueOf(x)));
//        receivers.stream().forEach(x -> new ThreadedReceiver<>(strs, String.valueOf(x)));

        submitters.stream().forEach(x -> x.start());
        receivers.stream().forEach(x -> x.start());

    }


}

abstract class QueueProcessor<T> implements Runnable {
    Queue<T> q;
    public QueueProcessor(Queue<T> q) {
        this.q = q;
    }
}

class ThreadedSubmitter<T> extends QueueProcessor<T> {
    T seedValue;

    public ThreadedSubmitter(Queue<T> q, T value) {
        super(q);
        this.seedValue = value;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 10 ; i++) {
            String value = seedValue + "::" + LocalDateTime.now().toString();
            System.out.printf("submitting %s \n", value);
            q.offer((T)value);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class ThreadedReceiver<T> extends QueueProcessor<T> {
    T seedValue;

    public ThreadedReceiver(Queue<T> q, T value) {
        super(q);
        this.seedValue = value;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);

            System.out.printf("reading %s ready to read at time \n", seedValue);
            for(int i = 0 ; i < 10 ; i++) {
                Thread.sleep(1000);

                if(!q.isEmpty()) {
                    String value =  LocalDateTime.now().toString();
                    System.out.printf("reading  %s from thread %s at %s\n", this.q.poll(), seedValue, value);
                } else {
                    System.out.printf("reading %s found queue empty \n", seedValue);
                    Thread.sleep(2000);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
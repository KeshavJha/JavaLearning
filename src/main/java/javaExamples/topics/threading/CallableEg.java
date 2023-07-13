package javaExamples.topics.threading;

import java.util.concurrent.Callable;

public class CallableEg {
    public static void main(String[] args) {
        Callable<String>[] callables = new CallableSub[10];
        for(Callable i: callables) {
            i = new CallableSub();
            try {
                System.out.println(i.call());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class CallableSub implements Callable<String> {

    @Override
    public String call() {
        return "hello"+Math.random();
    }
}


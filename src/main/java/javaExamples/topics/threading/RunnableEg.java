package javaExamples.topics.threading;

public class RunnableEg {
    public static void main(String[] args) {
        Runnable rsb = new RunnableSub();
        Thread tsh = new Thread(rsb);
        tsh.start();
    }
}

class RunnableSub implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread printing");
    }
}

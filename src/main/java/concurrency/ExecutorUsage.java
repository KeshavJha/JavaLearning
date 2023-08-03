package concurrency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class ExecutorUsage {
//    Executor er = new ThreadPoolExecutor(10);
    public static void main (String[] args) throws IOException {

        Properties props = System.getProperties();
        System.out.println( "\n*********\n Props :::: \n " + props.toString());

        System.out.printf( "\n*********\n total Memory :: %s \t; free Memory :: %s\t; Cores :: %s \n ",
                Runtime.getRuntime().totalMemory() ,
                Runtime.getRuntime().freeMemory(),
                Runtime.getRuntime().availableProcessors());

//        Runtime.getRuntime().exec(new String[]{"cmd", "notepad"});

        createAndUseExecutor();

    }

    public static void createAndUseExecutor() {
        Runnable task = () -> {
            Thread th = Thread.currentThread();
            System.out.printf("Thread : %s , having name : %s, in state : %s\n" , th.toString(), th.getName() , th.getState());
            th.start();  // @CHECK : IS IT OKAY to do start() here ... executor is already going to do that .... BUT WHY IS THE THREAD STATE always RUNNABLE ... isn't it started by executorService ??
            try {
                th.wait(500);
                System.out.printf("Thread : %s , after start state : %s\n" , th.getName() , th.getState()); // @CHECK : WHY IS THIS NOT executed ... anything before wait() call is executed , but after wait() nothing happens .
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        List<Runnable> tasks = new ArrayList<>(50);
        for(int i = 0 ; i < 50; i++ ) {
            tasks.add(task);
        }
        try (ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())) { // @NOTE : better to use Executors with try-with resources , so that shutdown happens automatically at end
            tasks.forEach(es::submit);
            es.shutdown();
            es.awaitTermination(100, TimeUnit.SECONDS); // @CHECK : HOW TO MAKE Executor wait for the threads to complete.

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

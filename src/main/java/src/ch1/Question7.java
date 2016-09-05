package ch1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by vijay on 9/4/16.
 */
public class Question7 {
    public static void main(String... args){
        String[] names = {"Peter", "Mary", "Paul"};
        List<Runnable> runnables = new ArrayList<>();
        for(String name: names){
            runnables.add(() -> System.out.println(name));
        }

        ExecutorService es = Executors.newFixedThreadPool(5);
        for(Runnable r: runnables){
            es.execute(r);
        }
        es.shutdown();
    }
}

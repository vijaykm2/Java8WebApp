package ch1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by vijay on 8/15/16.
 */
public class Main {
    public static void main(String[] args){
        ReadFromUrl reader = new ReadFromUrl("https://en.wikipedia.org/wiki/World_War_II");
        ReadFromUrl reader3 = new ReadFromUrl("https://en.wikipedia.org/wiki/World_War_II");
        ReadFromUrl reader4 = new ReadFromUrl("https://en.wikipedia.org/wiki/World_War_II");
        ReadFromUrl reader5 = new ReadFromUrl("https://en.wikipedia.org/wiki/World_War_II");
        ReadFromUrl reader6 = new ReadFromUrl("https://en.wikipedia.org/wiki/World_War_II");
        ReadFromUrl reader7 = new ReadFromUrl("https://en.wikipedia.org/wiki/World_War_II");
        ReadFromUrl reader8 = new ReadFromUrl("https://en.wikipedia.org/wiki/World_War_II");

        ReadFromUrl reader2 = new ReadFromUrl("https://en.wikipedia.org/wiki/World_War_II");
        List<String> results = reader.read();
        results.addAll(reader2.read());

        results.addAll(reader8.read());
        results.addAll(reader7.read());
        results.addAll(reader3.read());
        results.addAll(reader4.read());
        results.addAll(reader5.read());
        results.addAll(reader6.read());
        List<String> resc=new ArrayList<>();
        resc.addAll(results);
        Long start =System.currentTimeMillis();
        resc.sort((String firstString, String secondString) -> {
            return Integer.compare(firstString.length(), secondString.length());
        });
        Long end =System.currentTimeMillis();
        System.out.println("Single thread time : "+(end - start));
        int size =  results.size();
        List<String> list1 = results.subList(0, (size/2)-1);
        List<String> list2 = results.subList(size/2, size-1);
//        List<String> list3 = results.subList(size/2, new Double(size*.75-1).intValue());
//        List<String> list4= results.subList(new Double(size*.75).intValue(), size);
       List<String> resList = new ArrayList<>();
        Worker w1 =new Worker("Thread 1");
        w1.setStrings(list1);
        Worker w2 =new Worker("Thread 2");
        w2.setStrings(list2);

//        Worker w3 =new Worker("Thread 3");
//        w3.setStrings(list3);
//        Worker w4 =new Worker("Thread 4");
//        w4.setStrings(list4);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        start =System.currentTimeMillis();
        Future future1= executorService.submit(w1);
        Future future2 = executorService.submit(w2);
//        Future future3 = executorService.submit(w3);
//        Future future4= executorService.submit(w4);
        while((future1.isDone() && future2.isDone()) != true){
            //System.out.println("Threads Executing");
        }
        resList.addAll(w1.getStrings());
        resList.addAll(w2.getStrings());
//        resList.addAll(w3.getStrings());
//        resList.addAll(w4.getStrings());
//
        resList.sort((String firstString, String secondString) -> {
            return Integer.compare(firstString.length(), secondString.length());
        });
        end =System.currentTimeMillis();
        System.out.println("Multi thread time : "+(end - start));
        executorService.shutdown();


    }
}

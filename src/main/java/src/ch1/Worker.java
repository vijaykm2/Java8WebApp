package ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by vijay on 8/15/16.
 */
public class Worker implements Runnable {
    private String name;

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    private List<String> strings;

    public Worker(String name){
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.name);
        //System.out.println("Thread executing : "+ this.name);

        Comparator<String> comp = (String firstString, String secondString) -> {
            return Integer.compare(firstString.length(), secondString.length());
        };
        strings.sort(comp);

    }


}

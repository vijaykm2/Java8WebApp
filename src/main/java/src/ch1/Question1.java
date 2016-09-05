package ch1;

import java.util.Arrays;

/**
 * Created by vijay on 9/4/16.
 */
public class Question1 {
    public static void main(String args[]){
        String[] strings = {"zebra","apple","dog","goat","tomato"};
        Thread.currentThread().setName("t1");
        Arrays.sort(strings, (first,  second) ->{
            System.out.println(Thread.currentThread().getName());
            return Integer.compare(first.length(), second.length());
        });
        for (String st: strings
             ) {
            System.out.println(st);
        }

    }
}

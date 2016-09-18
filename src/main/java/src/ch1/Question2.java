package src.ch1;

import java.io.File;

/**
 * Created by vijay on 9/4/16.
 */
public class Question2 {
    public  static void main(String[] args){
        File file = new File("/home/vijay");

        File[] files = file.listFiles((rile) -> {
            return  rile.isDirectory();
        });
        System.out.println("List of dirs: ");
        for (File f : files){
            System.out.println(f.getName());
        }
    }

}

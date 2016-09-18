package src.ch1;

import java.io.File;

/**
 * Created by vijay on 9/4/16.
 */
public class Question3 {
    public static void main (String [] args){
        File file = new File("/home/vijay/Pictures");
        File[] files = file.listFiles((f) -> {
            return f.getName().endsWith(".jpg") || f.getName().endsWith(".png");
        });

        for (File f:files) {
            System.out.println(f.getName());

        }
    }
}

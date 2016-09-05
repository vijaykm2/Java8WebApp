package ch1;

import java.io.File;
import java.util.Arrays;

/**
 * Created by vijay on 9/4/16.
 */
public class Question4 {
    static int sortByName(File f1, File f2){
        return f1.getName().compareTo(f2.getName());
    }

    static void printFiles(File[] files){
        for(File f: files){
            System.out.println(f.getName());
        }
    }
    public static void main(String args[]){
        File file =new File("/home/vijay");
        File[] dirs = file.listFiles((File f) -> {
            return f.isDirectory();
        });

        File[] files = file.listFiles((File f) -> {
            return !f.isDirectory();
        });

        Arrays.sort(dirs, Question4::sortByName);
        Arrays.sort(files, Question4::sortByName);

        printFiles(dirs);
        printFiles(files);

    }
}

package src.ch2;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by vijay on 9/5/16.
 */
public class Main {
   public static void main (String[] args) throws IOException {
        Path p = Paths.get("/home/vijay/IdeaProjects/Java8WebApp/note");
        String contents = new String(Files.readAllBytes(new File("note").toPath()), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split(" "));
        String[] s={"",""};

        long count =0;
        for (String w : words){
            if(w.length() >=10) count++;
        }
        System.out.println("count = "+count);

        count = words.parallelStream().filter( w-> w.length()>11).count();
        System.out.println("count = "+count);

        Stream<String> words2 = Stream.of(contents.split(" "));

        count = words2.filter(w -> w.length()>10).count();
        System.out.println("count = "+count);

        Stream<String> stream = Stream.empty();
        Stream<Double> randoms = Stream.generate(Math::random);

        randoms =randoms.filter(r -> r%5 ==0 ).limit(1);
        Double[] rnd = (Double[]) randoms.toArray();
        System.out.println(rnd.toString());



    }
}
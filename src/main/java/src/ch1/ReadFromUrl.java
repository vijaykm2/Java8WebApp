package ch1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vijay on 8/15/16.
 */
public class ReadFromUrl {
    private String url;
    ReadFromUrl(String url) {
        this.url = url;
    }

    public List<String> read(){
        List<String> result =new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader((new URL(this.url)).openStream()))){
            String line;
            while((line = br.readLine() )!= null){
                result.add(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }
}

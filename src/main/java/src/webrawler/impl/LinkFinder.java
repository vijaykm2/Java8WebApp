package webrawler.impl;

import org.apache.commons.validator.routines.UrlValidator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import webrawler.LinkHandler;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vijay on 8/18/16.
 */
public class LinkFinder implements Runnable{

    private String url;
    private WebCrawler handler;
    private static final Long t0 = System.nanoTime();

    public LinkFinder(String url, LinkHandler handler){
        this.url = url;
        this.handler = (WebCrawler) handler;

    }

    @Override
    public void run() {
        getSimpleLinks(url);
    }

    private void getSimpleLinks(String url){
        //if not already visited
        if (!handler.visited(url)) {
            try {
                UrlValidator validator =new UrlValidator();
                List<String> urls = new ArrayList<String>();
                //if ( handler.size() <=1500) {
                    Document doc = Jsoup.parse(new URL(url), 3000);
                    Elements elements = doc.getElementsByTag("a");
                    for (Element element : elements
                            ) {
                        String link = element.attr("href").trim();
                        if(link.startsWith("//")){
                            link = "https:"+link;
                        }
                        if (validator.isValid(link) && !handler.visited(link) && !handler.visitedLinks.contains(link) && link.contains(handler.getSiteName())) {

                            urls.add(link);
                        }
                    }
                //}
                //we visited this url
                handler.removeVisiting(url);
                handler.addVisited(url);
                System.out.println("visiting links size "+ handler.visitingLinks.size() +" visited links : "+  handler.visitedLinks.size());
                for (String l : urls) {
                    handler.queueLink(l);
                }

            } catch (Exception e) {
                //ignore all errors for now
            }
        }
    }
}

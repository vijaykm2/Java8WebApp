package src.webrawler.impl;

import src.webrawler.LinkHandler;
import src.webrawler.impl.LinkFinder;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Created by vijay on 8/18/16.
 */
public class WebCrawler implements LinkHandler{
    public final Collection<String> visitedLinks = Collections.synchronizedSet(new HashSet<String>());
    public final Collection<String> visitingLinks = Collections.synchronizedSet(new HashSet<String>());

    private String url;
    private String siteName;

    private ExecutorService executorService;

    public WebCrawler(String url, int maxThreads){
        this.url = url;
        executorService = Executors.newFixedThreadPool(maxThreads);

    }
    @Override
    public void queueLink(String link) {
        //if(this.size()%100 ==0){
            //System.out.println("Size : "+ this.size()+" visiting "+ link);
        //}
        if( !visitedLinks.contains(link) && !visitingLinks.contains(link)) {
            visitingLinks.add(link);
            this.startNewThread(link);
        }

        if (visitedLinks.size() ==0){
            executorService.shutdown();
            System.out.println("Shutting down executor service!!");

            visitedLinks.clear();
            visitingLinks.clear();
        }
    }

    @Override
    public int size() {
        return visitedLinks.size();
    }

    @Override
    public boolean visited(String link) {
        return visitedLinks.contains(link);
    }

    @Override
    public void addVisited(String url) {
        visitedLinks.add(url);
    }

    @Override
    public void removeVisiting(String url) {
        visitingLinks.remove(url);
    }

    private void startNewThread(String link){
        executorService.execute(new LinkFinder(link, this));
    }

    public void startCrawling() {
        this.startNewThread(this.url);
    }

    public static void main(String [] args){
        WebCrawler crawler =  new WebCrawler("https://te.wikipedia.org/wiki/", 10);
        crawler.setSiteName("te.wikipedia");
        crawler.startCrawling();
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
}

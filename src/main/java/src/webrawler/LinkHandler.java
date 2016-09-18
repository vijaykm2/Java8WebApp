package src.webrawler;

/**
 * Created by vijay on 8/18/16.
 */
public interface LinkHandler {
    public void queueLink(String link);
    public int size();
    public boolean visited(String link);
    public void addVisited(String link);


    void removeVisiting(String url);
}

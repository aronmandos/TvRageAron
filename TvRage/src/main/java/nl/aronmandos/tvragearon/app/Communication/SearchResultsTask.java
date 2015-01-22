package nl.aronmandos.tvragearon.app.Communication;

import android.os.AsyncTask;
import nl.aronmandos.tvragearon.app.Communication.handlers.SearchResultsHandler;
import nl.aronmandos.tvragearon.app.Domain.SearchResults;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 *
 * Created by Aron on 21-1-2015.
 */
public class SearchResultsTask extends AsyncTask<String, Void, SearchResults> {

    private SearchResultsHandler handler;

    public SearchResultsTask() {
        super();
    }

    public SearchResultsTask(SearchResultsHandler handler) {
        super();
        this.handler = handler;
    }

    public SearchResultsHandler getHandler() {
        return handler;
    }

    public void setHandler(SearchResultsHandler handler) {
        this.handler = handler;
    }

    @Override
    protected SearchResults doInBackground(String... searches) {
        final String url = "http://services.tvrage.com/feeds/search.php?show="+searches[0];

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());
        SearchResults searchResults = restTemplate.getForObject(url, SearchResults.class);
        return searchResults;
    }

    protected void onPostExecute(SearchResults result) {
        if(handler != null) {
            handler.handleSearchResults( result );
        }

    }
}

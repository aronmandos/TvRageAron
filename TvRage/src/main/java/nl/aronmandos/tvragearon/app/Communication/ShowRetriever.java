package nl.aronmandos.tvragearon.app.Communication;

import android.os.AsyncTask;
import android.widget.TextView;
import nl.aronmandos.tvragearon.app.Domain.Show;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Method;

/**
 * Created by Aron on 21-1-2015.
 */
public class ShowRetriever extends AsyncTask<Integer, Void, Show> {

    private ShowHandler handler;

    public ShowRetriever() {
        super();
    }

    public ShowRetriever(ShowHandler handler) {
        super();
        this.handler = handler;
    }

    public ShowHandler getHandler() {
        return handler;
    }

    public void setHandler(ShowHandler handler) {
        this.handler = handler;
    }

    @Override
    protected Show doInBackground(Integer[] showIds) {
        final String url = "http://services.tvrage.com/feeds/full_show_info.php?sid="+showIds[0];

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());
        Show show = restTemplate.getForObject(url, Show.class);
        return show;
    }

    protected void onPostExecute(Show result) {
        if(handler != null) {
            handler.handleShow(result);
        }

    }
}

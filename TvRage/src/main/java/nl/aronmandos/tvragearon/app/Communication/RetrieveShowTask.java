package nl.aronmandos.tvragearon.app.Communication;

import android.os.AsyncTask;
import nl.aronmandos.tvragearon.app.Communication.handlers.ShowHandler;
import nl.aronmandos.tvragearon.app.Domain.Show;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Aron on 21-1-2015.
 */
public class RetrieveShowTask extends AsyncTask<String, Void, Show> {

    private ShowHandler handler;

    public RetrieveShowTask() {
        super();
    }

    public RetrieveShowTask(ShowHandler handler) {
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
    protected Show doInBackground(String[] showIds) {
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

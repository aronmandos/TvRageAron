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
public class RetrieveShow extends AsyncTask<Integer, Void, Show> {
    public ShowHandler getHandler() {
        return handler;
    }

    public void setHandler(ShowHandler handler) {
        this.handler = handler;
    }

    private ShowHandler handler;


    @Override
    protected Show doInBackground(Integer[] params) {
        final String url = "http://services.tvrage.com/feeds/full_show_info.php?sid=18164"+params[0];

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());
        Show show = restTemplate.getForObject(url, Show.class);
        System.out.println("TEST    TEST "+ show.getName());
        return show;
    }

    protected void onPostExecute(Show result) {
        if(handler != null) {
            handler.handleShow(result);
        }

    }
}

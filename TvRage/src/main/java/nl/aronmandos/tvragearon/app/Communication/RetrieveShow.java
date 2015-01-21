package nl.aronmandos.tvragearon.app.Communication;

import android.os.AsyncTask;
import android.widget.TextView;
import nl.aronmandos.tvragearon.app.Domain.Show;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Aron on 21-1-2015.
 */
public class RetrieveShow extends AsyncTask {
    @Override
    protected Object doInBackground(Object[] params) {
        final String url = "http://services.tvrage.com/feeds/full_show_info.php?sid=18164";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());
        TextView testView = (TextView) params[0];
        Show show = restTemplate.getForObject(url, Show.class);
        testView.setText("Hello " +show.getName());
        return show;
    }
}

package nl.aronmandos.tvragearon.app.Communication;

import android.os.AsyncTask;
import android.widget.TextView;
import nl.aronmandos.tvragearon.app.Domain.Show;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Aron on 21-1-2015.
 */
public class RetrieveShow extends AsyncTask<Object, Void, String> {

    TextView testView;

    @Override
    protected String doInBackground(Object[] params) {
        final String url = "http://services.tvrage.com/feeds/full_show_info.php?sid="+params[1];

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());
        testView = (TextView) params[0];
        Show show = restTemplate.getForObject(url, Show.class);
        //testView.setText("Hello " +show.getName());
        System.out.println("TEST    TEST "+ show.getName());
        return show.getName();
    }

    protected void onPostExecute(String result) {
        testView.setText("Hello " + result);
    }
}

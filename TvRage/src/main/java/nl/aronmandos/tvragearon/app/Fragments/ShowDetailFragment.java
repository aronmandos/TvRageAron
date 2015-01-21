package nl.aronmandos.tvragearon.app.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import nl.aronmandos.tvragearon.app.Communication.RetrieveShow;
import nl.aronmandos.tvragearon.app.Communication.ShowHandler;
import nl.aronmandos.tvragearon.app.Domain.Show;
import nl.aronmandos.tvragearon.app.R;
import nl.aronmandos.tvragearon.app.dummy.DummyContent;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * A fragment representing a single Show detail screen.
 * This fragment is either contained in a {@link nl.aronmandos.tvragearon.app.Activities.ShowListActivity}
 * in two-pane mode (on tablets) or a {@link nl.aronmandos.tvragearon.app.Activities.ShowDetailActivity}
 * on handsets.
 */
public class ShowDetailFragment extends Fragment implements ShowHandler {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ShowDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_show_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.show_detail)).setText(mItem.content);
        }
        TextView testView = (TextView) rootView.findViewById(R.id.show_detail2);
        testView.setText("Hello World! ");

        RetrieveShow rs = new RetrieveShow();
        rs.setHandler(this);
        rs.execute(18164);
        return rootView;
    }

    @Override
    public void handleShow(Show show) {

    }
}

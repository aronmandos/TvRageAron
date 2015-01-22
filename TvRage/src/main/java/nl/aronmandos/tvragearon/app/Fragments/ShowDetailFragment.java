package nl.aronmandos.tvragearon.app.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import nl.aronmandos.tvragearon.app.Activities.ShowList;
import nl.aronmandos.tvragearon.app.Communication.handlers.ShowHandler;
import nl.aronmandos.tvragearon.app.Communication.RetrieveShowTask;
import nl.aronmandos.tvragearon.app.Domain.Genre;
import nl.aronmandos.tvragearon.app.Domain.Show;
import nl.aronmandos.tvragearon.app.R;

import java.security.Key;
import java.util.Map;

/**
 * A fragment representing a single Show detail screen.
 * This fragment is either contained in a {@link nl.aronmandos.tvragearon.app.Activities.ShowListActivity}
 * in two-pane mode (on tablets) or a {@link nl.aronmandos.tvragearon.app.Activities.ShowDetailActivity}
 * on handsets.
 */
public class ShowDetailFragment extends Fragment implements ShowHandler {

    TextView titleView;
    TextView startedView;
    TextView endedView;
    TextView statusView;
    TextView genresView;
    ImageView imageView;
    TextView linkView;

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Show mItem;

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
            mItem = ShowList.getShowById(getArguments().getString(ARG_ITEM_ID));
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_show_detail, container, false);

        // Show the dummy content as text in a TextView.

        titleView = (TextView) rootView.findViewById(R.id.show_title);
        startedView = (TextView) rootView.findViewById(R.id.show_started);
        endedView = (TextView) rootView.findViewById(R.id.show_ended);
        statusView = (TextView) rootView.findViewById(R.id.show_status);
        genresView = (TextView) rootView.findViewById(R.id.show_genres);
        imageView = (ImageView) rootView.findViewById(R.id.show_image);
        linkView = (TextView) rootView.findViewById(R.id.show_link);
        if (mItem != null) {
            titleView.setText(mItem.getName());
        }

        new RetrieveShowTask(this).executeOnExecutor(RetrieveShowTask.THREAD_POOL_EXECUTOR, mItem.getShowid());
        return rootView;
    }

    @Override
    public void handleShow(Show show) {
        titleView.setText(show.getName());
        if (show.getStarted() != null && !show.getStarted().isEmpty()) {
            startedView.setText(show.getStarted());
        }
        if (show.getEnded() != null && !show.getEnded().isEmpty()) {
            endedView.setText(show.getEnded());
        }
        if (show.getStatus() != null && !show.getStatus().isEmpty()) {
            statusView.setText(show.getStatus());
        }
        if (show.getGenres() != null && !show.getGenres().isEmpty()) {
            String temp = "";
            for (Genre genre : show.getGenres()) {
                if (!temp.equals("")) {
                    temp += ", ";
                }
                temp += genre;
            }
            genresView.setText(temp);
        }
        if (show.getImage() != null && !show.getImage().isEmpty()) {
            ImageLoader.getInstance().displayImage(show.getImage(), imageView);
        }
        if (show.getInfoLink() != null && !show.getInfoLink().isEmpty()) {
            linkView.setText(show.getInfoLink());
        }
    }
}

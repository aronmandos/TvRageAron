package nl.aronmandos.tvragearon.app.Activities;

import nl.aronmandos.tvragearon.app.Domain.Show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ShowList {

    /**
     * An array of sample (dummy) items.
     */
    public static List<Show> SHOWS = new ArrayList<Show>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, Show> SHOW_MAP = new HashMap<String, Show>();

    static {
        // Add 3 sample items.
        addShow(new Show("1", "Test Show 1"));
        addShow(new Show("2", "Test Show 2"));
        addShow(new Show("3", "Test Show 3"));
    }

    private static void addShow(Show show) {
        SHOWS.add(show);
        SHOW_MAP.put(show.getShowid(), show);
    }
}

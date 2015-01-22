package nl.aronmandos.tvragearon.app.Models;

import nl.aronmandos.tvragearon.app.Domain.Show;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * <p/>
 */
public class ShowList {

    /**
     * An array of sample (dummy) items.
     */
    public static List<Show> SHOWS = new ArrayList<Show>();

    public static Show getShowById(String id) {
        for (Show show : SHOWS) {
            if (show.getShowid().equals(id)) {
                return show;
            }
        }

        return null;
    }



}

package nl.aronmandos.tvragearon.app.Domain;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 *
 * Created by Aron on 21-1-2015.
 */
@Root(name = "Results", strict=false)
public class SearchResults {

    @ElementList(entry="show", required = false, inline = true)
    private List<Show> shows;

    public SearchResults() {

    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }


}

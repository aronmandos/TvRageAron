package nl.aronmandos.tvragearon.app.Domain;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 *
 * Created by Aron on 21-1-2015.
 */
@Root(strict=false)
public class Show {

    @Attribute(name = "type", required = false)
    private String type;
    @Element
    private String name;
    @Element(required = false)
    private String totalseasons;
    @Element
    private String showid;
    @Element(required = false)
    private String showlink;
    @Element(required = false)
    private String link;
    @Element(required = false)
    private String started;
    @Element(required = false)
    private String ended;
    @Element(required = false)
    private String image;
    @Element(required = false)
    private String origin_country;
    @Element(required = false)
    private String status;
    @ElementList(name = "genres", entry="genre", required = false)
    private List<Genre> genres;
    @ElementList(name = "Episodelist", entry="Season", required = false)
    private List<Season> Episodelist;

    public Show() {

    }
    public Show(String showid, String name ) {
        this.setName(name);
        this.setShowid(showid);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalseasons() {
        return totalseasons;
    }

    public void setTotalseasons(String totalseasons) {
        this.totalseasons = totalseasons;
    }

    public String getShowid() {
        return showid;
    }

    public void setShowid(String showid) {
        this.showid = showid;
    }

    public String getInfoLink() {
        if (link != null && !link.isEmpty()) {
            return link;
        } else if (showlink != null && !showlink.isEmpty()) {
            return showlink;
        } else {
            return null;
        }

    }

    public String getShowlink() {
        return showlink;
    }

    public void setShowlink(String showlink) {
        this.showlink = showlink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStarted() {
        return started;
    }

    public void setStarted(String started) {
        this.started = started;
    }

    public String getEnded() {
        return ended;
    }

    public void setEnded(String ended) {
        this.ended = ended;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Season> getEpisodelist() {
        return Episodelist;
    }

    public void setEpisodelist(List<Season> episodelist) {
        Episodelist = episodelist;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
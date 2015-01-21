package nl.aronmandos.tvragearon.app.Domain;

import org.simpleframework.xml.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Aron on 21-1-2015.
 */
@Root(strict=false)
public class Show {
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

    public String getShowlink() {
        return showlink;
    }

    public void setShowlink(String showlink) {
        this.showlink = showlink;
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

    /*public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }*/

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Season> getEpisodelist() {
        return Episodelist;
    }

    public void setEpisodelist(List<Season> episodelist) {
        Episodelist = episodelist;
    }

    @Attribute(name = "type", required = false)
    private String type;
    @Element
    private String name;
    @Element
    private String totalseasons;
    @Element
    private String showid;
    @Element
    private String showlink;
    @Element
    private String started;
    @Element
    private String ended;
    @Element
    private String image;
    @Element
    private String origin_country;
    @Element
    private String status;
    //TODO @ElementArray(entry="genre")
    //private ArrayList<String> genres;
    @ElementList(name = "Episodelist", entry="Season")
    private List<Season> Episodelist;



}
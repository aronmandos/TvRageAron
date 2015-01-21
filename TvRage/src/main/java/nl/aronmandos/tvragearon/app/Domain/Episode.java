package nl.aronmandos.tvragearon.app.Domain;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *
 * Created by Aron on 21-1-2015.
 */
@Root(strict=false)
public class Episode {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEpnum() {
        return epnum;
    }

    public void setEpnum(String epnum) {
        this.epnum = epnum;
    }

    public String getSeasonnum() {
        return seasonnum;
    }

    public void setSeasonnum(String seasonnum) {
        this.seasonnum = seasonnum;
    }

    public String getAirdate() {
        return airdate;
    }

    public void setAirdate(String airdate) {
        this.airdate = airdate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScreencap() {
        return screencap;
    }

    public void setScreencap(String screencap) {
        this.screencap = screencap;
    }

    @Attribute(name = "type", required = false)
    private String type;
    @Element(required = false)
    private String epnum;
    @Element(required = false)
    private String seasonnum;
    @Element
    private String airdate;
    @Element(required = false)
    private String link;
    @Element
    private String title;
    @Element(required = false)
    private String screencap;
}
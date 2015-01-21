package nl.aronmandos.tvragearon.app.Domain;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Aron on 21-1-2015.
 */
@Root(strict=false)
public class Season {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public List<Episode> getEpisodes() {
        return Episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        Episodes = episodes;
    }

    @Attribute (name = "type", required = false)
    private String type;
    @Attribute(name = "no", required = false)
    private String no;
    @ElementList(entry="episode", inline=true)
    private List<Episode> Episodes;
}

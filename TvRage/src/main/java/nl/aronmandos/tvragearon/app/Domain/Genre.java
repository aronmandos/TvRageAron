package nl.aronmandos.tvragearon.app.Domain;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/**
 * Created by Aron on 21-1-2015.
 */
@Root(strict = false)
public class Genre {

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Text
    private String value;
}

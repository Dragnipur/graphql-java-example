package nl.kadaster.brk.graphql.jfall;


import nl.kadaster.brk.graphql.jfall.objecttype.Speaker;
import nl.kadaster.brk.graphql.jfall.objecttype.Talk;

import java.util.ArrayList;
import java.util.List;

public class StaticData {
    public static String token;
    public static List<Talk> talks = new ArrayList<>();

    static {
        talks.add(new Talk("Talk 1", "11:00", new Speaker("Jan de Vries")));
        talks.add(new Talk("Talk 2", "12:00", new Speaker("John Erts")));
        talks.add(new Talk("Talk 3", "13:00", new Speaker("Henk de Graaf")));
        talks.add(new Talk("Talk 4", "14:00", new Speaker("Jan Tulp")));
    }
}

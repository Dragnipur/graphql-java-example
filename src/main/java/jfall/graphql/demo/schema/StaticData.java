package jfall.graphql.demo.schema;


import jfall.graphql.demo.schema.objecttype.Talk;
import jfall.graphql.demo.schema.objecttype.TimeSlot;

import java.util.ArrayList;
import java.util.List;

public class StaticData {
    public static List<TimeSlot> timeslots = new ArrayList<>();
    public static List<Talk> talks = new ArrayList<>();

    static {
        timeslots.add(new TimeSlot("Slot 1", "Room 1"));
        timeslots.add(new TimeSlot("Slot 2", "Room 2"));
        timeslots.add(new TimeSlot("Slot 3", "Room 1"));
        timeslots.add(new TimeSlot("Slot 4", "Room 2"));

        talks.add(new Talk("Talk 1", timeslots.get(0)));
        talks.add(new Talk("Talk 2",  timeslots.get(1)));
        talks.add(new Talk("Talk 3",  timeslots.get(2)));
        talks.add(new Talk("Talk 4",  timeslots.get(3)));
    }
}

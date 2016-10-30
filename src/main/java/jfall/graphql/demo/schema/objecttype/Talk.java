package jfall.graphql.demo.schema.objecttype;

import com.oembedler.moon.graphql.engine.stereotype.GraphQLDescription;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLField;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLObject;

@GraphQLObject("Talk")
public class Talk {
    private String title;
    private TimeSlot timeslot;
    private Talker talker;

    public Talk() {
    }

    public Talk(TalkInput input) {
        this.title = input.getTitle();
    }

    public Talk(String title, TimeSlot timeslot) {
        this.title = title;
        this.timeslot = timeslot;
    }

    @GraphQLField
    @GraphQLDescription("The title of the talk")
    public String getTitle() {
        return title;
    }

    @GraphQLField
    @GraphQLDescription("The timeslot the talk takes place")
    public TimeSlot getTimeslot() {
        return timeslot;
    }

    @GraphQLField
    public Talker getTalker() {
        return new Talker();
    };
}

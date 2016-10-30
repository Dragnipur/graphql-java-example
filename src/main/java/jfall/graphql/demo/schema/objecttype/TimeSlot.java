package jfall.graphql.demo.schema.objecttype;

import com.oembedler.moon.graphql.engine.stereotype.GraphQLDescription;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLField;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLObject;

@GraphQLObject("Timeslot")
public class TimeSlot {
    private String slot;
    private String location;

    public TimeSlot() {
    }

    public TimeSlot(String slot, String location) {
        this.slot = slot;
        this.location = location;
    }

    @GraphQLField
    @GraphQLDescription("The number of the slot (1 - 5)")
    public String getSlot() {
        return slot;
    }

    @GraphQLField
    @GraphQLDescription("The location of the talk")
    public String getLocation() {
        return location;
    }
}

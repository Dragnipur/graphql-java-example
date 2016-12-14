package nl.kadaster.brk.graphql.jfall.objecttype;

import com.oembedler.moon.graphql.engine.stereotype.*;

@GraphQLObject("Talk")
public class Talk {
    private String title;
    private String timeslot;
    private Speaker speaker;

    public Talk() {
    }

    public Talk(String title, String timeslot, Speaker speaker) {
        this.title = title;
        this.timeslot = timeslot;
        this.speaker = speaker;
    }

    @GraphQLField
    @GraphQLDescription("The title of the talk")
    public String getTitle() {
        return title;
    }

    @GraphQLField
    @GraphQLDescription("The timeslot the talk takes place")
    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    @GraphQLField
    public Speaker getSpeaker() {
        return speaker;
    }
}

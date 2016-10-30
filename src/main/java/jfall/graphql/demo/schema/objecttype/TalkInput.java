package jfall.graphql.demo.schema.objecttype;

public class TalkInput {
    private String title;

    public TalkInput() {
    }

    public TalkInput(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}

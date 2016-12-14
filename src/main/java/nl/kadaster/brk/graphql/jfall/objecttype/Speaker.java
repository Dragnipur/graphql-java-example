package nl.kadaster.brk.graphql.jfall.objecttype;

        import com.oembedler.moon.graphql.engine.stereotype.GraphQLField;
        import com.oembedler.moon.graphql.engine.stereotype.GraphQLObject;

@GraphQLObject
public class Speaker {
    private String name;

    public Speaker() {
    }

    public Speaker(String name) {
        this.name = name;
    }

    @GraphQLField
    public String getName() {
        return name;
    }
}

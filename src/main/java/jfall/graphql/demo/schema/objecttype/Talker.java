package jfall.graphql.demo.schema.objecttype;

import com.oembedler.moon.graphql.engine.stereotype.GraphQLField;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLObject;

@GraphQLObject
public class Talker {
    private String name;

    public Talker() {
        this.name = "Henk";
    }

    @GraphQLField
    public String getName() {
        return name;
    }
}

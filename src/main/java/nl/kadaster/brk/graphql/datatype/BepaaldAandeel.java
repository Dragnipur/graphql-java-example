package nl.kadaster.brk.graphql.datatype;

import com.oembedler.moon.graphql.engine.stereotype.GraphQLDescription;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLField;
import nl.kadaster.brk.datatype.Aandeel;

/**
 * Simple implementation of the {@link nl.kadaster.brk.datatype.BepaaldAandeel} but without any domain logic.
 *
 * @author marc
 * @since 0.1 on 15/12/2016
 */
public class BepaaldAandeel extends Aandeel {

    @GraphQLField
    @GraphQLDescription("De teller van de breuk")
    public long teller;
    @GraphQLField
    @GraphQLDescription("De noemer van de breuk")
    public long noemer;

    @Override
    public boolean isBepaald() {
        return true;
    }

    @Override
    public boolean isGeldig() {
        // TODO implement correctly isGeldig like brk.datatype.BepaaldAandeel
        return true;
    }

}

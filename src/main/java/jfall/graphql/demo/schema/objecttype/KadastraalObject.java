package jfall.graphql.demo.schema.objecttype;

import com.oembedler.moon.graphql.engine.stereotype.GraphQLDescription;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLField;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLObject;

/**
 * @author Marc van Andel
 * @see <a href="http://tax.kadaster.nl/resource?subject=http%3A%2F%2Ftax.kadaster.nl%2Fid%2Fbegrip%2FKadastraal_object">http://tax.kadaster.nl/resource?subject=http%3A%2F%2Ftax.kadaster.nl%2Fid%2Fbegrip%2FKadastraal_object</a>
 * @since 0.1 on 14/12/2016.
 */
@GraphQLObject("KadastraalObject")
public class KadastraalObject {

    private String kadastraalObjectId;
    private String kadastraleAanduiding;

    public KadastraalObject() {
    }

    public KadastraalObject(String kadastraalObjectId, String kadastraleAanduiding) {
        this.kadastraalObjectId = kadastraalObjectId;
        this.kadastraleAanduiding = kadastraleAanduiding;
    }

    @GraphQLField
    @GraphQLDescription("Het unieke id van een Kadastraal Object")
    public String getKadastraalObjectId() {
        return kadastraalObjectId;
    }

    @GraphQLField
    @GraphQLDescription("De Kadastrale aanduiding van een Kadastraal Object")
    public String getKadastraleAanduiding() {
        return kadastraleAanduiding;
    }

}

package nl.kadaster.brk.graphql.kadastraalobject;

import com.oembedler.moon.graphql.engine.stereotype.GraphQLDescription;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLField;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLObject;
import nl.kadaster.brk.graphql.CodeWaarde;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.slf4j.LoggerFactory;

/**
 * @author Marc van Andel
 * @since 0.1
 */
@GraphQLObject("Koopsom")
public class Koopsom {

    @GraphQLField
    @GraphQLDescription("Het bedrag van de koopsom")
    public double bedrag;
    // TODO create BigDecimalTypeFunction for public BigDecimal bedrag;
    @GraphQLField
    @GraphQLDescription("De valuta van het bedrag")
    public CodeWaarde valuta;
    @GraphQLField
    @GraphQLDescription("Het jaar van koop / overdracht waarin dit de koopsom was")
    public Integer koopjaar;
    @GraphQLField
    @GraphQLDescription("Indicator of er meerdere objecten betrokken zijn in deze koopsom")
    public boolean meerObjecten;

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object that) {
        boolean result = EqualsBuilder.reflectionEquals(this, that);
        LoggerFactory.getLogger(this.getClass()).debug("equals:" + result);
        return result;
    }
}

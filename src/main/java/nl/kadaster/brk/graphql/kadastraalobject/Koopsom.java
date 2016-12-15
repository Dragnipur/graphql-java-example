package nl.kadaster.brk.graphql.kadastraalobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import nl.kadaster.brk.graphql.CodeWaarde;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Marc van Andel
 * @since 0.1
 */
@JsonInclude(NON_NULL)
public class Koopsom {

    public BigDecimal bedrag;
    public CodeWaarde valuta;
    public Integer koopjaar;
    public boolean meerObjecten;

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object that) {
        boolean  result =  EqualsBuilder.reflectionEquals(this,that);
        LoggerFactory.getLogger(this.getClass()).debug("equals:" + result);
        return result;
    }
}

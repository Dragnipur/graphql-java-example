package nl.kadaster.brk.graphql.kadastraalobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.slf4j.LoggerFactory;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Marc van Andel
 * @since 0.1
 */
@JsonInclude(NON_NULL)
public class KadastraleAanduiding {

    public String kadastraleGemeente;
    public String sectie;
    public String perceelNummer;
    public String appartementsrechtVolgnummer;

    public String getAanduiding() {
        return kadastraleGemeente +
            " " +
            sectie +
            " " +
            perceelNummer +
            (appartementsrechtVolgnummer != null ? "A" + appartementsrechtVolgnummer : "");
    }

    public void setAanduiding(String aanduiding) {
        // afgeleid veld
    }

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

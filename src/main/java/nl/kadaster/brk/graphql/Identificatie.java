package nl.kadaster.brk.graphql;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.slf4j.LoggerFactory;

/**
 * @author Marc van Andel
 * @since 0.1
 */
public class Identificatie {
    public String compositeId;
    public String kadasterId;

    public Identificatie(String compositeId, String kadasterId) {
        this.compositeId = compositeId;
        this.kadasterId = kadasterId;
    }

    public Identificatie() {
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

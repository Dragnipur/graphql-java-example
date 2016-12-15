package nl.kadaster.brk.graphql.zakelijkrecht;

import nl.kadaster.brk.graphql.CodeWaarde;
import nl.kadaster.brk.graphql.Identificatie;
import nl.kadaster.brk.graphql.tenaamstelling.Tenaamstelling;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marc van Andel
 * @since 0.1
 */
public class ZakelijkRecht {

    public Identificatie identificatie = new Identificatie();
    public CodeWaarde aard;
    public List<Tenaamstelling> tenaamstellingen = new ArrayList<>();

    public void tenaamstellingBeeindigen(final String tenaamstellingId) {
        final Tenaamstelling tenaamstelling = findTenaamStelling(tenaamstellingId);
        if (tenaamstelling != null) {
            tenaamstellingen.remove(tenaamstelling); //tenaamsteling beeindigd
        }
    }

    public nl.kadaster.brk.graphql.tenaamstelling.Tenaamstelling findTenaamStelling(final String tenaamStellingId) {
        for (Tenaamstelling tenaamstelling : tenaamstellingen) {
            if (tenaamstelling.identificatie.compositeId.equals(tenaamStellingId)) {
                return tenaamstelling;
            }
        }
        return null;
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

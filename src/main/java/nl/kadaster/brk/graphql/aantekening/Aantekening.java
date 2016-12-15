package nl.kadaster.brk.graphql.aantekening;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import nl.kadaster.brk.graphql.CodeWaarde;
import nl.kadaster.brk.graphql.Identificatie;
import nl.kadaster.brk.graphql.tenaamstelling.Tenaamstelling;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static nl.kadaster.brk.graphql.aantekening.Aantekening.KOOPOVEREENKOMST;
import static nl.kadaster.brk.graphql.aantekening.Aantekening.STANDAARD_AANTEKENING;


/**
 * @author Marc van Andel
 * @since 0.1
 */
@JsonInclude(NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "typeAantekening", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = StandaardAantekening.class, name = STANDAARD_AANTEKENING),//
    @JsonSubTypes.Type(value = KoopovereenkomstAantekening.class, name = KOOPOVEREENKOMST)
})
public abstract class Aantekening {

    public static final String STANDAARD_AANTEKENING = "standaardAantekening";
    public static final String KOOPOVEREENKOMST = "koopovereenkomst";

    @JsonIgnore
    public String typeAantekening;
    public Identificatie identificatie;
    public Identificatie stukdeel;
    public CodeWaarde aardAantekening;
    public String omschrijving;
    public List<Identificatie> personen = new ArrayList<>();

    @JsonIgnore
    private List<Tenaamstelling> tenaamstellingen = new ArrayList<>();

    @JsonIgnore
    public List<Tenaamstelling> getTenaamstellingen() {
        return tenaamstellingen;

    }

    public void setTenaamstellingen(List<Tenaamstelling> tenaamstellingen) {
        // verwijder aantekening bij oude tenaamstellingen
        for (Tenaamstelling tenaamstelling : this.tenaamstellingen) {
            tenaamstelling.getAantekeningen().remove(this);
        }
        this.tenaamstellingen = tenaamstellingen;
        for (Tenaamstelling tenaamstelling : tenaamstellingen) {
            tenaamstelling.addAantekening(this);
        }
    }

    public void addTenaamstelling(Tenaamstelling tenaamstelling) {
        if (!tenaamstellingen.contains(tenaamstelling)) {
            tenaamstellingen.add(tenaamstelling);
            tenaamstelling.addAantekening(this);
        }
    }


    public static void removeAantekeningFromList(String aantekeningId, List<Aantekening> aantekeningen) {
        Iterator<Aantekening> it = aantekeningen.iterator();
        while (it.hasNext()) {
            Aantekening aantekening = it.next();
            if (aantekening.identificatie.compositeId.equals(aantekeningId)) {
                it.remove();
                return;
            }
        }
    }



    @Override
    public boolean equals(Object that) {
        if (that == null) {
            return false;
        }
        if (that instanceof Aantekening) {
            return EqualsBuilder.reflectionEquals(this, that);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }


}

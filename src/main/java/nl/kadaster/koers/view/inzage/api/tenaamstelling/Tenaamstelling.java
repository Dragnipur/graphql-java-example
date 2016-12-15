package nl.kadaster.koers.view.inzage.api.tenaamstelling;

import nl.kadaster.brk.datatype.Aandeel;
import nl.kadaster.brk.datatype.BepaaldAandeel;
import nl.kadaster.koers.view.inzage.api.Identificatie;
import nl.kadaster.koers.view.inzage.api.aantekening.Aantekening;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marc van Andel
 * @since 0.1
 */
public class Tenaamstelling {

    public Identificatie identificatie = new Identificatie();
    public Identificatie persoon = new Identificatie();
    public BepaaldAandeel aandeel;
    private List<Aantekening> aantekeningen = new ArrayList<>();
    public List<Identificatie> filiatie = new ArrayList<>();

    public List<Aantekening> getAantekeningen() {
        return aantekeningen;
    }

    public void setAantekeningen(List<Aantekening> aantekeningen) {
        // verwijder tenaamstelling bij oude aantekeningen
        for (Aantekening aantekening : this.aantekeningen) {
            aantekening.getTenaamstellingen().remove(this);
        }

        this.aantekeningen = aantekeningen;
        for (Aantekening aantekening : aantekeningen) {
            aantekening.addTenaamstelling(this);
        }
    }

    public void addAantekening(Aantekening aantekening) {
        if (!aantekeningen.contains(aantekening)) {
            aantekeningen.add(aantekening) ;
            aantekening.addTenaamstelling(this);
        }
    }


    public void setNieuwAandeel(Aandeel nieuwAandeel) {
        if (nieuwAandeel != null && nieuwAandeel instanceof BepaaldAandeel) {
            // Onbepaald en gezamelijk aandeel nog niet ondersteund
            this.aandeel = ((BepaaldAandeel) nieuwAandeel);
        }
    }

    public void verwijderAantekening(String aantekeningId) {
        Aantekening.removeAantekeningFromList(aantekeningId, aantekeningen);
    }


    @Override
    public boolean equals(Object that) {
        boolean  result =  EqualsBuilder.reflectionEquals(this,that);
        LoggerFactory.getLogger(this.getClass()).debug("equals:" + result);
        return result;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }


    public void setFiliatie(ArrayList<Identificatie> filiatie) {
        this.filiatie = filiatie;
    }
}

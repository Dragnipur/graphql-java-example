package nl.kadaster.koers.view.inzage.api.kadastraalobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import nl.kadaster.koers.registratie.datatype.TenaamstellingId;
import nl.kadaster.koers.registratie.datatype.ZakelijkRechtId;
import nl.kadaster.koers.registratie.datatype.ZekerheidsstellingId;
import nl.kadaster.koers.view.inzage.api.Identificatie;
import nl.kadaster.koers.view.inzage.api.aantekening.Aantekening;
import nl.kadaster.koers.view.inzage.api.aantekening.KoopovereenkomstAantekening;
import nl.kadaster.koers.view.inzage.api.zakelijkrecht.ZakelijkRecht;
import nl.kadaster.koers.view.inzage.api.zekerheidsstelling.Zekerheidsstelling;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Marc van Andel
 * @since 0.1
 */
@JsonInclude(NON_NULL)
public class KadastraalObject {


    public Identificatie identificatie = new Identificatie();

    public KadastraleAanduiding aanduiding = new KadastraleAanduiding();
    public KadastraleGrootte grootte = new KadastraleGrootte();
    public String typeGrens;
    public Koopsom koopsom;

    private List<Aantekening> aantekeningen = new ArrayList<>();
    public List<ZakelijkRecht> rechten = new ArrayList<>(); //platgeslagen lijst van rechten
    public List<Zekerheidsstelling> zekerheidsstellingen = new ArrayList<>();

    public List<Aantekening> getAantekeningen() {
        //filtered list met aleen aantekening voor object zelf. Tenaamstelling aantekeningen worden daar getoond
        //TODO java 8 : use filter
        ArrayList<Aantekening> result = new ArrayList<>();
        for (Aantekening aantekening : aantekeningen) {
            if (aantekening.getTenaamstellingen().isEmpty()) {
                result.add(aantekening);
            }
        }
        return result;
    }

    @JsonIgnore
    public List<Aantekening> getAantekeningenIntern() {
        return aantekeningen;
    }

    @Override
    public String toString() {
        return "KadastraalObject:" + identificatie;
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

    public void removeZekerheidsstelling(ZekerheidsstellingId identificatie) {
        Iterator<Zekerheidsstelling> it = zekerheidsstellingen.iterator();
        while (it.hasNext()) {
            Zekerheidsstelling zekerheidsstelling = it.next();
            if (zekerheidsstelling.identificatie.compositeId.equals(identificatie.getId())) {
                it.remove();
                break;
            }
        }
    }

    public Zekerheidsstelling findZekerheidsstelling(String zekerheidsstellingId ) {
        Iterator<Zekerheidsstelling> it = zekerheidsstellingen.iterator();
        while (it.hasNext()) {
            Zekerheidsstelling zekerheidsstelling = it.next();
            if (zekerheidsstelling.identificatie.compositeId.equals(zekerheidsstellingId)) {
                return zekerheidsstelling;
             }
        }
        return null;
    }

    public nl.kadaster.koers.view.inzage.api.tenaamstelling.Tenaamstelling findTenaamstelling(String tenaamstellingId) {
        for (ZakelijkRecht zakelijkRecht : rechten) {
            nl.kadaster.koers.view.inzage.api.tenaamstelling.Tenaamstelling tns = zakelijkRecht.findTenaamStelling(tenaamstellingId);
            if (tns != null) {
                return tns;
            }
        }
        return null;
    }

    public ZakelijkRecht findZakelijkRecht(String id) {
        for (ZakelijkRecht zakelijkRecht : rechten) {
            if (zakelijkRecht.identificatie.compositeId.equals(id) ){
                return zakelijkRecht;
            }
        }
        return null;
    }

    public KoopovereenkomstAantekening findKoopovereenkomstAantekening(String aantekeningId) {
        for (ZakelijkRecht recht : rechten) {
            for (nl.kadaster.koers.view.inzage.api.tenaamstelling.Tenaamstelling tenaamstelling : recht.tenaamstellingen) {
                for (Aantekening aantekening : tenaamstelling.getAantekeningen()) {
                    if (aantekening.identificatie.compositeId.equals(aantekeningId)) {
                        if (aantekening instanceof KoopovereenkomstAantekening) {
                            return (KoopovereenkomstAantekening) aantekening;
                        } else {
                            return null;
                        }

                    }
                }
            }
        }
        return null;
    }


    public void verwijderAantekening(String aantekeningId) {
        Aantekening.removeAantekeningFromList(aantekeningId,aantekeningen);
        // zoek aantekening ook in tenaamstellingen
        for (ZakelijkRecht recht : rechten) {
            for (nl.kadaster.koers.view.inzage.api.tenaamstelling.Tenaamstelling tenaamstelling : recht.tenaamstellingen) {
                tenaamstelling.verwijderAantekening(aantekeningId);
            }
        }

    }



    public Aantekening findAantekening(String aantekeningId) {
        for (Aantekening aantekening : aantekeningen) {
            if (aantekeningId.equals(aantekening.identificatie.compositeId))  {
                return aantekening;
            }
        }
        return null;
    }

    public List<nl.kadaster.koers.view.inzage.api.tenaamstelling.Tenaamstelling> findTenaamstellingen(Set<TenaamstellingId> betreft) {
        ArrayList<nl.kadaster.koers.view.inzage.api.tenaamstelling.Tenaamstelling> tenaamstellingen = new ArrayList<>();
        for (TenaamstellingId id : betreft) {
            nl.kadaster.koers.view.inzage.api.tenaamstelling.Tenaamstelling tns = this.findTenaamstelling(id.getId());
            if (tns!=null) {
                tenaamstellingen.add(tns);
            }
        }
        return tenaamstellingen;
    }


    public void verwijderRecht(ZakelijkRechtId identificatie) {
        Iterator<ZakelijkRecht> it = rechten.iterator();
        while (it.hasNext()) {
            ZakelijkRecht recht = it.next();
            if (recht.identificatie.compositeId.equals(identificatie.getId())) {
                it.remove();
                break;
            }
        }
    }
}

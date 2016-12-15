package nl.kadaster.brk.graphql.kadastraalobject;

import com.oembedler.moon.graphql.engine.stereotype.GraphQLDescription;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLField;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLObject;
import nl.kadaster.brk.graphql.Identificatie;

/**
 * @author Marc van Andel
 * @see <a href="http://tax.kadaster.nl/resource?subject=http%3A%2F%2Ftax.kadaster.nl%2Fid%2Fbegrip%2FKadastraal_object">http://tax.kadaster.nl/resource?subject=http%3A%2F%2Ftax.kadaster.nl%2Fid%2Fbegrip%2FKadastraal_object</a>
 * @since 0.1 on 14/12/2016.
 */
@GraphQLObject("KadastraalObject")
public class KadastraalObject {


    @GraphQLField
    @GraphQLDescription("Het unieke id van een Kadastraal Object")
    public Identificatie identificatie = new Identificatie();

    @GraphQLField
    @GraphQLDescription("De Kadastrale aanduiding van een Kadastraal Object")
    public KadastraleAanduiding aanduiding = new KadastraleAanduiding();
    @GraphQLField
    @GraphQLDescription("De grootte van een Perceel")
    public KadastraleGrootte grootte = new KadastraleGrootte();
//    public String typeGrens;
//    public Koopsom koopsom;
//
//    private List<Aantekening> aantekeningen = new ArrayList<>();
//    public List<ZakelijkRecht> rechten = new ArrayList<>(); //platgeslagen lijst van rechten
//    public List<Zekerheidsstelling> zekerheidsstellingen = new ArrayList<>();
//
//    public List<Aantekening> getAantekeningen() {
//        //filtered list met aleen aantekening voor object zelf. Tenaamstelling aantekeningen worden daar getoond
//        //TODO java 8 : use filter
//        ArrayList<Aantekening> result = new ArrayList<>();
//        for (Aantekening aantekening : aantekeningen) {
//            if (aantekening.getTenaamstellingen().isEmpty()) {
//                result.add(aantekening);
//            }
//        }
//        return result;
//    }
//
//    @JsonIgnore
//    public List<Aantekening> getAantekeningenIntern() {
//        return aantekeningen;
//    }
//
//    @Override
//    public String toString() {
//        return "KadastraalObject:" + identificatie;
//    }
//
//    @Override
//    public int hashCode() {
//        return HashCodeBuilder.reflectionHashCode(this);
//    }
//
//    @Override
//    public boolean equals(Object that) {
//        boolean result = EqualsBuilder.reflectionEquals(this, that);
//        LoggerFactory.getLogger(this.getClass()).debug("equals:" + result);
//        return result;
//    }
//
//    public void removeZekerheidsstelling(ZekerheidsstellingId identificatie) {
//        Iterator<Zekerheidsstelling> it = zekerheidsstellingen.iterator();
//        while (it.hasNext()) {
//            Zekerheidsstelling zekerheidsstelling = it.next();
//            if (zekerheidsstelling.identificatie.compositeId.equals(identificatie.getId())) {
//                it.remove();
//                break;
//            }
//        }
//    }
//
//    public Zekerheidsstelling findZekerheidsstelling(String zekerheidsstellingId ) {
//        Iterator<Zekerheidsstelling> it = zekerheidsstellingen.iterator();
//        while (it.hasNext()) {
//            Zekerheidsstelling zekerheidsstelling = it.next();
//            if (zekerheidsstelling.identificatie.compositeId.equals(zekerheidsstellingId)) {
//                return zekerheidsstelling;
//             }
//        }
//        return null;
//    }
//
//    public nl.kadaster.brk.graphql.tenaamstelling.Tenaamstelling findTenaamstelling(String tenaamstellingId) {
//        for (ZakelijkRecht zakelijkRecht : rechten) {
//            nl.kadaster.brk.graphql.tenaamstelling.Tenaamstelling tns = zakelijkRecht.findTenaamStelling(tenaamstellingId);
//            if (tns != null) {
//                return tns;
//            }
//        }
//        return null;
//    }
//
//    public ZakelijkRecht findZakelijkRecht(String id) {
//        for (ZakelijkRecht zakelijkRecht : rechten) {
//            if (zakelijkRecht.identificatie.compositeId.equals(id) ){
//                return zakelijkRecht;
//            }
//        }
//        return null;
//    }
//
//    public KoopovereenkomstAantekening findKoopovereenkomstAantekening(String aantekeningId) {
//        for (ZakelijkRecht recht : rechten) {
//            for (nl.kadaster.brk.graphql.tenaamstelling.Tenaamstelling tenaamstelling : recht.tenaamstellingen) {
//                for (Aantekening aantekening : tenaamstelling.getAantekeningen()) {
//                    if (aantekening.identificatie.compositeId.equals(aantekeningId)) {
//                        if (aantekening instanceof KoopovereenkomstAantekening) {
//                            return (KoopovereenkomstAantekening) aantekening;
//                        } else {
//                            return null;
//                        }
//
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//
//    public void verwijderAantekening(String aantekeningId) {
//        Aantekening.removeAantekeningFromList(aantekeningId,aantekeningen);
//        // zoek aantekening ook in tenaamstellingen
//        for (ZakelijkRecht recht : rechten) {
//            for (nl.kadaster.brk.graphql.tenaamstelling.Tenaamstelling tenaamstelling : recht.tenaamstellingen) {
//                tenaamstelling.verwijderAantekening(aantekeningId);
//            }
//        }
//
//    }
//
//
//
//    public Aantekening findAantekening(String aantekeningId) {
//        for (Aantekening aantekening : aantekeningen) {
//            if (aantekeningId.equals(aantekening.identificatie.compositeId))  {
//                return aantekening;
//            }
//        }
//        return null;
//    }
//
//    public List<nl.kadaster.brk.graphql.tenaamstelling.Tenaamstelling> findTenaamstellingen(Set<TenaamstellingId> betreft) {
//        ArrayList<nl.kadaster.brk.graphql.tenaamstelling.Tenaamstelling> tenaamstellingen = new ArrayList<>();
//        for (TenaamstellingId id : betreft) {
//            nl.kadaster.brk.graphql.tenaamstelling.Tenaamstelling tns = this.findTenaamstelling(id.getId());
//            if (tns!=null) {
//                tenaamstellingen.add(tns);
//            }
//        }
//        return tenaamstellingen;
//    }
//
//
//    public void verwijderRecht(ZakelijkRechtId identificatie) {
//        Iterator<ZakelijkRecht> it = rechten.iterator();
//        while (it.hasNext()) {
//            ZakelijkRecht recht = it.next();
//            if (recht.identificatie.compositeId.equals(identificatie.getId())) {
//                it.remove();
//                break;
//            }
//        }
//    }
}

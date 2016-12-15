package nl.kadaster.koers.view.inzage.api.zekerheidsstelling;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import nl.kadaster.brk.datatype.BepaaldAandeel;
import nl.kadaster.koers.view.inzage.api.CodeWaarde;
import nl.kadaster.koers.view.inzage.api.Identificatie;

import java.util.ArrayList;
import java.util.List;

import static nl.kadaster.koers.view.inzage.api.zekerheidsstelling.Zekerheidsstelling.BESLAG;
import static nl.kadaster.koers.view.inzage.api.zekerheidsstelling.Zekerheidsstelling.HYPOTHECAIR;

/**
 * @author Marc van Andel
 * @since 0.1
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,  property = "typeZekerheidsstelling", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = BeslagZekerheidsstelling.class, name = BESLAG),//
    @JsonSubTypes.Type(value = HypothecaireZekerheidsstelling.class, name = HYPOTHECAIR)
})
public class Zekerheidsstelling {

    public static final String BESLAG = "BESLAG";
    public static final String HYPOTHECAIR = "HYPOTHECAIR";

    @JsonIgnore
    public String typeZekerheidsstelling;
    public Identificatie identificatie = new Identificatie();
    public CodeWaarde betrokkenRecht;
    public BepaaldAandeel aandeelInBetrokkenRecht;
    public Identificatie stukdeel;
    public List<Identificatie> personen = new ArrayList<>();
}

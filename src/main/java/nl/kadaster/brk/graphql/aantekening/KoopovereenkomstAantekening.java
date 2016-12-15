package nl.kadaster.brk.graphql.aantekening;

import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Marc van Andel
 * @since 0.1
 */
@JsonInclude(NON_NULL)
public class KoopovereenkomstAantekening extends Aantekening {

    /**
     * Einddatum van de koopovereenkomst.
     */
    public String einddatum;
    /**
     * Tijdstip waarop de aantekening komt te vervallen.
     */
    public String tijdstipVervallen;

}

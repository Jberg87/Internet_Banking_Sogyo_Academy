package nl.sogyo.jesper;

import junit.framework.Assert;
import junit.framework.TestCase;

public class BetaalRekeningTest extends TestCase {

    public void testOpenRekening_0euro() throws Exception {
        Klant jan = new Klant();
        jan.openBetaalRekening(0);
        Assert.assertEquals(0, jan.getBetaalRekening().getSaldo());
        Assert.assertEquals(jan, jan.getBetaalRekening().getEigenaar());
    }

    public void testBetaal(){
        Klant jan = new Klant();
        Klant kees = new Klant();
        jan.openBetaalRekening(100);
        kees.openBetaalRekening(0);
        jan.betaal(bedrag, rekeningnummer);

    }


}
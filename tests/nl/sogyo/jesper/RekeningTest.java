package nl.sogyo.jesper;

import junit.framework.Assert;
import junit.framework.TestCase;

public class RekeningTest extends TestCase {

    public void test_getEigenaar() {
        Klant jan = new Klant();
        jan.openBetaalRekening();
        jan.openSpaarRekening();
        Assert.assertEquals(jan, jan.getBetaalRekening().getEigenaar());
        Assert.assertEquals(jan, jan.getSpaarRekening(1).getEigenaar());
        Assert.assertEquals(jan, jan.getSpaarRekening(2).getEigenaar());
    }
}
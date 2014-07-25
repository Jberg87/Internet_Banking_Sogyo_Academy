package nl.sogyo.jesper;

import junit.framework.Assert;
import junit.framework.TestCase;

public class KlantTest extends TestCase {

    public void test_Open_betaalekening() {
        Klant jan = new Klant();
        jan.openBetaalRekening();
        Assert.assertEquals(jan, jan.getBetaalRekening().getEigenaar());
        Assert.assertEquals(0, jan.getBetaalRekening().getSaldo());
    }

    public void test_Storten_eigen_betaalrekening() throws Exception {
        Klant jan = new Klant();
        jan.openBetaalRekening();
        jan.storten(100, jan.getBetaalRekening());
        Assert.assertEquals(100, jan.getBetaalRekening().getSaldo());
        Assert.assertEquals(jan, jan.getBetaalRekening().getEigenaar());
    }

    public void test_Storten_andermans_betaalrekening() throws Exception {
        Klant jan = new Klant();
        Klant kees = new Klant();
        jan.openBetaalRekening();
        kees.openBetaalRekening();
        jan.storten(100, jan.getBetaalRekening());
        Assert.assertEquals(100, jan.getBetaalRekening().getSaldo());
        Assert.assertEquals(0, kees.getBetaalRekening().getSaldo());
    }

    public void testBetaal_met_eigen_rekening(){
        Klant jan = new Klant();
        Klant kees = new Klant();
        jan.openBetaalRekening();
        kees.openBetaalRekening();
        jan.storten(100, jan.getBetaalRekening());
        jan.maakOver(70, jan.getBetaalRekening(),kees.getBetaalRekening());
        Assert.assertEquals(30,jan.getBetaalRekening().getSaldo());
        Assert.assertEquals(70,kees.getBetaalRekening().getSaldo());
    }

    public void testBetaal_te_weinig_geld(){
        Klant jan = new Klant();
        Klant kees = new Klant();
        jan.openBetaalRekening();
        kees.openBetaalRekening();
        jan.storten(50, jan.getBetaalRekening());
        jan.maakOver(70, jan.getBetaalRekening(),kees.getBetaalRekening());
        Assert.assertEquals(50,jan.getBetaalRekening().getSaldo());
        Assert.assertEquals(0,kees.getBetaalRekening().getSaldo());
    }

    public void testBetaal_met_andersmans_rekening(){
        Klant jan = new Klant();
        Klant kees = new Klant();
        jan.openBetaalRekening();
        kees.openBetaalRekening();
        jan.storten(100, jan.getBetaalRekening());
        jan.maakOver(70, kees.getBetaalRekening(),kees.getBetaalRekening());
        Assert.assertEquals(100,jan.getBetaalRekening().getSaldo());
        Assert.assertEquals(0,kees.getBetaalRekening().getSaldo());
    }

}
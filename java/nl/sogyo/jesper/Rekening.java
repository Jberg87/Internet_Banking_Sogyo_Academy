package nl.sogyo.jesper;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jesper on 25-7-2014.
 */
public abstract class Rekening {
    protected static ArrayList<String> gebruikteRekeningNummers = new ArrayList<String>();

    protected int rekeningNummer;
    protected int saldo;
    protected Klant eigenaar;
    protected ArrayList<Record> recordArrayList = new ArrayList<Record>();


    public Klant getEigenaar() {
        return eigenaar;
    }

    public int getSaldo() {
        return saldo;
    }

    public void ontvang(int bedrag) {
        saldo += bedrag;
    }

    public void addRecordToRecordArrayList(Transactie transactie) {
        recordArrayList.add(new Record(getEigenaar(), getSaldo(), transactie));
    }

    public void schrijfAf(int bedrag) {
        saldo -= bedrag;
    }












    protected void setRekeningNummer() {
    gebruikteRekeningNummers.add(genereerUniekRekeningNummer());    }

    protected String genereerUniekRekeningNummer() {
        boolean origineelRekeningNummerGevonden = false;
        long testRekeningNummerLong = 0;

        while (!origineelRekeningNummerGevonden) {
            testRekeningNummerLong = (long) Math.random() * 1000000000;
            String testRekeningNummerString = Long.toString(testRekeningNummerLong);

            if (testRekeningNummerString.length() < 9 ) {
                testRekeningNummerString = vulAanMetNullen(testRekeningNummerString);
            }

            for (String bestaandRekeningNummer : gebruikteRekeningNummers) {
                if (testRekeningNummerString.equals(bestaandRekeningNummer)) {
                    continue;
                } else {
                    return testRekeningNummerString;
                }
            }
        }
        System.out.println("Geen origineel rekeningnummer gevonden, abort all plz");
        return "";
    }

    private String vulAanMetNullen(String testRekeningNummerString) {

            String newTestRekeningNummerString = "";
            for (int i = 1; i <= 9 - testRekeningNummerString.length(); i++){
                testRekeningNummerString = "0".concat(testRekeningNummerString);
            }
        return testRekeningNummerString;
    }

}

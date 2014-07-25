package nl.sogyo.jesper;

/**
 * Created by Jesper on 25-7-2014.
 */
public class BetaalRekening extends Rekening {

    private int maandelijksGestortBedrag;
    private String pincode;
    private boolean heeftMaandPositiefGestaan;


    public BetaalRekening(Klant klant) {
        eigenaar = klant;
        saldo = 0;
        Transactie transactie = new Transactie(0, null, this);
        recordArrayList.add(new Record(getEigenaar(),getSaldo(), transactie));
    }
}

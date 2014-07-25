package nl.sogyo.jesper;

/**
 * Created by Jesper on 25-7-2014.
 */
public class BetaalRekening extends Rekening {

    private int saldo, maandelijksGestortBedrag;
    private Klant eigenaar;
    private String pincode;
    private boolean heeftMaandPositiefGestaan;

    public BetaalRekening (int beginSaldo) {
        saldo = beginSaldo;
    }

    @Override
    public void geldOvermaken(int bedrag) {

    }

    public Klant getEigenaar() {
        return eigenaar;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo (int bedrag) {
        saldo += bedrag;
    }
}

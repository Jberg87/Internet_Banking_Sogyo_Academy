package nl.sogyo.jesper;

/**
 * Created by Jesper on 25-7-2014.
 */
public abstract class Rekening {

    protected int rekeningNummer;
    protected int saldo;
    protected Klant eigenaar;

    public Klant getEigenaar() {
        return eigenaar;
    }

    public int getSaldo() {
        return saldo;
    }

    public void ontvang (int bedrag) {
        saldo += bedrag;
    }

    public void schrijfAf(int bedrag) {
       saldo -= bedrag;
    }
}

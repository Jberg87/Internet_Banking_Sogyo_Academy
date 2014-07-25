package nl.sogyo.jesper;

/**
 * Created by Jesper on 25-7-2014.
 */
public class SpaarRekening extends Rekening{

    public SpaarRekening(Klant klant) {
        eigenaar = klant;
        saldo = 0;
        Transactie transactie = new Transactie(0, null, this);
        recordArrayList.add(new Record(getEigenaar(),getSaldo(), transactie));
    }
}

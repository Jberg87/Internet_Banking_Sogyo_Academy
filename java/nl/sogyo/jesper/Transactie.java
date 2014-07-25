package nl.sogyo.jesper;

/**
 * Created by Jesper on 25-7-2014.
 */
public class Transactie {
    private int bedrag;
    private Rekening betalendeRekening, ontvangendeRekening;

    public Transactie(int bedrag, Rekening betalendeRekening, Rekening ontvangendeRekening) {
        this.bedrag = bedrag;
        this.betalendeRekening = betalendeRekening;
        this.ontvangendeRekening = ontvangendeRekening;
    }
}

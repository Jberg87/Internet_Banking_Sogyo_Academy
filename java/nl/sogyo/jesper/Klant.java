package nl.sogyo.jesper;

/**
 * Created by Jesper on 25-7-2014.
 */
public class Klant {
    private BetaalRekening betaalRekening;

    public void openBetaalRekening () {
        if (this.betaalRekening == null) {
            this.betaalRekening = new BetaalRekening(this);
        } else {
            System.out.println("Klant heeft al een betaalrekening");
        }
    }


    public void maakOver(int bedrag, Rekening betalendeRekenening, Rekening ontvangendeRekening) {
        if (isEigenaarRekening(betalendeRekenening) && voldoendeSaldo(betalendeRekenening, bedrag) ) {
            betalendeRekenening.schrijfAf(bedrag);
            ontvangendeRekening.ontvang(bedrag);

            Transactie transactie = new Transactie(bedrag, betalendeRekenening, ontvangendeRekening);
            betalendeRekenening.addRecordToRecordArrayList(transactie);
            ontvangendeRekening.addRecordToRecordArrayList(transactie);
        }
    }

    private boolean voldoendeSaldo(Rekening betalendeRekenening, int bedrag) {
        return (betalendeRekenening.getSaldo() >= bedrag) ? true : false;
    }

    private boolean isEigenaarRekening(Rekening rekening) {
        return (rekening.getEigenaar() == this) ? true : false;
    }

    public BetaalRekening getBetaalRekening() {
        return betaalRekening;
    }

    public void storten(int bedrag, Rekening ontvangendeRekening) {
        if (ontvangendeRekening.getEigenaar() == this) {
            ontvangendeRekening.ontvang(bedrag);

            Transactie transactie = new Transactie(bedrag, null, ontvangendeRekening);
            ontvangendeRekening.addRecordToRecordArrayList(transactie);

        } else {
            System.out.println("De storter is niet de eigenaar van de opgegegven rekening");
        }
    }
}

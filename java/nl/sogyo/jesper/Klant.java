package nl.sogyo.jesper;

import java.util.ArrayList;

/**
 * Created by Jesper on 25-7-2014.
 */
public class Klant {
    private BetaalRekening betaalRekening;
    private ArrayList<SpaarRekening> spaarRekeningArrayList = new ArrayList<SpaarRekening>();
    private RekeningCourant courantRekening;

    public void openBetaalRekening (int bedrag) {
        if (this.betaalRekening == null) {
            this.betaalRekening = new BetaalRekening(bedrag);
            betaalRekening.setSaldo(bedrag);
        }
    }

    public BetaalRekening getBetaalRekening() {
        return betaalRekening;
    }
}

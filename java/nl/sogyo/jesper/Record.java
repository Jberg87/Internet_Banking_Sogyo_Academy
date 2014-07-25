package nl.sogyo.jesper;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jesper on 25-7-2014.
 */
public class Record {
    private Date date;
    private Klant eigenaar;
    private int saldoNaRecord;
    private Transactie transactie;


    public Record(Klant eigenaar, int saldo, Transactie transactie) {
        setDate();
        this.eigenaar = eigenaar;
        this.saldoNaRecord = saldo;
        this.transactie = transactie;
    }

    public void setDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        this.date =  cal.getTime();
    }
}

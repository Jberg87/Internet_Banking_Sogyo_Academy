package nl.sogyo.jesper;

import java.util.ArrayList;

/**
 * Created by Jesper on 25-7-2014.
 */
public abstract class Rekening {

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

    public Record getRekeningRecord(Transactie transactie) {
        Record record = new Record(getEigenaar(), getSaldo(), transactie);
        return record;
    }

}

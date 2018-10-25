package ba.fit.app.hci_odbrana.podaci;

import java.io.Serializable;

/**
 * Created by Adil on 18/06/2016.
 */
public class OpstinaVM implements Serializable
{
    private int id;
    private String naziv;
    private String drzava;

    public OpstinaVM(int id, String naziv, String drzava) {
        this.id = id;
        this.naziv = naziv;
        this.drzava = drzava;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }
}
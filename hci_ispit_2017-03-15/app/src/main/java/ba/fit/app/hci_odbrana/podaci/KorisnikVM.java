package ba.fit.app.hci_odbrana.podaci;

import java.io.Serializable;

/**
 * Created by Adil on 18/06/2016.
 */
public class KorisnikVM implements Serializable
{
    private String ime;
    private String prezime;
    private OpstinaVM opstinaVM;
    private String adresa;

    public KorisnikVM(String ime, String prezime, OpstinaVM opstinaVM, String adresa) {
        this.ime = ime;
        this.prezime = prezime;
        this.opstinaVM = opstinaVM;
        this.adresa = adresa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() { return adresa; }

    public OpstinaVM getOpstinaVM() {
        return opstinaVM;
    }

    public void setOpstinaVM(OpstinaVM opstinaVM) {
        this.opstinaVM = opstinaVM;
    }
}

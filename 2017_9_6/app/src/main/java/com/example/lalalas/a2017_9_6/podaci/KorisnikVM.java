package com.example.lalalas.a2017_9_6.podaci;

import java.io.Serializable;

/**
 * Created by Adil on 18/06/2016.
 */
public class KorisnikVM implements Serializable
{
    private String ime;
    private String prezime;
    private String adresaOpstina;

    public KorisnikVM() {
    }

    public KorisnikVM(String ime, String prezime, String adresaOpstina) {
        this.ime = ime;
        this.prezime = prezime;
        this.adresaOpstina = adresaOpstina;
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

    public String getAdresaOpstina() {
        return adresaOpstina;
    }

    public void setAdresaOpstina(String adresaOpstina) {
        this.adresaOpstina = adresaOpstina;
    }
}

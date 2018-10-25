package com.example.lalalas.hci_ispit_2017_6_14.podaci;

import java.io.Serializable;

/**
 * Created by Adil on 02/02/2017.
 */

public class PosiljkaVM implements Serializable {
	private static int brojac=0;
    public KorisnikVM posljiaoc;
    public KorisnikVM primaoc;
    public float masa;
    public boolean naplatiPouzecem;
    public Double iznosNaplate;

	public int brojPosiljke;
    public String napomena;

    public PosiljkaVM(KorisnikVM posljiaoc, KorisnikVM primaoc, float masa, boolean naplatiPouzecem, Double iznosNaplate) {
        this.posljiaoc = posljiaoc;
        this.primaoc = primaoc;
        this.masa = masa;
        this.naplatiPouzecem = naplatiPouzecem;
        this.iznosNaplate = iznosNaplate;
        brojPosiljke = brojac++;
    }

    public PosiljkaVM()
    {

    }
}

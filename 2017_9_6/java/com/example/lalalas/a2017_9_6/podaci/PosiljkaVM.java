package com.example.lalalas.a2017_9_6.podaci;

import android.widget.SearchView;

import java.io.Serializable;

/**
 * Created by Adil on 02/02/2017.
 */

public class PosiljkaVM  implements Serializable{
	private static int brojac=0;
    public KorisnikVM posljiaoc;
    public KorisnikVM primaoc;
    public float masa;
    public boolean naplatiPouzecem;
    public Double iznosNaplate;

	public int brojPosiljke;
    public String napomena;

    public PosiljkaVM(KorisnikVM posljiaoc, KorisnikVM primaoc, float masa, boolean naplatiPouzecem, Double iznosNaplate, String napomena) {
        this.posljiaoc = posljiaoc;
        this.primaoc = primaoc;
        this.masa = masa;
        this.naplatiPouzecem = naplatiPouzecem;
        this.iznosNaplate = iznosNaplate;
        this.brojPosiljke = brojac++;
        this.napomena = napomena;
    }

    public PosiljkaVM()
    {

    }
}

package ba.fit.app.hci_odbrana.podaci;

import java.io.Serializable;

/**
 * Created by Adil on 02/02/2017.
 */

public class PosiljkaVM implements Serializable {
	private static int brojac=0;
    public KorisnikVM posljiaoc;
    public KorisnikVM primaoc;
    public float masa;

	public int brojPosiljke;
    public String napomena;

    public PosiljkaVM(KorisnikVM posljiaoc, KorisnikVM primaoc, float masa) {
        this.posljiaoc = posljiaoc;
        this.primaoc = primaoc;
        this.masa = masa;
		brojPosiljke = brojac++;
    }

    public PosiljkaVM()
    {

    }
}

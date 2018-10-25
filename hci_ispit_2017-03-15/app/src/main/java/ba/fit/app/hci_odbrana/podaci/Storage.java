package ba.fit.app.hci_odbrana.podaci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adil on 18/06/2016.
 */
public class Storage {
    private static int brojacPosiljki;

    private static List<OpstinaVM> opstine;
    public static List<OpstinaVM> getOpstineAll()
    {
        if (opstine == null)
        {
            opstine = new ArrayList<>();
            opstine.add(new OpstinaVM(1, "Mostar", "BiH"));
            opstine.add(new OpstinaVM(2, "Sarajevo", "BiH"));
            opstine.add(new OpstinaVM(3, "Tuzla", "BiH"));
            opstine.add(new OpstinaVM(4, "Banja Luka", "BiH"));
            opstine.add(new OpstinaVM(5, "Zagreb", "Hrvatska"));
            opstine.add(new OpstinaVM(6, "Tuzla", "BiH"));
            opstine.add(new OpstinaVM(7, "Goražde", "BiH"));
            opstine.add(new OpstinaVM(8, "Konjic", "BiH"));
        }
        return opstine;
    }

    private static List<KorisnikVM> korisnici;
    public static List<KorisnikVM> getKorisniciAll()
    {
        if (korisnici == null)
        {
            korisnici = new ArrayList<>();
            korisnici.add(new KorisnikVM("E.", "Junuz", getOpstineAll().get(0), "sjeverni logor"));
            korisnici.add(new KorisnikVM("A.", "Joldic", getOpstineAll().get(7), "sjeverni logor"));
            korisnici.add(new KorisnikVM("E.", "Sudic", getOpstineAll().get(5), "sjeverni logor"));
            korisnici.add(new KorisnikVM("M.", "Herceg", getOpstineAll().get(2), "sjeverni logor"));
        }
        return korisnici;
    }

    public static List<KorisnikVM> getKorisniciByName(String name)
    {
        List<KorisnikVM> rezultat = new ArrayList<>();
        for (KorisnikVM x : getKorisniciAll()) {
            if ((x.getIme() + " " + x.getPrezime()).toLowerCase().startsWith(name.toLowerCase()) || (x.getPrezime() + " " + x.getIme()).toLowerCase().startsWith(name.toLowerCase()))
            {
                rezultat.add(x);
            }
        }
        return rezultat;
    }

    private static List<PosiljkaVM> posilje;
    public static List<PosiljkaVM> getPosiljkeAll()
    {
        if (posilje == null)
        {
            posilje = new ArrayList<>();
            posilje.add(new PosiljkaVM(getKorisniciAll().get(0), getKorisniciAll().get(1), 15));
            posilje.add(new PosiljkaVM(getKorisniciAll().get(2), getKorisniciAll().get(3), 15));
            posilje.add(new PosiljkaVM(getKorisniciAll().get(3), getKorisniciAll().get(0), 105));
            posilje.add(new PosiljkaVM(getKorisniciAll().get(0), getKorisniciAll().get(1), 5));
        }
        return posilje;
    }

    public static void AddPosiljka(PosiljkaVM novaPosiljka){
        novaPosiljka.brojPosiljke= brojacPosiljki++;

        getPosiljkeAll().add(novaPosiljka);

    }

}

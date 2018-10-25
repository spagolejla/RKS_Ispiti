package ba.fit.app.hci_odbrana.helper;

import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import ba.fit.app.hci_odbrana.R;



public class Util {

    public static void otvoriFragmentKaoReplace(Activity activity, int id, Fragment fragment)
    {
        final FragmentManager fm = ((FragmentActivity)activity).getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }

    public static void otvoriFragmentKaoDijalog(Activity activity, DialogFragment fragment) {
        final FragmentManager fm = ((FragmentActivity)activity).getSupportFragmentManager();
        fragment.show(fm, "tag");
    }
}

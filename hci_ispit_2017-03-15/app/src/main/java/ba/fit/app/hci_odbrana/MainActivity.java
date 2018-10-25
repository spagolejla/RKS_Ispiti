package ba.fit.app.hci_odbrana;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ba.fit.app.hci_odbrana.fragments.Fragment1;
import ba.fit.app.hci_odbrana.helper.Util;
import ba.fit.app.hci_odbrana.podaci.KorisnikVM;
import ba.fit.app.hci_odbrana.podaci.OpstinaVM;
import ba.fit.app.hci_odbrana.podaci.PosiljkaVM;
import ba.fit.app.hci_odbrana.podaci.Storage;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Util.otvoriFragmentKaoReplace(this,R.id.fragmentPlace,Fragment1.newInstance());



    }
}

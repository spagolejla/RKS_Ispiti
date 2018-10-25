package com.example.lalalas.a2017_2_2.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.lalalas.a2017_2_2.R;
import com.example.lalalas.a2017_2_2.helper.MyRunnable;
import com.example.lalalas.a2017_2_2.helper.Util;
import com.example.lalalas.a2017_2_2.podaci.KorisnikVM;
import com.example.lalalas.a2017_2_2.podaci.PosiljkaVM;

public class Fragment1 extends Fragment {

    private static String POSILJKA_KEY="posiljka_key";
    private PosiljkaVM posiljkaVM=new PosiljkaVM();

    private EditText txtIme;
    private EditText txtPrezime;
    private EditText txtAdresa;
    private Button btnPromjeni;
    private Button btnOdustani;
    private Button btnDalje;

    public Fragment1() {
        // Required empty public constructor
    }

    public static Fragment1 newInstance() {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_fragment1, container, false);

        txtIme=view.findViewById(R.id.txtImePosiljaoca);
        txtPrezime=view.findViewById(R.id.txtPrezimePosiljaoca);
        txtAdresa=view.findViewById(R.id.txtAdresaPosiljaoca);
        btnPromjeni=view.findViewById(R.id.btnPromjeniPosiljoaca);
        btnDalje=view.findViewById(R.id.btnDalje);
        btnOdustani=view.findViewById(R.id.btnOdustani);

        btnPromjeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_btnPromjeniClick();
            }
        });

        btnDalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.otvoriFragmentKaoReplace(getActivity(),R.id.fragmentPlace,Fragment2.newInstance(posiljkaVM));
            }
        });

        btnOdustani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub

                System.exit(0);
            }
        });
        return view;
    }

    private void do_btnPromjeniClick() {

        MyRunnable callback=new MyRunnable<KorisnikVM>() {
            @Override
            public void run(KorisnikVM x) {
                posiljkaVM.posljiaoc=x;
                txtIme.setText(x.getIme());
                txtPrezime.setText(x.getPrezime());
                txtAdresa.setText(x.getOpstinaVM().getNaziv());

            }
        };

        Util.otvoriFragmentKaoDijalog(getActivity(),PretragaDialogFragment.newInstance(callback));

    }


}

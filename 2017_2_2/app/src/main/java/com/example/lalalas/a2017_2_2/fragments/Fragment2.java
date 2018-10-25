package com.example.lalalas.a2017_2_2.fragments;

import android.content.Context;
import android.net.Uri;
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


public class Fragment2 extends Fragment {
    private static String POSILJKA_KEY="posiljka_key";
    private PosiljkaVM posiljkaVM;

    private EditText txtIme;
    private EditText txtPrezime;
    private EditText txtAdresa;
    private Button btnPromjeni;
    private Button btnNazad;
    private Button btnDalje;


    public Fragment2() {
        // Required empty public constructor
    }

    public static Fragment2 newInstance(PosiljkaVM posiljka) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putSerializable(POSILJKA_KEY,posiljka);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
         posiljkaVM=(PosiljkaVM)getArguments().getSerializable(POSILJKA_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment2, container, false);

        txtIme=view.findViewById(R.id.txtImePrimaoca);
        txtPrezime=view.findViewById(R.id.txtPrezimePrimaoca);
        txtAdresa=view.findViewById(R.id.txtAdresaPrimaoca);
        btnPromjeni=view.findViewById(R.id.btnPromjeniPrimaoca);
        btnDalje=view.findViewById(R.id.btnDalje);
        btnNazad=view.findViewById(R.id.btnNazad);

        btnNazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.otvoriFragmentKaoReplace(getActivity(),R.id.fragmentPlace,Fragment1.newInstance());
            }
        });

        btnPromjeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_btnPromjeniClick();
            }
        });

        btnDalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.otvoriFragmentKaoReplace(getActivity(),R.id.fragmentPlace,Fragment3.newInstance(posiljkaVM));
            }
        });
        return view;
    }

    private void do_btnPromjeniClick() {

        MyRunnable callback=new MyRunnable<KorisnikVM>() {
            @Override
            public void run(KorisnikVM x) {
                posiljkaVM.primaoc=x;
                txtIme.setText(x.getIme());
                txtPrezime.setText(x.getPrezime());
                txtAdresa.setText(x.getOpstinaVM().getNaziv());

            }
        };

        Util.otvoriFragmentKaoDijalog(getActivity(),PretragaDialogFragment.newInstance(callback));

    }


}

package com.example.lalalas.a2017_9_6.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.lalalas.a2017_9_6.R;
import com.example.lalalas.a2017_9_6.helper.MyRunnable;
import com.example.lalalas.a2017_9_6.helper.Util;
import com.example.lalalas.a2017_9_6.podaci.KorisnikVM;
import com.example.lalalas.a2017_9_6.podaci.PosiljkaVM;


public class Fragment1 extends Fragment {

private PosiljkaVM posiljkaVM=new PosiljkaVM();

   private EditText txtImePrimaoca;
    private EditText txtAdresaPrimaoca;
    private Button btnPromjeniPrimaoca;

    private EditText txtImePosiljaoca;
    private EditText txtAdresaPosiljaoca;
    private Button btnPromjeniPosiljaoca;
    private Button btnDalje;
    public Fragment1() {
        // Required empty public constructor
    }


    public static Fragment1 newInstance() {
        Fragment1 fragment = new Fragment1();

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
         View view=inflater.inflate(R.layout.fragment_fragment1, container, false);


         txtImePrimaoca=view.findViewById(R.id.txtImePrimaoca);
         txtAdresaPrimaoca=view.findViewById(R.id.txtAdresaPrimaoca);
         btnPromjeniPrimaoca=view.findViewById(R.id.btnPromjeniPrimaoca);

        txtImePosiljaoca=view.findViewById(R.id.txtImePosiljaoca);
        txtAdresaPosiljaoca=view.findViewById(R.id.txtAdresaPosiljaoca);
        btnPromjeniPosiljaoca=view.findViewById(R.id.btnPromjeniPosiljoaca);
btnDalje=view.findViewById(R.id.btnDalje);
         btnPromjeniPrimaoca.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 do_btnPromjeniPrimacaClick();
             }
         });


         btnPromjeniPosiljaoca.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 do_btnPromjeniPosiljaocaClick();
             }
         });


        btnDalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.otvoriFragmentKaoReplace(getActivity(),R.id.fragmentPlace,Fragment2.newInstance(posiljkaVM));
            }
        });
        return view;
    }

    private void do_btnPromjeniPosiljaocaClick() {
        final MyRunnable callback=new MyRunnable<KorisnikVM>() {
            @Override
            public void run(KorisnikVM x) {
                posiljkaVM.primaoc=x;

                txtImePosiljaoca.setText(x.getIme()+" "+x.getPrezime());
                txtAdresaPosiljaoca.setText(x.getAdresaOpstina());



            }
        };


        Util.otvoriFragmentKaoDijalog(getActivity(),PretragaDialogFragment.newInstance(callback));


    }

    private void do_btnPromjeniPrimacaClick() {

        final MyRunnable callback=new MyRunnable<KorisnikVM>() {
            @Override
            public void run(KorisnikVM x) {
                posiljkaVM.primaoc=x;

                txtImePrimaoca.setText(x.getIme()+" "+x.getPrezime());
                txtAdresaPrimaoca.setText(x.getAdresaOpstina());



            }
        };


        Util.otvoriFragmentKaoDijalog(getActivity(),PretragaDialogFragment.newInstance(callback));



    }


}

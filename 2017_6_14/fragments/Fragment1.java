package com.example.lalalas.hci_ispit_2017_6_14.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.lalalas.hci_ispit_2017_6_14.R;
import com.example.lalalas.hci_ispit_2017_6_14.helper.MyRunnable;
import com.example.lalalas.hci_ispit_2017_6_14.helper.Util;
import com.example.lalalas.hci_ispit_2017_6_14.podaci.KorisnikVM;
import com.example.lalalas.hci_ispit_2017_6_14.podaci.PosiljkaVM;

public class Fragment1 extends Fragment {

    private PosiljkaVM posiljkaVM=new PosiljkaVM();
    private EditText txtPrimaoc;
    private EditText txtAdresaPrimaoc;
    private EditText txtPosiljaoc;
    private EditText txtAdresaPosiljaoc;
    private Button btnPromjeniPrimaoca;
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

         txtPrimaoc=(EditText)view.findViewById(R.id.txtPrimaoc);
        txtAdresaPrimaoc=(EditText)view.findViewById(R.id.txtAdresaPrimaoca);
        txtPosiljaoc=(EditText)view.findViewById(R.id.txtPosiljaoc);
        txtAdresaPosiljaoc=(EditText)view.findViewById(R.id.txtAdresaPosiljaoca);

        btnPromjeniPrimaoca=(Button)view.findViewById(R.id.btnPromjeniPrimaoca);
        btnPromjeniPosiljaoca=(Button)view.findViewById(R.id.btnPromjeniPosiljaoca);
btnDalje=(Button)view.findViewById(R.id.btnDalje);
      btnPromjeniPrimaoca.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              do_btnPromjeniPrimaoca();
          }
      });

      btnPromjeniPosiljaoca.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              do_btnPromjeniPosiljaoca();
          }
      });

      btnDalje.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              do_btnDaljeClick();
          }
      });
        return  view;
    }

    private void do_btnDaljeClick() {
        Util.otvoriFragmentKaoReplace(getActivity(),R.id.fragmentPlace,Fragment2.newInstance(posiljkaVM));
    }


    private void do_btnPromjeniPosiljaoca() {
        MyRunnable callback= new MyRunnable<KorisnikVM>() {
            @Override
            public void run(KorisnikVM result) {
                posiljkaVM.posljiaoc=result;

                txtPosiljaoc.setText(result.getIme()+" "+ result.getPrezime());
                txtAdresaPosiljaoc.setText(result.getAdresaOpstina());
            }
        };
        PretragaDialogFragment dlg=PretragaDialogFragment.newInstance(callback);
        Util.otvoriFragmentKaoDijalog(getActivity(),dlg);

    }

    private void do_btnPromjeniPrimaoca() {

        MyRunnable callbak=new MyRunnable<KorisnikVM>() {
            @Override
            public void run(KorisnikVM result) {
                posiljkaVM.primaoc=result;
                txtPrimaoc.setText(result.getIme()+result.getPrezime());
                txtAdresaPrimaoc.setText(result.getAdresaOpstina());
            }
        };


        PretragaDialogFragment dlg=PretragaDialogFragment.newInstance(callbak);
        Util.otvoriFragmentKaoDijalog(getActivity(),dlg);

    }


}

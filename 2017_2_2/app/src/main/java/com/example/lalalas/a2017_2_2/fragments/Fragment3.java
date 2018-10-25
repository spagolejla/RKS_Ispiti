package com.example.lalalas.a2017_2_2.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lalalas.a2017_2_2.R;
import com.example.lalalas.a2017_2_2.helper.Util;
import com.example.lalalas.a2017_2_2.podaci.PosiljkaVM;
import com.example.lalalas.a2017_2_2.podaci.Storage;


public class Fragment3 extends Fragment {
    private static String POSILJKA_KEY="posiljka_key";
    private PosiljkaVM posiljkaVM;

    private EditText txtMasa;
    private EditText txtNapoemna;
    private EditText txtDuzina;
    private EditText txtSirina;
    private EditText txtVisina;

    private Button btnNazad;
    private Button btnZavrsi;

    public Fragment3() {
        // Required empty public constructor
    }


    public static Fragment3 newInstance(PosiljkaVM posiljka) {
        Fragment3 fragment = new Fragment3();
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
        View view= inflater.inflate(R.layout.fragment_fragment3, container, false);

        txtMasa=view.findViewById(R.id.txtMasa);
        txtNapoemna=view.findViewById(R.id.txtNapomena);
        txtDuzina=view.findViewById(R.id.txtDuzina);
        txtSirina=view.findViewById(R.id.txtSirina);
        txtVisina=view.findViewById(R.id.txtVisina);

        btnNazad=view.findViewById(R.id.btnNazad);
        btnZavrsi=view.findViewById(R.id.btnZavrsi);

        btnNazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.otvoriFragmentKaoReplace(getActivity(),R.id.fragmentPlace,Fragment2.newInstance(posiljkaVM));
            }
        });

        btnZavrsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_btnZavrsiClick();
            }
        });
        return view;
    }

    private void do_btnZavrsiClick() {

try {
    posiljkaVM.masa = Float.parseFloat(txtMasa.getText().toString());
    posiljkaVM.duzina = Float.parseFloat(txtDuzina.getText().toString());
    posiljkaVM.sirina = Float.parseFloat(txtSirina.getText().toString());
    posiljkaVM.visina = Float.parseFloat(txtVisina.getText().toString());

    Storage.AddPosiljka(posiljkaVM);
}catch (Exception e)
{

    Toast.makeText(getContext(),"Greska! Prazna polja",Toast.LENGTH_LONG).show();

}


        final AlertDialog.Builder aldg;
        aldg = new AlertDialog.Builder(getActivity());

        aldg.setMessage("Da li želite ponoviti!");
        aldg.setPositiveButton("DA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Util.otvoriFragmentKaoReplace(getActivity(),R.id.fragmentPlace,PrikazPaketaFragment.newInstance());
            }
        });

        aldg.setNegativeButton("NE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(),"Posiljka je uspjesno spremljena!",Toast.LENGTH_LONG).show();
            }
        });
        aldg.show();
    }

}

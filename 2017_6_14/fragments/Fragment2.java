package com.example.lalalas.hci_ispit_2017_6_14.fragments;

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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.lalalas.hci_ispit_2017_6_14.R;
import com.example.lalalas.hci_ispit_2017_6_14.helper.Util;
import com.example.lalalas.hci_ispit_2017_6_14.podaci.PosiljkaVM;
import com.example.lalalas.hci_ispit_2017_6_14.podaci.Storage;

public class Fragment2 extends Fragment {
    private EditText txtMasa;
    private EditText txtNapomena;
    private EditText txtIznos;
    private Button btnZavrsi;
    private Button btnNazad;
    private Switch cbPlatiPouzecem;

    private PosiljkaVM posiljkaVM;
    private static final String POSILJKA_KEY="posiljka_key";
    public Fragment2() {
        // Required empty public constructor
    }

    public static Fragment2 newInstance(PosiljkaVM posiljkaVM) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putSerializable(POSILJKA_KEY,posiljkaVM);
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

        View view=inflater.inflate(R.layout.fragment_fragment2, container, false);

        txtMasa=(EditText)view.findViewById(R.id.txtMasa);
        txtNapomena=(EditText)view.findViewById(R.id.txtNapomena);
        txtIznos=(EditText)view.findViewById(R.id.txtIznos);
        btnNazad=(Button)view.findViewById(R.id.btnNazad);
        btnZavrsi=(Button)view.findViewById(R.id.btnZavrsi);
cbPlatiPouzecem=(Switch)view.findViewById(R.id.checkBox);

        btnZavrsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_btnZavrsiClick();
            }
        });

btnNazad.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        do_btnNazadClick();
    }
});

        return view;
    }

    private void do_btnNazadClick() {
        Util.otvoriFragmentKaoReplace(getActivity(),R.id.fragmentPlace,Fragment1.newInstance());
    }

    private void do_btnZavrsiClick() {
        final AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        adb.setTitle("Pitanje?");
        adb.setMessage("Da li ste sigurni?");

        adb.setPositiveButton("DA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    posiljkaVM.masa = Float.parseFloat(txtMasa.getText().toString());
                    posiljkaVM.napomena = txtNapomena.getText().toString();
                    posiljkaVM.iznosNaplate = Double.parseDouble(txtIznos.getText().toString());
                    posiljkaVM.naplatiPouzecem = cbPlatiPouzecem.isSelected();

                    Storage.addPosiljka(posiljkaVM);

                }catch (Exception e)
                {
                    Toast.makeText(getContext(), "Greskka: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }



                Toast.makeText(getContext(),"Posiljka je snimljenja!",Toast.LENGTH_LONG).show();


            }
        });

        adb.setNegativeButton("Ne", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Posiljka nije snimljenja!",Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });
        adb.setIcon(android.R.drawable.ic_dialog_alert);
        adb.show();






    }





    }




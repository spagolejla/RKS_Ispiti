package com.example.lalalas.a2017_9_6.fragments;

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

import com.example.lalalas.a2017_9_6.R;
import com.example.lalalas.a2017_9_6.helper.Util;
import com.example.lalalas.a2017_9_6.podaci.PosiljkaVM;
import com.example.lalalas.a2017_9_6.podaci.Storage;


public class Fragment2 extends Fragment {


   private PosiljkaVM posiljkaVM;
private static String POSILJKA_KEY="posiljka_key";
private EditText txtMasa;
    private EditText txtNapomena;
    private EditText txtIznos;
private Button btnNazad;
    private Button btnZavrsi;

    public Fragment2() {
        // Required empty public constructor
    }


    public static Fragment2 newInstance( PosiljkaVM posiljkaVM) {
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
           this.posiljkaVM=(PosiljkaVM)getArguments().getSerializable(POSILJKA_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment2, container, false);

        txtIznos=view.findViewById(R.id.txtIznos);
        txtMasa=view.findViewById(R.id.txtMasa);
        txtNapomena=view.findViewById(R.id.txtNapomena);
        btnNazad=view.findViewById(R.id.btnNazad);
        btnZavrsi=view.findViewById(R.id.btnZavrsi);

        btnNazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_btnNazadClick();
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

        final AlertDialog.Builder adb=new AlertDialog.Builder(getActivity());

        adb.setTitle("Pitanje");
        adb.setMessage("Da li ste sigurni?");

        adb.setPositiveButton("DA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                posiljkaVM.masa=Float.parseFloat(txtMasa.getText().toString()) ;
                posiljkaVM.napomena=txtNapomena.getText().toString();
                posiljkaVM.iznosNaplate=Double.parseDouble(txtIznos.getText().toString());

                Storage.AddPosiljka(posiljkaVM);

                Toast.makeText(getContext(),"Posiljka uspjesno snimljena!",Toast.LENGTH_LONG).show();
            }
        });

        adb.setNegativeButton("NE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(),"Posiljka nije snimljena!",Toast.LENGTH_LONG).show();
            }
        });
        adb.show();




    }

    private void do_btnNazadClick() {
        Util.otvoriFragmentKaoReplace(getActivity(),R.id.fragmentPlace,Fragment1.newInstance());
    }


}

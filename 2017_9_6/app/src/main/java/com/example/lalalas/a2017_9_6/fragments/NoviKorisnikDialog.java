package com.example.lalalas.a2017_9_6.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
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
import com.example.lalalas.a2017_9_6.podaci.Storage;


public class NoviKorisnikDialog extends DialogFragment {


    MyRunnable<KorisnikVM> callback;
    private static String KORISNIK_KEY="korisnik_key";

   private EditText txtIme;
    private EditText txtPrezime;
    private EditText txtAdresa;
    private Button btnSnimi;
private String ime;
private static String IME_KEY="ime_key";
    public NoviKorisnikDialog() {
        // Required empty public constructor
    }

    public static NoviKorisnikDialog newInstance(MyRunnable MyCallback,String ime) {
        NoviKorisnikDialog fragment = new NoviKorisnikDialog();
        Bundle args = new Bundle();
      args.putSerializable(KORISNIK_KEY,MyCallback);
      args.putString(IME_KEY,ime);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           callback=(MyRunnable<KorisnikVM>)getArguments().getSerializable(KORISNIK_KEY);
           this.ime=getArguments().getString(IME_KEY);
        }

        setStyle(STYLE_NORMAL, R.style.MojDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_novi_korisnik_dialog, container, false);

        txtIme=view.findViewById(R.id.txtImeKo);
        txtPrezime=view.findViewById(R.id.txtPrezime);
        txtAdresa=view.findViewById(R.id.txtAdresa);
        btnSnimi=view.findViewById(R.id.btnSnimi);

        txtIme.setText(ime);

        btnSnimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_btnSnimiClick();
            }
        });
        return view;
    }

    private void do_btnSnimiClick() {
       KorisnikVM novi=new KorisnikVM();
       novi.setIme(txtIme.getText().toString());
       novi.setPrezime(txtPrezime.getText().toString());
       novi.setAdresaOpstina(txtAdresa.getText().toString());

        Storage.AddKorisnik(novi);
        getDialog().dismiss();

        callback.run(novi);

        };

    }




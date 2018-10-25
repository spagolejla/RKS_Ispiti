package com.example.lalalas.a2017_9_6.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.lalalas.a2017_9_6.R;
import com.example.lalalas.a2017_9_6.helper.MyRunnable;
import com.example.lalalas.a2017_9_6.helper.Util;
import com.example.lalalas.a2017_9_6.podaci.KorisnikVM;
import com.example.lalalas.a2017_9_6.podaci.Storage;

import java.util.List;
import java.util.zip.Inflater;


public class PretragaDialogFragment extends DialogFragment {
   private static String KORISNIK_KEY="korisnik_key";
   private MyRunnable<KorisnikVM> callback;
private SearchView searchView;
private ListView listKorisnici;
private Button btnNoviKorisnik;
    public PretragaDialogFragment() {
        // Required empty public constructor
    }

    public static PretragaDialogFragment newInstance(MyRunnable korisnikVM) {
        PretragaDialogFragment fragment = new PretragaDialogFragment();
        Bundle args = new Bundle();
         args.putSerializable(KORISNIK_KEY,korisnikVM);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
         callback=(MyRunnable<KorisnikVM>) getArguments().getSerializable(KORISNIK_KEY);
        }

        setStyle(STYLE_NORMAL,R.style.MojDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=inflater.inflate(R.layout.fragment_pretraga_dialog, container, false);
        searchView=view.findViewById(R.id.searchView);
        listKorisnici=view.findViewById(R.id.listView);
        btnNoviKorisnik=view.findViewById(R.id.btnNoviKorisnik);
popuniPodatke("");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                do_btnTraziClick( s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                do_btnTraziClick( s);

                return false;
            }
        });

        btnNoviKorisnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_btnNociKorisnikClick();
            }
        });

        return view;
    }

    private void do_btnNociKorisnikClick() {

        getDialog().dismiss();
        Util.otvoriFragmentKaoDijalog(getActivity(),NoviKorisnikDialog.newInstance(callback,searchView.getQuery().toString()));



    }

    private void do_btnTraziClick(String s) {
        popuniPodatke(s);


    }

    private void popuniPodatke(String s) {

        final List<KorisnikVM> podaci= Storage.getKorisniciByName(s);

        listKorisnici.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return podaci.size();
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                LayoutInflater inflater=(LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               view= inflater.inflate(R.layout.stavka_korisnik,viewGroup,false);

                TextView txtIme=view.findViewById(R.id.Ime);
                TextView txtAdresa=view.findViewById(R.id.Adresa);

                KorisnikVM x=podaci.get(i);

                txtIme.setText(x.getIme()+" "+x.getPrezime());
                txtAdresa.setText(x.getAdresaOpstina());

                return view ;
            }

            @Override
            public void notifyDataSetChanged() {
                super.notifyDataSetChanged();
            }
        });


        listKorisnici.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

             KorisnikVM x=podaci.get(i);
getDialog().dismiss();
callback.run(x);


            }
        });
    }


}

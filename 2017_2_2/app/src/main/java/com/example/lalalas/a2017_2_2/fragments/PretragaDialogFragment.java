package com.example.lalalas.a2017_2_2.fragments;

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
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.lalalas.a2017_2_2.R;
import com.example.lalalas.a2017_2_2.helper.MyRunnable;
import com.example.lalalas.a2017_2_2.podaci.KorisnikVM;
import com.example.lalalas.a2017_2_2.podaci.Storage;

import java.util.List;


public class PretragaDialogFragment extends DialogFragment {

    private static String KORISNIK_KEY="korisnik_key";
    private MyRunnable<KorisnikVM> callback;
    private SearchView searchView;
    private ListView listView;

    public PretragaDialogFragment() {
        // Required empty public constructor
    }


    public static PretragaDialogFragment newInstance(MyRunnable MyCallback) {
        PretragaDialogFragment fragment = new PretragaDialogFragment();
        Bundle args = new Bundle();
        args.putSerializable(KORISNIK_KEY,MyCallback);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
             callback=(MyRunnable<KorisnikVM>)getArguments().getSerializable(KORISNIK_KEY);
        }

        setStyle(STYLE_NORMAL,R.style.MojDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_pretraga_dialog, container, false);

        searchView=view.findViewById(R.id.searchView);
        listView=view.findViewById(R.id.listView);
        popuniPodatke("");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                do_btnTraziClick(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                do_btnTraziClick(s);
                return false;
            }
        });

        return view;

    }

    private void do_btnTraziClick(String s) {
        popuniPodatke(s);
    }

    private void popuniPodatke(String s) {

        final List<KorisnikVM> podaci= Storage.getKorisniciByIme(s);

        listView.setAdapter(new BaseAdapter() {
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
                view=inflater.inflate(R.layout.korisnik_stavka,viewGroup,false);

                TextView txtIme=view.findViewById(R.id.txtImePrezime);
                TextView txtAdresa=view.findViewById(R.id.txtAdresa);

                KorisnikVM x=podaci.get(i);
                txtIme.setText(x.getIme()+" "+x.getPrezime());
                txtAdresa.setText(x.getOpstinaVM().getNaziv());
                return view;
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                KorisnikVM x=podaci.get(i);
                getDialog().dismiss();
                callback.run(x);
            }
        });
    }


}

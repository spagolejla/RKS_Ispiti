package com.example.lalalas.hci_ispit_2017_6_14.fragments;

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

import com.example.lalalas.hci_ispit_2017_6_14.R;
import com.example.lalalas.hci_ispit_2017_6_14.helper.MyRunnable;
import com.example.lalalas.hci_ispit_2017_6_14.podaci.KorisnikVM;
import com.example.lalalas.hci_ispit_2017_6_14.podaci.Storage;

import java.util.List;
import java.util.zip.Inflater;


public class PretragaDialogFragment extends DialogFragment {
     private SearchView searchView;
     private ListView listView;
     private MyRunnable<KorisnikVM> callback;
     private static  final String NEKI_KEY="neki_key";
     private EditText txtIme;
    private EditText txtPrezime;
    private EditText txtAdresa;
private Button btnSnimiKorisnika;

    public PretragaDialogFragment() {
        // Required empty public constructor
    }


    public static PretragaDialogFragment newInstance(MyRunnable MyCallback) {
        PretragaDialogFragment fragment = new PretragaDialogFragment();
        Bundle args = new Bundle();
        args.putSerializable(NEKI_KEY,MyCallback);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
         callback=(MyRunnable<KorisnikVM>)getArguments().getSerializable(NEKI_KEY);
        }
        setStyle(STYLE_NORMAL, R.style.MojDialog );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.fragment_pretraga_dialog, container, false);
         searchView=(SearchView)view.findViewById(R.id.searchView);
         listView=(ListView)view.findViewById(R.id.listView);

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
        searchView.setIconifiedByDefault(false);
        popuniPodatke("");

        txtIme=(EditText)view.findViewById(R.id.txtIme);
        txtPrezime=(EditText)view.findViewById(R.id.txtPrezime);
        txtAdresa=(EditText)view.findViewById(R.id.txtAdresa);
btnSnimiKorisnika=(Button)view.findViewById(R.id.btnSnimiKorisnika);
btnSnimiKorisnika.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        do_btnSnimiKorisnikaClick();
    }
});
        return view;
    }

    private void do_btnSnimiKorisnikaClick() {
        KorisnikVM novi=new KorisnikVM(txtIme.getText().toString(),txtPrezime.getText().toString(),txtAdresa.getText().toString());
        Storage.addKorisnik(novi);
        callback.run(novi);
        getDialog().dismiss();
    }

    private void do_btnTraziClick(String s) {
        popuniPodatke(s);
    }

    private void popuniPodatke(String s) {

        final List<KorisnikVM> podaci= Storage.getKorisniciByName(s);

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
                LayoutInflater inflater= (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                view=inflater.inflate(R.layout.korisnik_stavka,viewGroup,false);

                TextView txtFirstLine=(TextView)view.findViewById(R.id.txtFirstLine);
                TextView txtSecondLine=(TextView)view.findViewById(R.id.txtSecondLine);

                KorisnikVM x=podaci.get(i);

                txtFirstLine.setText(x.getIme()+" "+x.getPrezime());
                txtSecondLine.setText(x.getAdresaOpstina());

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




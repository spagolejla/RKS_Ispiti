package com.example.lalalas.a2017_2_2.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lalalas.a2017_2_2.R;
import com.example.lalalas.a2017_2_2.helper.Util;
import com.example.lalalas.a2017_2_2.podaci.PosiljkaVM;
import com.example.lalalas.a2017_2_2.podaci.Storage;

import java.util.List;

public class PrikazPaketaFragment extends Fragment {

    private ListView listPaketi;

    private Button btnNovi;


    public PrikazPaketaFragment() {
        // Required empty public constructor
    }

    public static PrikazPaketaFragment newInstance() {
        PrikazPaketaFragment fragment = new PrikazPaketaFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
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
         View view=inflater.inflate(R.layout.fragment_prikaz_paketa, container, false);

         listPaketi=view.findViewById(R.id.listPaketi);
         btnNovi=view.findViewById(R.id.btnNoviPaket);
          popuniPodatke();
    btnNovi.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Util.otvoriFragmentKaoReplace(getActivity(),R.id.fragmentPlace,Fragment1.newInstance());
        }
    });


         return view;
    }

    private void popuniPodatke() {
        final List<PosiljkaVM> podaci= Storage.getPosiljke();

        listPaketi.setAdapter(new BaseAdapter() {
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

                LayoutInflater inflater=(LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view=inflater.inflate(R.layout.paket_stavka,viewGroup,false);

                 TextView txtPos=view.findViewById(R.id.txtPosiljaoc);
                 TextView txtPrim=view.findViewById(R.id.txtPrimaoc);
                 TextView txtAdrPrim=view.findViewById(R.id.txtAdresaPrimalac);
                 TextView txtAdrPos=view.findViewById(R.id.txtAdresaPosiljaoc);
                 TextView txtBrPaketa=view.findViewById(R.id.txtBrojPaketa);

                 PosiljkaVM x=podaci.get(i);

                 txtPos.setText(x.posljiaoc.getIme()+" "+x.posljiaoc.getPrezime());
                txtPrim.setText(x.primaoc.getIme()+" "+x.primaoc.getPrezime());
                txtAdrPos.setText(x.posljiaoc.getOpstinaVM().getNaziv());
                txtAdrPrim.setText(x.primaoc.getOpstinaVM().getNaziv());
                txtBrPaketa.setText("0"+i);


                return view;
            }
        });

    }


}

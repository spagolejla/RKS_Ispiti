package ba.fit.app.hci_odbrana.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import ba.fit.app.hci_odbrana.R;
import ba.fit.app.hci_odbrana.podaci.PosiljkaVM;
import ba.fit.app.hci_odbrana.podaci.Storage;


public class PosiljkaListFragment extends Fragment {

    private ListView lvPosiljke;

    public PosiljkaListFragment() {
        // Required empty public constructor
    }

    public static PosiljkaListFragment newInstance() {
        PosiljkaListFragment fragment = new PosiljkaListFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.fragment_posiljka_list, container, false);
         lvPosiljke=(ListView)view.findViewById(R.id.listViewPosiljke);

         popuniPodatke();

        return view;
    }

    private void popuniPodatke() {
        final List<PosiljkaVM> podaci= Storage.getPosiljkeAll();

        lvPosiljke.setAdapter(new BaseAdapter() {
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

                if (view==null) {
                    LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(R.layout.stavka_posiljka, viewGroup, false);
                }

                TextView txtFirstLine =(TextView) view.findViewById(R.id.txtFirstLine);
                TextView txtSecondLine = (TextView) view.findViewById(R.id.txtSecondLine);
                TextView txtThirdLine = (TextView) view.findViewById(R.id.txtThirdLine);
                TextView txtMeta = (TextView) view.findViewById(R.id.txtMeta);


                PosiljkaVM x =podaci.get(i);

                txtFirstLine.setText("To: "+x.primaoc.getIme()+" "+x.primaoc.getPrezime());
                txtSecondLine.setText("From: " +x.posljiaoc.getIme()+ " "+x.posljiaoc.getPrezime() );
                txtThirdLine.setText(x.primaoc.getAdresa());
txtMeta.setText("0"+i);
                return view;
            }
        });

    }


}

package ba.fit.app.hci_odbrana.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import ba.fit.app.hci_odbrana.R;
import ba.fit.app.hci_odbrana.helper.MyRunnable;
import ba.fit.app.hci_odbrana.podaci.KorisnikVM;
import ba.fit.app.hci_odbrana.podaci.Storage;


public class PretragaDialogFragment extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String NEKI_KEY = "neki_key";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView listView;
    private SearchView searchView;
    private MyRunnable<KorisnikVM> callback;


    public PretragaDialogFragment() {
        // Required empty public constructor
    }


    public static PretragaDialogFragment newInstance(MyRunnable myCallback) {
        PretragaDialogFragment fragment = new PretragaDialogFragment();
        Bundle args = new Bundle();

        args.putSerializable(NEKI_KEY, myCallback);
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


        View view = inflater.inflate(R.layout.dialog_pretraga, container, false);

        listView=(ListView) view.findViewById(R.id.listView);
        searchView=(SearchView) view.findViewById(R.id.searchView);

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

        return view;
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
                if(view==null)
                {
                    LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(R.layout.stavka_primaoci, viewGroup,false);
                }

                TextView txtIme = (TextView) view.findViewById(R.id.txtFirstLine);
                TextView txtAdresa = (TextView) view.findViewById(R.id.txtSecondLine);

                KorisnikVM x = podaci.get(i);


                txtAdresa.setText(x.getAdresa()+""+x.getOpstinaVM().getNaziv().toString());
                txtIme.setText(x.getIme() + " " + x.getPrezime());


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

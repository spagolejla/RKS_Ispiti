package ba.fit.app.hci_odbrana.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ba.fit.app.hci_odbrana.R;
import ba.fit.app.hci_odbrana.helper.MyRunnable;
import ba.fit.app.hci_odbrana.helper.Util;
import ba.fit.app.hci_odbrana.podaci.KorisnikVM;
import ba.fit.app.hci_odbrana.podaci.PosiljkaVM;


public class Fragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String POSILJKA_KEY= "neki_key_1";
    private PosiljkaVM posiljkaVM;

    private EditText txtPrimaoc;
    private EditText txtAdresa;
    private Button btnPromjeni;
    private Button btnDalje;
    private Button btnNazad;


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
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_fragment2, container, false);
        txtPrimaoc=(EditText) view.findViewById(R.id.txtPrimaoc);
        txtAdresa=(EditText) view.findViewById(R.id.txtAdresa);
        btnDalje=(Button) view.findViewById(R.id.btnDalje);
        btnNazad=(Button) view.findViewById(R.id.btnNazad);
        btnPromjeni=(Button) view.findViewById(R.id.btnPromjeniPrimaoca);

        btnNazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_btnNazadClick();
            }
        });
        btnPromjeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_btnPromjeniClick();
            }
        });
btnDalje.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        do_btnDaljeClick();
    }
});

        return view;
    }

    private void do_btnDaljeClick() {
        Util.otvoriFragmentKaoReplace(getActivity(),R.id.fragmentPlace,Fragment3.newInstance(posiljkaVM));
    }

    private void do_btnNazadClick() {
        Util.otvoriFragmentKaoReplace(getActivity(),R.id.fragmentPlace,Fragment1.newInstance());
    }

    private void do_btnPromjeniClick() {
        MyRunnable callback=new MyRunnable<KorisnikVM>() {
            @Override
            public void run(KorisnikVM result) {

                posiljkaVM.primaoc=result;

                txtPrimaoc.setText(result.getIme()+" "+result.getPrezime());
                txtAdresa.setText(result.getAdresa()+" "+result.getOpstinaVM().getNaziv());


            }
        };
        PretragaDialogFragment dlg=PretragaDialogFragment.newInstance(callback);
        Util.otvoriFragmentKaoDijalog(getActivity(),dlg);
    }



}

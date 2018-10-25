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


public class Fragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText txtPosiljaoc;
    private EditText txtAdresa;
    private Button btnPromjeni;
    private Button btnDalje;

    public Fragment1() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance() {
        Fragment1 fragment = new Fragment1();
        //Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        //fragment.setArguments(args);
        return fragment;
    }


    /**@Override


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_fragment1, container, false);
txtPosiljaoc=(EditText)view.findViewById(R.id.txtPosiljaoc);
txtAdresa=(EditText)view.findViewById(R.id.txtAdresa);
btnDalje=(Button) view.findViewById(R.id.btnDalje);
btnPromjeni=(Button) view.findViewById(R.id.btnPromjeniPosiljaoca);

btnPromjeni.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        do_btnPromjeniClick();
    }
});
btnDalje.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        do_btnDaljeClcik();
    }
});

        return view;
    }

    private void do_btnDaljeClcik() {


        Util.otvoriFragmentKaoReplace(getActivity(),R.id.fragmentPlace,Fragment2.newInstance(posiljkaVM));

    }

    private PosiljkaVM posiljkaVM=new PosiljkaVM();

    private void do_btnPromjeniClick() {
        MyRunnable callbak=new MyRunnable<KorisnikVM>() {
            @Override
            public void run(KorisnikVM result) {
                    posiljkaVM.posljiaoc=result;
                    txtPosiljaoc.setText(result.getIme()+result.getPrezime());
                    txtAdresa.setText(result.getAdresa()+" "+result.getOpstinaVM().getNaziv().toString());
            }
        };


        PretragaDialogFragment dlg=PretragaDialogFragment.newInstance(callbak);
        Util.otvoriFragmentKaoDijalog(getActivity(),dlg);
    }


}

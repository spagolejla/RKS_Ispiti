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
import android.widget.Toast;

import ba.fit.app.hci_odbrana.R;
import ba.fit.app.hci_odbrana.helper.Util;
import ba.fit.app.hci_odbrana.podaci.PosiljkaVM;
import ba.fit.app.hci_odbrana.podaci.Storage;


public class Fragment3 extends Fragment {

    private static final String POSILJKA_KEY = "neki_key_1";
    private EditText txtMasa;
    private EditText txtNapomena;
    private Button btnZavrsi;
    private Button btnNazad;
    private PosiljkaVM posiljkaVM;
    public Fragment3() {
        // Required empty public constructor
    }


    public static Fragment3 newInstance(PosiljkaVM posiljkaVM) {
        Fragment3 fragment = new Fragment3();
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
         View view=inflater.inflate(R.layout.fragment_fragment3, container, false);
         txtMasa=(EditText)view.findViewById(R.id.txtMasa);
         txtNapomena=(EditText)view.findViewById(R.id.txtNapomena);
         btnNazad=(Button) view.findViewById(R.id.btnNazad);
         btnZavrsi=(Button)view.findViewById(R.id.btnZavrsi);
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

        posiljkaVM.masa=Float.parseFloat(txtMasa.getText().toString());
        posiljkaVM.napomena=txtNapomena.getText().toString();

        Storage.AddPosiljka(posiljkaVM);

        Util.otvoriFragmentKaoReplace(getActivity(),R.id.fragmentPlace,PosiljkaListFragment.newInstance());

    }

    private void do_btnNazadClick() {
        Util.otvoriFragmentKaoReplace(getActivity(),R.id.fragmentPlace,Fragment2.newInstance(posiljkaVM));
    }


}

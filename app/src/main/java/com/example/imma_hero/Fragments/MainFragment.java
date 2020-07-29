package com.example.imma_hero.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.imma_hero.Activities.MainActivity;
import com.example.imma_hero.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button accidentBtn,bornBtn,geneticBtn,choosePowerBtn;
    private Button previousBtn = null;
    private boolean firstClick=true;
    private int previousLeftDrawble;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_main, container, false);
        accidentBtn = view.findViewById(R.id.accidentBtn);
        geneticBtn = view.findViewById(R.id.geneticBtn);
        bornBtn  = view.findViewById(R.id.bornBtn);
        choosePowerBtn  = view.findViewById(R.id.choosePowerBtn);

        accidentBtn.setOnClickListener(this);
        bornBtn.setOnClickListener(this);
        geneticBtn.setOnClickListener(this);
        choosePowerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.loadPickPowerScreen();
            }
        });

        choosePowerBtn.setEnabled(false);
        choosePowerBtn.getBackground().setAlpha(128);
        return view;
    }

    @Override
    public void onClick(View v) {
        choosePowerBtn.setEnabled(true);
        choosePowerBtn.getBackground().setAlpha(255);

        Button btn = (Button)v;

        if(!firstClick){
            previousBtn.setCompoundDrawablesWithIntrinsicBounds(previousLeftDrawble,0,0,0);
        }
        int leftDrawable = 0;
        if(btn == accidentBtn){
            leftDrawable = R.drawable.lightning;
        } else if(btn == bornBtn){
            leftDrawable =R.drawable.rocket;
        } else if(btn == geneticBtn){
            leftDrawable = R.drawable.atomic;
        }
        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,R.drawable.item_selected,0);

        firstClick = false;
        previousLeftDrawble = leftDrawable;
        previousBtn = btn;
    }
}
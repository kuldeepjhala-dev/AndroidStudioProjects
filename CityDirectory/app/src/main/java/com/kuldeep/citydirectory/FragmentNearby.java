package com.kuldeep.citydirectory;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentNearby extends Fragment {

    public FragmentNearby() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nearby, container, false);

        EditText et_search_nearby = view.findViewById(R.id.et_search_nearby);

        RecyclerView rcViewNearby = view.findViewById(R.id.rv_fragment_nearby_id);

        ArrayList<RVNearbyFragmentModel> arrRcModelNearby = new ArrayList<>();

        arrRcModelNearby.add(new RVNearbyFragmentModel(R.drawable.airport, "ABC", "4", 5, "avc"));
        arrRcModelNearby.add(new RVNearbyFragmentModel(R.drawable.airport, "Bac", "4", 5, "avc"));
        arrRcModelNearby.add(new RVNearbyFragmentModel(R.drawable.airport, "Baa", "4", 5, "avc"));
        arrRcModelNearby.add(new RVNearbyFragmentModel(R.drawable.airport, "adv", "4", 5, "avc"));
        arrRcModelNearby.add(new RVNearbyFragmentModel(R.drawable.airport, "cfs", "4", 5, "avc"));
        arrRcModelNearby.add(new RVNearbyFragmentModel(R.drawable.airport, "Cwa", "4", 5, "avc"));
        arrRcModelNearby.add(new RVNearbyFragmentModel(R.drawable.airport, "dew", "4", 5, "avc"));
        arrRcModelNearby.add(new RVNearbyFragmentModel(R.drawable.airport, "Don", "4", 5, "avc"));
        arrRcModelNearby.add(new RVNearbyFragmentModel(R.drawable.airport, "eight", "4", 5, "avc"));
        arrRcModelNearby.add(new RVNearbyFragmentModel(R.drawable.airport, "elephant", "4", 5, "avc"));
        arrRcModelNearby.add(new RVNearbyFragmentModel(R.drawable.airport, "apple", "4", 5, "avc"));

        AdapterNearbyFragment adapter = new AdapterNearbyFragment(getActivity(), arrRcModelNearby);
        rcViewNearby.setAdapter(adapter);

        et_search_nearby.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

}
package com.kuldeep.citydirectory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentFavourite extends Fragment {
    public FragmentFavourite() {
        // Required empty public constructor
    }

    ArrayList<RvFavouriteFragmentModel> arrRcModelFavourite = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);
        RecyclerView rcViewFavourite = view.findViewById(R.id.rv_fragment_favourite_id);

        arrRcModelFavourite.add(new RvFavouriteFragmentModel(R.drawable.airport, "ABC", "4", 5, "avc"));
        arrRcModelFavourite.add(new RvFavouriteFragmentModel(R.drawable.airport, "ABC", "4", 5, "avc"));
        arrRcModelFavourite.add(new RvFavouriteFragmentModel(R.drawable.airport, "ABC", "4", 5, "avc"));
        arrRcModelFavourite.add(new RvFavouriteFragmentModel(R.drawable.airport, "ABC", "4", 5, "avc"));
        arrRcModelFavourite.add(new RvFavouriteFragmentModel(R.drawable.airport, "ABC", "4", 5, "avc"));
        arrRcModelFavourite.add(new RvFavouriteFragmentModel(R.drawable.airport, "ABC", "4", 5, "avc"));
        arrRcModelFavourite.add(new RvFavouriteFragmentModel(R.drawable.airport, "ABC", "4", 5, "avc"));
        arrRcModelFavourite.add(new RvFavouriteFragmentModel(R.drawable.airport, "ABC", "4", 5, "avc"));
        arrRcModelFavourite.add(new RvFavouriteFragmentModel(R.drawable.airport, "ABC", "4", 5, "avc"));
        arrRcModelFavourite.add(new RvFavouriteFragmentModel(R.drawable.airport, "ABC", "4", 5, "avc"));
        arrRcModelFavourite.add(new RvFavouriteFragmentModel(R.drawable.airport, "ABC", "4", 5, "avc"));

        AdapterFavouriteFragment adapter = new AdapterFavouriteFragment(getActivity(), arrRcModelFavourite);
        rcViewFavourite.setAdapter(adapter);

        return view;
    }
}
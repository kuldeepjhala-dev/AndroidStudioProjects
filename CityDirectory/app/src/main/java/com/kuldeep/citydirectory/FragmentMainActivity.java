package com.kuldeep.citydirectory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class FragmentMainActivity extends Fragment {
    public FragmentMainActivity() {
        // Required empty public constructor
    }

    ViewPager2 vpHeading;
    ArrayList<RcViewModel> arrRcViewModelFacility = new ArrayList<>();
    ArrayList<RcViewModel2> arrRcViewModelFeatures = new ArrayList<>();
    ArrayList<RcViewModel2> arrRcViewModelRestaurant = new ArrayList<>();
    ArrayList<RcViewModel2> arrRcViewModelHotel = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        container.getContext();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_activity, container, false);


        vpHeading = view.findViewById(R.id.vp_heading);
        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(getChildFragmentManager(), getLifecycle());
        vpHeading.setAdapter(vpAdapter);

        RecyclerView rcViewFeatured = view.findViewById(R.id.rcViewFacility);
        RecyclerView rcViewFacility = view.findViewById(R.id.rcViewFeatured);
        RecyclerView rcViewRestaurant = view.findViewById(R.id.rcViewRestaurants);
        RecyclerView rcViewHotel = view.findViewById(R.id.rcViewHotels);
//
        GridLayoutManager layoutManagerGrid = new GridLayoutManager(getActivity(), 5);
//        LinearLayoutManager layoutManagerLinear = new LinearLayoutManager(this);
//
        layoutManagerGrid.setOrientation(GridLayoutManager.VERTICAL);
//        layoutManagerLinear.setOrientation(LinearLayoutManager.HORIZONTAL);
//
        rcViewFeatured.setLayoutManager(layoutManagerGrid);
//        rcViewFacility.setLayoutManager(layoutManagerLinear);
//       rcViewRestaurant.setLayoutManager(layoutManagerLinear);
//        rcViewHotel.setLayoutManager(layoutManagerLinear);

        //Data of facility
        arrRcViewModelFacility.add(new RcViewModel(R.drawable.airport, "Airport"));
        arrRcViewModelFacility.add(new RcViewModel(R.drawable.amusement_park, "Amusement Park"));
        arrRcViewModelFacility.add(new RcViewModel(R.drawable.atm_machine, "Atm machine"));
        arrRcViewModelFacility.add(new RcViewModel(R.drawable.bank, "Bank"));
        arrRcViewModelFacility.add(new RcViewModel(R.drawable.beer, "Bar"));
        arrRcViewModelFacility.add(new RcViewModel(R.drawable.bread, "Bakery"));
        arrRcViewModelFacility.add(new RcViewModel(R.drawable.electrical_energy, "Electrician"));
        arrRcViewModelFacility.add(new RcViewModel(R.drawable.gallery, "Art Gallery"));
        arrRcViewModelFacility.add(new RcViewModel(R.drawable.hair_dryer, "Saloon"));

        //Data of Features
        arrRcViewModelFeatures.add(new RcViewModel2(R.drawable.airport, "Airport", "Address is of the text is this sdc sdv ds sdvsd"));
        arrRcViewModelFeatures.add(new RcViewModel2(R.drawable.amusement_park, "Amusement Park", "ADDRESSS.."));
        arrRcViewModelFeatures.add(new RcViewModel2(R.drawable.atm_machine, "Atm machine", "ADDRESSS.."));
        arrRcViewModelFeatures.add(new RcViewModel2(R.drawable.bank, "Bank", "ADDRESSS.."));
        arrRcViewModelFeatures.add(new RcViewModel2(R.drawable.beer, "Bar", "ADDRESSS.."));
        arrRcViewModelFeatures.add(new RcViewModel2(R.drawable.bread, "Bakery", "ADDRESSS.."));
        arrRcViewModelFeatures.add(new RcViewModel2(R.drawable.electrical_energy, "Electrician", "ADDRESSS.."));
        arrRcViewModelFeatures.add(new RcViewModel2(R.drawable.gallery, "Art Gallery", "ADDRESSS.."));
        arrRcViewModelFeatures.add(new RcViewModel2(R.drawable.hair_dryer, "Saloon", "ADDRESSS.."));

        //Data of Restaurants
        arrRcViewModelRestaurant.add(new RcViewModel2(R.drawable.airport, "Airport", "ADDRESSS.."));
        arrRcViewModelRestaurant.add(new RcViewModel2(R.drawable.amusement_park, "Amusement Park", "ADDRESSS.."));
        arrRcViewModelRestaurant.add(new RcViewModel2(R.drawable.atm_machine, "Atm machine", "ADDRESSS.."));
        arrRcViewModelRestaurant.add(new RcViewModel2(R.drawable.bank, "Bank", "ADDRESSS.."));
        arrRcViewModelRestaurant.add(new RcViewModel2(R.drawable.beer, "Bar", "ADDRESSS.."));
        arrRcViewModelRestaurant.add(new RcViewModel2(R.drawable.bread, "Bakery", "ADDRESSS.."));
        arrRcViewModelRestaurant.add(new RcViewModel2(R.drawable.electrical_energy, "Electrician", "ADDRESSS.."));
        arrRcViewModelRestaurant.add(new RcViewModel2(R.drawable.gallery, "Art Gallery", "ADDRESSS.."));
        arrRcViewModelRestaurant.add(new RcViewModel2(R.drawable.hair_dryer, "Saloon", "ADDRESSS.."));

        //Data of hotels
        arrRcViewModelHotel.add(new RcViewModel2(R.drawable.airport, "Airport", "ADDRESSS.."));
        arrRcViewModelHotel.add(new RcViewModel2(R.drawable.amusement_park, "Amusement Park", "ADDRESSS.."));
        arrRcViewModelHotel.add(new RcViewModel2(R.drawable.atm_machine, "Atm machine", "ADDRESSS.."));
        arrRcViewModelHotel.add(new RcViewModel2(R.drawable.bank, "Bank", "ADDRESSS.."));
        arrRcViewModelHotel.add(new RcViewModel2(R.drawable.beer, "Bar", "ADDRESSS.."));
        arrRcViewModelHotel.add(new RcViewModel2(R.drawable.bread, "Bakery", "ADDRESSS.."));
        arrRcViewModelHotel.add(new RcViewModel2(R.drawable.electrical_energy, "Electrician", "ADDRESSS.."));
        arrRcViewModelHotel.add(new RcViewModel2(R.drawable.gallery, "Art Gallery", "ADDRESSS.."));
        arrRcViewModelHotel.add(new RcViewModel2(R.drawable.hair_dryer, "Saloon", "ADDRESSS.."));

        RcFeaturedAdapter adapter = new RcFeaturedAdapter(getActivity(), arrRcViewModelFacility);
        RcFeaturedAdapter2 adapter2 = new RcFeaturedAdapter2(getActivity(), arrRcViewModelFeatures);
        RcFeaturedAdapter3 adapter3 = new RcFeaturedAdapter3(getActivity(), arrRcViewModelRestaurant);
        RcFeaturedAdapter4 adapter4 = new RcFeaturedAdapter4(getActivity(), arrRcViewModelHotel);

        rcViewFeatured.setAdapter(adapter);
        rcViewFacility.setAdapter(adapter2);
        rcViewRestaurant.setAdapter(adapter3);
        rcViewHotel.setAdapter(adapter4);
        return view;
    }
}
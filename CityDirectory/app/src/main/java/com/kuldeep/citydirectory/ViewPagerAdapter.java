package com.kuldeep.citydirectory;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                Fragment_heading_1 f1 = new Fragment_heading_1();
                return f1;
            case 1:
                Fragment_heading_2 f2 = new Fragment_heading_2();
                return f2;
            case 2:
                Fragment_heading_3 f3 = new Fragment_heading_3();
                return f3;
            case 3:
                Fragment_heading_4 f4 = new Fragment_heading_4();
                return f4;
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}

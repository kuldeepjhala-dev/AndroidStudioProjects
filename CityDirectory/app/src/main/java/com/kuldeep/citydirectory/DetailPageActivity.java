package com.kuldeep.citydirectory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;
public class DetailPageActivity extends AppCompatActivity {
    RecyclerView rc_detail_page;
    RecyclerView rc_detail_review;
    ArrayList<Integer> images = new ArrayList<>();
    ArrayList<RvCustomerRatingsModel> reviews = new ArrayList<>();

    ExpandableTextView expandableTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        ImageView back_icon = findViewById(R.id.back_icon);

        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        rc_detail_page = findViewById(R.id.rv_detail_images);
        rc_detail_review = findViewById(R.id.rv_detail_reviews);

        images.add(R.drawable.bank);
        images.add(R.drawable.airport);
        images.add(R.drawable.beer);
        images.add(R.drawable.atm_machine);
        images.add(R.drawable.bread);
        images.add(R.drawable.update);
        images.add(R.drawable.amusement_park);

        reviews.add(new RvCustomerRatingsModel(R.drawable.hair_dryer, "name", "5", 5, "a month ago", getResources().getString(R.string.expandable_text_string)));
        reviews.add(new RvCustomerRatingsModel(R.drawable.hair_dryer, "name", "4", 4, "a month ago", getResources().getString(R.string.expandable_text_string)));
        reviews.add(new RvCustomerRatingsModel(R.drawable.hair_dryer, "name", "3", 3, "a month ago", getResources().getString(R.string.expandable_text_string)));
        reviews.add(new RvCustomerRatingsModel(R.drawable.hair_dryer, "name", "2", 2, "a month ago", getResources().getString(R.string.expandable_text_string)));
        reviews.add(new RvCustomerRatingsModel(R.drawable.hair_dryer, "name", "1", 1, "a month ago", getResources().getString(R.string.expandable_text_string)));

        AdapterDetailPageImages adapterDetailPageImages = new AdapterDetailPageImages(images, this);
        rc_detail_page.setAdapter(adapterDetailPageImages);

        AdapterDetailPageReviews adapterDetailPageReviews = new AdapterDetailPageReviews(this, reviews);
        rc_detail_review.setAdapter(adapterDetailPageReviews);

    }
}
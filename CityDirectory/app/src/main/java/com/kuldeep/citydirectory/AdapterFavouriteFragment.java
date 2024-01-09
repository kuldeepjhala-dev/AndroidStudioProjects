package com.kuldeep.citydirectory;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterFavouriteFragment extends RecyclerView.Adapter<AdapterFavouriteFragment.ViewHolder> {

    ArrayList<RvFavouriteFragmentModel> details = new ArrayList<>();
    Context context;

    AdapterFavouriteFragment(Context context, ArrayList<RvFavouriteFragmentModel> details) {
        this.context = context;
        this.details = details;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rc_view_favourite_fragment_card, parent, false);
        AdapterFavouriteFragment.ViewHolder viewHolder = new AdapterFavouriteFragment.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(details.get(position).img);
        holder.location_name.setText(details.get(position).location_name);
        holder.address.setText(details.get(position).address);
        holder.total_rating_no.setText(details.get(position).total_rating_no);
        holder.rating_bar.setRating(details.get(position).rating_bar);
        holder.recycler_card_favourite_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DetailPageActivity.class);
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView location_name;
        TextView total_rating_no;
        RatingBar rating_bar;
        TextView address;

        CardView recycler_card_favourite_id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageViewRcViewFavouriteCard);
            location_name = itemView.findViewById(R.id.textViewRcViewFavouriteHeadingCard);
            total_rating_no = itemView.findViewById(R.id.textViewRcViewFavouriteRatingBarNo);
            rating_bar = itemView.findViewById(R.id.textViewRcViewFavouriteRatingBar);
            address = itemView.findViewById(R.id.textViewRcViewFavouriteAddressCard);
            recycler_card_favourite_id = itemView.findViewById(R.id.recycler_card_favourite_id);
        }
    }
}

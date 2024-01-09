package com.kuldeep.citydirectory;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterNearbyFragment extends RecyclerView.Adapter<AdapterNearbyFragment.ViewHolder> implements Filterable {

    Context context;
    ArrayList<RVNearbyFragmentModel> detailsMain;
    ArrayList<RVNearbyFragmentModel> details;

    public AdapterNearbyFragment(Context context, ArrayList<RVNearbyFragmentModel> details) {
        this.context = context;
        this.details = details;
        this.detailsMain = details;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rc_view_nearby_fragment_card, parent, false);
        AdapterNearbyFragment.ViewHolder viewHolder = new AdapterNearbyFragment.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(details.get(position).img);
        holder.location_name.setText(details.get(position).location_name);
        holder.address.setText(details.get(position).address);
        holder.total_rating_no.setText(details.get(position).total_rating_no);
        holder.rating_bar.setRating(details.get(position).rating_bar);
        holder.recycler_nearby_card_value.setOnClickListener(new View.OnClickListener() {
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
        CardView recycler_nearby_card_value;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageViewRcViewNearbyCard);
            location_name = itemView.findViewById(R.id.textViewRcViewNearbyHeadingCard);
            total_rating_no = itemView.findViewById(R.id.textViewRcViewNearbyRatingBarNo);
            rating_bar = itemView.findViewById(R.id.textViewRcViewNearbyRatingBar);
            address = itemView.findViewById(R.id.textViewRcViewNearbyAddressCard);
            recycler_nearby_card_value = itemView.findViewById(R.id.recycler_card_nearby_id);
        }
    }

    private Filter fRecords;

    @Override
    public Filter getFilter() {
        if (fRecords == null) {
            fRecords = new RecordFilter();
        }
        return fRecords;
    }

    private class RecordFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();

            //Implement filter logic
            // if edittext is null return the actual list
            if (constraint == null || constraint.length() == 0) {
                //No need for filter
                results.values = detailsMain;
                results.count = detailsMain.size();

            } else {
                //Need Filter
                // it matches the text  entered in the edittext and set the data in adapter list
                ArrayList<RVNearbyFragmentModel> fRecords = new ArrayList<RVNearbyFragmentModel>();

                for (RVNearbyFragmentModel s : detailsMain) {
                    if (s.getLocation_name().toUpperCase().trim().contains(constraint.toString().toUpperCase().trim())) {
                        fRecords.add(s);
                    }
                }
                results.values = fRecords;
                results.count = fRecords.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            //it set the data from filter to adapter list and refresh the recyclerview adapter
            details = (ArrayList<RVNearbyFragmentModel>) results.values;
            notifyDataSetChanged();
        }

    }
}

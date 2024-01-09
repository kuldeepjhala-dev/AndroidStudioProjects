package com.kuldeep.citydirectory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;

public class AdapterDetailPageReviews extends RecyclerView.Adapter<AdapterDetailPageReviews.ViewHolder> {

    Context conext;
    ArrayList<RvCustomerRatingsModel> reviews;
    public AdapterDetailPageReviews(Context context, ArrayList<RvCustomerRatingsModel> review) {
        this.conext = context;
        this.reviews = review;
    }

    @NonNull
    @Override
    public AdapterDetailPageReviews.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(conext).inflate(R.layout.rc_view_detail_page_reviews_card, parent, false);
        AdapterDetailPageReviews.ViewHolder viewHolder = new AdapterDetailPageReviews.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(reviews.get(position).img);
        holder.reviewer_name.setText(reviews.get(position).reviewer_name);
        holder.total_rating_no.setText(reviews.get(position).total_rating_no);
        holder.rating_bar.setRating(reviews.get(position).rating_bar);
        holder.review_period.setText(reviews.get(position).review_period);
        holder.review.setText(reviews.get(position).review);

    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView reviewer_name;
        TextView total_rating_no;
        RatingBar rating_bar;
        TextView review_period;
        ExpandableTextView review;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.card_detail_review_reviewer_image);
            reviewer_name = itemView.findViewById(R.id.card_detail_review_reviewer_name);
            total_rating_no = itemView.findViewById(R.id.card_detail_review_rating_no);
            rating_bar = itemView.findViewById(R.id.card_detail_review_rating_bar);
            review_period = itemView.findViewById(R.id.card_detail_review_period);
            review = itemView.findViewById(R.id.expand_text_view);
        }

    }
}

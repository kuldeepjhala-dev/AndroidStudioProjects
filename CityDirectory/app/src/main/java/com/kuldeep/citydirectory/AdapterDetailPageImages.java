package com.kuldeep.citydirectory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDetailPageImages extends RecyclerView.Adapter<AdapterDetailPageImages.ViewHolder> {

    Context context;
    ArrayList<Integer> arrRcViewModelDetail;

    public AdapterDetailPageImages(ArrayList<Integer> arrRcViewModel, Context context) {
        this.arrRcViewModelDetail = arrRcViewModel;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterDetailPageImages.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rc_view_detail_page_images_card, parent, false);
        AdapterDetailPageImages.ViewHolder viewHolder = new AdapterDetailPageImages.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDetailPageImages.ViewHolder holder, int position) {
        holder.detail_image.setImageResource(arrRcViewModelDetail.get(position));
    }

    @Override
    public int getItemCount() {
        return arrRcViewModelDetail.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView detail_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            detail_image = itemView.findViewById(R.id.iv_detail_page);

        }
    }
}

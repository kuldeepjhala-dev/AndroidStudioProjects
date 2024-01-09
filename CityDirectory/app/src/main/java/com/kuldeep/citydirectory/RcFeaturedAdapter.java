package com.kuldeep.citydirectory;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class RcFeaturedAdapter extends RecyclerView.Adapter<RcFeaturedAdapter.ViewHolder> {
    Context context;
    ArrayList<RcViewModel> arrRcViewModel;


    RcFeaturedAdapter(Context context, ArrayList<RcViewModel> arrRcViewModel) {
        this.context = context;
        this.arrRcViewModel = arrRcViewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rc_view_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.featuredImage.setImageResource(arrRcViewModel.get(position).img);
        holder.txtName.setText(arrRcViewModel.get(position).Name);
        holder.recycler_card_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DetailPageActivity.class);
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrRcViewModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        ImageView featuredImage;
        ShapeableImageView recycler_card_id;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.textViewRcViewCard);
            featuredImage = itemView.findViewById(R.id.imageViewRcViewCard);
            recycler_card_id = itemView.findViewById(R.id.imageViewRcViewCard);

        }
    }


}

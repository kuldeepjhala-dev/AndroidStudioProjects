package com.kuldeep.citydirectory;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RcFeaturedAdapter3 extends RecyclerView.Adapter<RcFeaturedAdapter3.ViewHolder> {

    Context context;
    ArrayList<RcViewModel2> arrRcViewModelRestaurant;
    public RcFeaturedAdapter3(Context context, ArrayList<RcViewModel2> arrRcViewModelRestaurant) {
        this.context = context;
        this.arrRcViewModelRestaurant = arrRcViewModelRestaurant;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rc_view_card_2, parent, false);
        RcFeaturedAdapter3.ViewHolder viewHolder = new RcFeaturedAdapter3.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(arrRcViewModelRestaurant.get(position).img);
        holder.name.setText(arrRcViewModelRestaurant.get(position).name);
        holder.name.setText(arrRcViewModelRestaurant.get(position).name);
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
        return arrRcViewModelRestaurant.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name;
        TextView address;

        CardView recycler_card_id;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageViewRcViewCard2);
            name = itemView.findViewById(R.id.textNameViewRcViewCard2);
            address = itemView.findViewById(R.id.textAddressViewRcViewCard2);
            recycler_card_id = itemView.findViewById(R.id.recycler_card_id);
        }
    }
}

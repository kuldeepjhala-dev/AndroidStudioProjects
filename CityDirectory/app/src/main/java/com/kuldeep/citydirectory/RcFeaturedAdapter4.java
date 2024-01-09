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

public class RcFeaturedAdapter4 extends RecyclerView.Adapter<RcFeaturedAdapter4.ViewHolder> {

    Context context;
    ArrayList<RcViewModel2> arrRcViewModelHotel;

    public RcFeaturedAdapter4(Context context, ArrayList<RcViewModel2> arrRcViewModelHotel) {
        this.context = context;
        this.arrRcViewModelHotel = arrRcViewModelHotel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rc_view_card_2, parent, false);
        RcFeaturedAdapter4.ViewHolder viewHolder = new RcFeaturedAdapter4.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(arrRcViewModelHotel.get(position).img);
        holder.name.setText(arrRcViewModelHotel.get(position).name);
        holder.name.setText(arrRcViewModelHotel.get(position).name);
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
        return arrRcViewModelHotel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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

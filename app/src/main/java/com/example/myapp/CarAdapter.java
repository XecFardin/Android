package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter  extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    private ArrayList<Car> cars;
    ItemClicked activity;
    public interface  ItemClicked
    {
        void  onItemClicked(int index);
    }
    public  CarAdapter (Context context,ArrayList<Car> list)
    {
        cars=list;
        activity=(ItemClicked) context;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder
    {
        ImageView ivmake;
        TextView tvmod,tvown;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivmake=itemView.findViewById(R.id.ivmake);
            tvmod=itemView.findViewById(R.id.tvmod);
            tvown=itemView.findViewById(R.id.tvown);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onItemClicked(cars.indexOf((Car)view.getTag()));

                }
            });
        }
    }
    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(cars.get(position));

        holder.tvown.setText(cars.get(position).getOwnerName());
        holder.tvmod.setText(cars.get(position).getModel());
        if(cars.get(position).getMake().equals("Volkswagen"))
        {
            holder.ivmake.setImageResource(R.drawable.volkswagen);
        }
        else if (cars.get(position).getMake().equals("Mercedes"))
        {
            holder.ivmake.setImageResource(R.drawable.mercedes);
        }
        else
        {
            holder.ivmake.setImageResource(R.drawable.nissan);
        }

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}

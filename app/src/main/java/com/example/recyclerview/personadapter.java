package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private ArrayList<person> people;
    ItemClicked activity;
    public interface ItemClicked
    {
        void  onItemClicked(int index);
    }
    public PersonAdapter (Context context, ArrayList<person> list)
    {
        people= list;
        activity = (ItemClicked)context;
    }
    public class ViewHolder extends  RecyclerView.ViewHolder
    {
        ImageView ivpic;
        TextView tvname,tvsurname;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.tvname);
            tvsurname = itemView.findViewById(R.id.tvsurname);
            ivpic = itemView.findViewById(R.id.ivpic);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onItemClicked(people.indexOf((person)view.getTag()));

                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(people.get(position));
        holder.tvname.setText(people.get(position).getName());
        holder.tvsurname.setText(people.get(position).getSurname());

        if (people.get(position).getPreference().equals("Bus"))
        {
            holder.ivpic.setImageResource(R.drawable.bus);
        }
        else
        {
            holder.ivpic.setImageResource(R.drawable.plane);
        }


    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}

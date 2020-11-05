package com.example.fragmentwithrecyclerview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>
{
    private ArrayList<Person> people;
    ItemClicked activity;
    public  interface  ItemClicked
    {
        void onItemClickied(int index);
    }
    public PersonAdapter (Context context, ArrayList<Person>list)
    {
        people =list;
        activity = (ItemClicked) context;
    }
    public class  ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvname;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.tvname);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onItemClickied(people.indexOf( (Person) view.getTag()));

                }
            });
        }
    }


    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(people.get(i));
        viewHolder.tvname.setText(people.get(i).getName());


    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}

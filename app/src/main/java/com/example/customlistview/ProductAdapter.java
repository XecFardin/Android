package com.example.customlistview;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {
    private final Context context;
    private final ArrayList<Product> values;

    public ProductAdapter(Context context, ArrayList<Product> values) {
        super(context,R.layout.row_layout,values);
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=inflater.inflate(R.layout.row_layout,parent,false);
        TextView tvproduct = (TextView)rowView.findViewById(R.id.tvproduct);
        TextView tvprice=(TextView)rowView.findViewById(R.id.tvprice);
        TextView tvdiscription=(TextView)rowView.findViewById(R.id.tvdiscription);
        ImageView ivproduct=(ImageView)rowView.findViewById(R.id.ivproduct);
        ImageView ivsale=(ImageView)rowView.findViewById(R.id.ivsale);

        tvproduct.setText(values.get(position).getTitle());
        tvprice.setText("R"+values.get(position).getPrice());
        tvdiscription.setText(values.get(position).getDiscription());




        if (values.get(position).isSale())
        {
            ivsale.setImageResource(R.mipmap.big_sale);
        }
        else
        {
            ivsale.setImageResource(R.mipmap.best_price);
        }
        if(values.get(position).getType().equals("Laptop"))
        {
            ivproduct.setImageResource(R.mipmap.laptop);
        }
        else if (values.get(position).getType().equals("Memory"))
        {
            ivproduct.setImageResource(R.mipmap.memory);
        }
        else if (values.get(position).getType().equals("Screen"))
        {
            ivproduct.setImageResource(R.mipmap.screen);
        }
        else
        {
            ivproduct.setImageResource(R.mipmap.hdd);
        }


        return rowView;
    }
}

package com.example.fragmentwithrecyclerview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFrag} factory method to
 * create an instance of this fragment.
 */
public class ListFrag extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    View view;


    public ListFrag() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView =view.findViewById(R.id.list);
        layoutManager =new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new PersonAdapter(this.getActivity(),ApplicationClass.people);
        recyclerView.setAdapter(myAdapter);
    }
    public void datachanged()
    {
        myAdapter.notifyDataSetChanged();
    }
}
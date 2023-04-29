package com.example.a305task51p;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Fragment implements MyAdapter.ItemClickListener{
    private List<newsModel> arrayListForTheFirstHorizontalRV;
    private List<newsModel> arrayListForTheSecondHorizontalRV;

    public HomePage() {
        // Required empty public constructor
    }



    public static HomePage newInstance() {
        HomePage fragment = new HomePage();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_home_page, container, false);
        initRecyclerView(v);
        addData();
        return v;
    }

    public void initRecyclerView(View view){
        RecyclerView myFirstHorizontalRV = view.findViewById(R.id.firstHorizontalRV);
        arrayListForTheFirstHorizontalRV = new ArrayList<>();
        LinearLayoutManager linearLayoutManagerForTheFirstRV = new LinearLayoutManager(getActivity());
        MyAdapter myAdapterForTheFirstHorizontalRV = new MyAdapter(arrayListForTheFirstHorizontalRV, this);
        myFirstHorizontalRV.setAdapter(myAdapterForTheFirstHorizontalRV);
        myFirstHorizontalRV.setLayoutManager(linearLayoutManagerForTheFirstRV);

        RecyclerView  mySecondHorizontalRV = view.findViewById(R.id.secondHorizontalRV);
        arrayListForTheSecondHorizontalRV = new ArrayList<>();
        LinearLayoutManager linearLayoutManagerForTheSecondRV = new LinearLayoutManager(getActivity());
        MyAdapter myAdapterForTheSecondHorizontalRV = new MyAdapter(arrayListForTheSecondHorizontalRV, this);
        mySecondHorizontalRV.setAdapter(myAdapterForTheSecondHorizontalRV);
        mySecondHorizontalRV.setLayoutManager(linearLayoutManagerForTheSecondRV);
    }

    public void addData(){
        arrayListForTheFirstHorizontalRV.add(new newsModel(R.drawable.a));
        arrayListForTheFirstHorizontalRV.add(new newsModel(R.drawable.b));
        arrayListForTheFirstHorizontalRV.add(new newsModel(R.drawable.c));
        arrayListForTheSecondHorizontalRV.add(new newsModel(R.drawable.d));
        arrayListForTheSecondHorizontalRV.add(new newsModel(R.drawable.e));
        arrayListForTheSecondHorizontalRV.add(new newsModel(R.drawable.f));
    }

    @Override
    public void onItemClick(newsModel model) {
        Fragment nf = newsFragment.newInstance(detailModel.getName(),detailModel.getDescription());
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.frameContainer, nf).commit();
    }
}
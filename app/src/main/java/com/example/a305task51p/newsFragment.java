package com.example.a305task51p;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link newsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class newsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private List<detailModel> newsDetail;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public newsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment firstNews.
     */
    // TODO: Rename and change types and number of parameters
    public static newsFragment newInstance(String param1, String param2) {
        newsFragment fragment = new newsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.news_fragment, container, false);
        initRecyclerView(v);
        addData();
        return v;
    }

    public void initRecyclerView(View v){
        RecyclerView verticalRV = v.findViewById(R.id.verticalRVForTheNews);
        newsDetail = new ArrayList<>();
        LinearLayoutManager lmForTheVerticalRV = new LinearLayoutManager(getActivity());
        adpterFoTheDetail adapter = new adpterFoTheDetail(getActivity(),newsDetail);

        verticalRV.setAdapter(adapter);
        verticalRV.setLayoutManager(lmForTheVerticalRV);
    }

    public void addData(){
        newsDetail.add(new detailModel("1st news", "This is the first news"));
        newsDetail.add(new detailModel("2nd news", "This is the second news"));
        newsDetail.add(new detailModel("3rd news", "This is the third news"));
        newsDetail.add(new detailModel("4th news", "This is the fourth news"));
        newsDetail.add(new detailModel("5th news", "This is the fifth news"));
        newsDetail.add(new detailModel("6th news", "This is the sixth news"));

    }
}
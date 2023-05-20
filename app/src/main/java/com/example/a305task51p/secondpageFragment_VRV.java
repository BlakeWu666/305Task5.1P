package com.example.a305task51p;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link secondpageFragment_VRV#newInstance} factory method to
 * create an instance of this fragment.
 */
public class secondpageFragment_VRV extends Fragment  implements adapter_firstHRV.ItemClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<newsModel> newsArrayList;
    private String[] newsTitle;
    private int[] imageResource;

    private RecyclerView recyclerView;
    private TextView news;

    public secondpageFragment_VRV() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment secondpageFragment_VRV.
     */
    // TODO: Rename and change types and number of parameters
    public static secondpageFragment_VRV newInstance(String param1, String param2) {
        secondpageFragment_VRV fragment = new secondpageFragment_VRV();
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
        return inflater.inflate(R.layout.fragment_secondpage__v_r_v, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        dataInitialize();
        recyclerView = view.findViewById(R.id.secondPage_VRV);
        news = view.findViewById(R.id.details);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter_firstHRV newAdapter = new adapter_firstHRV(getContext(),newsArrayList,this);
        recyclerView.setAdapter(newAdapter);
    }

    private void dataInitialize() {
        newsArrayList = new ArrayList<>();

        newsTitle = new String[]{
                getString(R.string.aTitle),
                getString(R.string.bTitle),
                getString(R.string.cTitle),
                getString(R.string.dTitle),
                getString(R.string.eTitle),
                getString(R.string.fTitle)
        };

        imageResource = new int[]{
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.f
        };

        for (int i = 0; i < newsTitle.length; i++){
            newsModel news = new newsModel(imageResource[i], newsTitle[i]);
            newsArrayList.add(news);
        }
    }

    @Override
    public void onItemClick(newsModel newsModel) {

    }
}
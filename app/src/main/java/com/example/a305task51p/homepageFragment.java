package com.example.a305task51p;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link homepageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homepageFragment extends Fragment implements adapter_firstHRV.ItemClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Firstly, we create some arrayList instances, we do this to fill in the recyclerView with them, the lists
    private ArrayList<newsModel> newsArrayListForTheFirstHRV;
    private ArrayList<newsModel> newsArrayListForTheSecondHRV;

    // we create a string array and a imageResource array to fill in each holder with the elements in the arrays
    private String[] newsTitle;
    private int[] imageResource;

    private RecyclerView firstHRV,secondHRV;
    private TextView news, topStories;

    public homepageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homepageFragment_firstHRV.
     */
    // TODO: Rename and change types and number of parameters
    public static homepageFragment newInstance(String param1, String param2) {
        homepageFragment fragment = new homepageFragment();
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
        return inflater.inflate(R.layout.fragment_homepage_first_h_r_v, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firstHRVDataInitialize();
        secondHRVDataInitialize();

        // we have our references here.
        firstHRV = view.findViewById(R.id.homepage_firstHRV);
        secondHRV = view.findViewById(R.id.homepage_SecondHRV);
        news = view.findViewById(R.id.news);
        topStories = view.findViewById(R.id.topStories);

        // we also use the manager to control a recycler view.
        LinearLayoutManager firstManger = new LinearLayoutManager(getContext());

        // set the orientation of the recyclerView to horizontal
        firstManger.setOrientation(LinearLayoutManager.HORIZONTAL);

        // set the manager for the horizontal recycler view (HRV).
        firstHRV.setLayoutManager(firstManger);

        // create an adapter to fill in the recyclerView with the array list.
        adapter_firstHRV firstAdapter = new adapter_firstHRV(getContext(),newsArrayListForTheFirstHRV,this);

        // set the adapter to the HRV
        firstHRV.setAdapter(firstAdapter);

        // we do this for another HRV
        LinearLayoutManager secondManager = new LinearLayoutManager(getContext());
        secondManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        secondHRV.setLayoutManager(secondManager);
        adapter_firstHRV secondAdapter = new adapter_firstHRV(getContext(),newsArrayListForTheSecondHRV,this);
        secondHRV.setAdapter(secondAdapter);
    }

    // we create a method to fill in a recyclerView with a list
    public void firstHRVDataInitialize(){

        // create a new arrayList instance, and we gonna fill in data later
        newsArrayListForTheFirstHRV = new ArrayList<>();

        // create a new string instance and get data from our strings.xml file
        newsTitle = new String[]{
                getString(R.string.aTitle),
                getString(R.string.bTitle),
                getString(R.string.cTitle)
        };

        // create a integer instance and get images from drawable package
        imageResource = new int[]{
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
        };

        // use a forLoop to fill in the arrayList using the array instances
        for (int i = 0; i < newsTitle.length; i++){
                newsModel news = new newsModel(imageResource[i], newsTitle[i]);
                newsArrayListForTheFirstHRV.add(news);
        }
    }

    public void secondHRVDataInitialize(){
        newsArrayListForTheSecondHRV = new ArrayList<>();

        newsTitle = new String[]{
                getString(R.string.dTitle),
                getString(R.string.eTitle),
                getString(R.string.fTitle),
        };

        imageResource = new int[]{
                R.drawable.d,
                R.drawable.e,
                R.drawable.f,
        };

        for (int i = 0; i < newsTitle.length; i++){
            newsModel news = new newsModel(imageResource[i], newsTitle[i]);
            newsArrayListForTheSecondHRV.add(news);
        }
    }

    @Override
    public void onItemClick(newsModel newsModel) {

        // set onItemClickListener for an element, if user click an element of the recyclerView, we will go to the next fragment

        Fragment fragment = new secondpageFragment_VRV();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_container, fragment);
        fragmentTransaction.commit();
    }
}
package com.example.a305task51p;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //We replace the UI of the mainActivity with the specified fragment
        replaceFirstFragment(new homepageFragment());

    }

    private void replaceFirstFragment(Fragment fragment) {

        // get the fragmentManager that is also known as a controller of a fragment
        FragmentManager fragmentManager = getSupportFragmentManager();

        // we use the transaction to display our fragment in UI later
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Here we gonna use the specified fragment to replace the target UI, using replace method and the id of the UI
        fragmentTransaction.replace(R.id.frameLayout_container, fragment);

        // we use commit to start the transaction
        fragmentTransaction.commit();
    }

}
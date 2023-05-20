package com.example.russianidioms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.russianidioms.adapter.TestsAdapter;
import com.example.russianidioms.domain.IdiomTest;
import com.example.russianidioms.fragments.TestFragment;
import com.example.russianidioms.fragments.TestsFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //  AppCompatButton btn_dicByAlphIdioms = findViewById(R.id.slAlphFras);
       // AppCompatButton btn_PracForIdioms = findViewById(R.id.PractiseFras);
              /* btn_PracForIdioms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(, R.id.mainActivity).navigate(R.id.action_fromMainActivity_to_ListOfTests);
            }
        });*/
    }

    /*@Override
    public void onSendData(String selectedItem) {
        TestsFragment fragment = (TestsFragment) getSupportFragmentManager()
                .findFragmentById(R.layout.list_of_tests);
        if (fragment != null)
            fragment.getContext();
    }*/

    //public void goToListOfTests(View view) {
        //Intent intent=new Intent(MainActivity.this, TestsFragment.class);
       // startActivity(intent);
    //}

   /* public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Intent intent = new Intent(this, TestsFragment.class);
            intent.putExtra("value", "message");
            startActivity(intent);
        }
    }*/
}
package com.example.russianidioms.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.russianidioms.R;
import com.example.russianidioms.adapter.DictionaryDrByThemeAdapter;
import com.example.russianidioms.adapter.DictionaryIdByThemeAdapter;
import com.example.russianidioms.domain.ThemeOfDr;
import com.example.russianidioms.domain.ThemeOfIdioms;
import com.example.russianidioms.domain.WordFromDrDic;
import com.example.russianidioms.domain.WordFromIdiomDIc;

import java.util.List;

public class DictionaryDrByThemeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.dictionary, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.dicRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        Log.e("Before adapter", "Construction");
        //DictionaryDrByThemeAdapter adapter = new DictionaryDrByThemeAdapter(themes, getContext(), DictionaryDrByThemeFragment.this);
      // recyclerView.setAdapter(adapter);
        Log.e("After adapter", "Where?");
        TextView header = view.findViewById(R.id.slHead);
        header.setText(R.string.DicThemeDrHead);
        AppCompatButton backFromDic = view.findViewById(R.id.backFromDic);
        backFromDic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(DictionaryDrByThemeFragment.this).navigate(R.id.action_dictionaryDrByThemeFragment_to_mainFragment);
            }
        });
        return view;
    }
}

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
import com.example.russianidioms.adapter.ThemeOfDrAdapter;
import com.example.russianidioms.adapter.ThemeOfIdiomsAdapter;
import com.example.russianidioms.domain.WordFromDrDic;
import com.example.russianidioms.domain.WordFromIdiomDIc;

import java.util.List;

public class ThemeOfDrFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.dictionary, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.dicRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        List<WordFromDrDic> words = List.of(
                new WordFromDrDic(1,"десница", "правая рука"),
                new WordFromDrDic(1,"десница", "правая рука"),
                new WordFromDrDic(1,"десница", "правая рука"),
                new WordFromDrDic(1,"десница", "правая рука"),
                new WordFromDrDic(1,"десница", "правая рука"),
                new WordFromDrDic(1,"десница", "правая рука")
        );
        Log.e("Before adapter", "Construction");
        ThemeOfDrAdapter adapter = new ThemeOfDrAdapter(words, getContext(), ThemeOfDrFragment.this);
        recyclerView.setAdapter(adapter);
        TextView header = view.findViewById(R.id.slHead);
        header.setText(R.string.ThemeFromDic);
        Log.e("After adapter", "Where?");
        AppCompatButton backFromTheme = view.findViewById(R.id.backFromDic);
        backFromTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ThemeOfDrFragment.this).navigate(R.id.action_themeOfDrFragment_to_dictionaryDrByThemeFragment);
            }
        });
        return view;
    }
}

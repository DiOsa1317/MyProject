package com.example.russianidioms.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.russianidioms.R;
import com.example.russianidioms.adapter.DictionaryDrByAlphAdapter;
import com.example.russianidioms.domain.WordFromDrDic;

import java.util.List;

public class DictionaryDrByAlphFragment extends Fragment {
    @Override
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
        DictionaryDrByAlphAdapter adapter = new DictionaryDrByAlphAdapter(words, getContext(), DictionaryDrByAlphFragment.this);
        recyclerView.setAdapter(adapter);
        Log.e("After adapter", "Where?");
        AppCompatButton backFromDic = view.findViewById(R.id.backFromDic);
        backFromDic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(DictionaryDrByAlphFragment.this).navigate(R.id.action_dictionaryDrByAlphFragment_to_mainFragment);
            }
        });
        return view;
    }
}

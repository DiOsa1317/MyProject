package com.example.russianidioms.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.russianidioms.R;
import com.example.russianidioms.adapter.DictionaryDrByThemeAdapter;
import com.example.russianidioms.adapter.DictionaryIdByAlphAdapter;
import com.example.russianidioms.dao.impl.WordFromIdiomDicSQLite;
import com.example.russianidioms.domain.WordFromDic;

import java.util.ArrayList;
import java.util.List;


public class DictionaryIdiomByAlphFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.dictionary, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.dicRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        Log.e("After adapter", "Where?");
        List<WordFromDic> words = new ArrayList<>();
        words = new WordFromIdiomDicSQLite(getContext()).findAll();
        DictionaryIdByAlphAdapter adapter = new DictionaryIdByAlphAdapter(words, getContext(),
                DictionaryIdiomByAlphFragment.this);
        recyclerView.setAdapter(adapter);
        AppCompatButton backFromDic = view.findViewById(R.id.backFromDic);
        backFromDic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(DictionaryIdiomByAlphFragment.this)
                        .navigate(R.id.action_dictionaryFragment_to_mainFragment);
            }
        });
        return view;
    }
}
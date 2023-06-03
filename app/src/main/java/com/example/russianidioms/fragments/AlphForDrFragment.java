package com.example.russianidioms.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.russianidioms.R;

public class AlphForDrFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vocabulary_entry, container, false);
        AppCompatButton btn_backToDictionary = view.findViewById(R.id.backFromThisIdiom);

        TextView name = view.findViewById(R.id.slAlphFrasHead);
        TextView meaning = view.findViewById(R.id.MeaningOfThisIdiom);
        TextView history = view.findViewById(R.id.ExamplesOfThis);

        name.setText(getArguments().getString("word_name"));
        meaning.setText(getArguments().getString("word_meaning"));
        history.setText(getArguments().getString("word_history"));

        btn_backToDictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AlphForDrFragment.this).navigate(R.id.action_alphForDrFragment_to_dictionaryDrByAlphFragment);
            }
        });
        return view;
    }
}

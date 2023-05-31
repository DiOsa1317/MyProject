package com.example.russianidioms.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.russianidioms.R;

public class IdiomFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vocabulary_entry, container, false);
        AppCompatButton btn_backToDictionary = view.findViewById(R.id.backFromThisIdiom);
        btn_backToDictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(IdiomFragment.this).navigate(R.id.action_idiomFragment_to_dictionaryFragment);
            }
        });
        return view;
    }
}

package com.example.russianidioms.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.russianidioms.R;

public class ThemeForAlphFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vocabulary_entry, container, false);
        AppCompatButton btn_backToTheme = view.findViewById(R.id.backFromThisIdiom);
        btn_backToTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThemeForAlphFragment.this).navigate(R.id.action_themeFragment_to_themeOfDrFragment);
            }
        });
        return view;
    }
}

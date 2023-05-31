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

public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.visial_main_xml, container, false);
        AppCompatButton btn_PracForIdioms = view.findViewById(R.id.PractiseFras);
        AppCompatButton btn_PracForDrWords = view.findViewById(R.id.PractiseDr);
        AppCompatButton btn_DicOfIdiomsByAlph = view.findViewById(R.id.slAlphFras);
        AppCompatButton btn_DicOfIdiomsByTheme = view.findViewById(R.id.slThemeFras);
        AppCompatButton btn_DicOfDrByTheme = view.findViewById(R.id.slThemeDr);
        AppCompatButton btn_DicOfDrByAlph = view.findViewById(R.id.slAlphDr);
        btn_PracForIdioms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_mainFragment_to_ListOfTests);
            }
        });
        btn_DicOfIdiomsByAlph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_mainFragment_to_dictionaryFragment);
            }
        });
        btn_PracForDrWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_mainFragment_to_drTestsFragment);
            }
        });
        btn_DicOfIdiomsByTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_mainFragment_to_dictionaryIdByThemeFragment);
            }
        });
        btn_DicOfDrByTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_mainFragment_to_dictionaryDrByThemeFragment);
            }
        });
        btn_DicOfDrByAlph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_mainFragment_to_dictionaryDrByAlphFragment);
            }
        });
        return view;
    }
}

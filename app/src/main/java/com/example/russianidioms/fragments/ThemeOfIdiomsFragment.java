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
import com.example.russianidioms.adapter.ThemeOfIdiomsAdapter;
import com.example.russianidioms.domain.WordFromIdiomDIc;

import java.util.List;

public class ThemeOfIdiomsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.dictionary, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.dicRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        List<WordFromIdiomDIc> words = List.of(
                new WordFromIdiomDIc(1,"Авгиевы конюшни", "Очень грязное место"),
                new WordFromIdiomDIc(2,"Бить баклуши", "Заниматься бесполезным делом"),
                new WordFromIdiomDIc(3,"Вить верёвки (из кого-то)", "Заставлять что-то делать. Отчитывать"),
                new WordFromIdiomDIc(4,"Гадкий утёнок", "Некрасивый человек"),
                new WordFromIdiomDIc(5,"Гадкий утёнок", "Некрасивый человек"),
                new WordFromIdiomDIc(6,"Гадкий утёнок", "Некрасивый человек"),
                new WordFromIdiomDIc(7,"Гадкий утёнок", "Некрасивый человек"),
                new WordFromIdiomDIc(8,"Гадкий утёнок", "Некрасивый человек"),
                new WordFromIdiomDIc(9,"Гадкий утёнок", "Некрасивый человек"),
                new WordFromIdiomDIc(10,"Гадкий утёнок", "Некрасивый человек"),
                new WordFromIdiomDIc(11,"Гадкий утёнок", "Некрасивый человек"),
                new WordFromIdiomDIc(12,"Гадкий утёнок", "Некрасивый человек"),
                new WordFromIdiomDIc(13,"Гадкий утёнок", "Некрасивый человек"),
                new WordFromIdiomDIc(14,"Гадкий утёнок", "Некрасивый человек")
        );
        Log.e("Before adapter", "Construction");
        ThemeOfIdiomsAdapter adapter = new ThemeOfIdiomsAdapter(words, getContext(), ThemeOfIdiomsFragment.this);
        recyclerView.setAdapter(adapter);
        TextView header = view.findViewById(R.id.slHead);
        header.setText(R.string.ThemeFromDic);
        Log.e("After adapter", "Where?");
        AppCompatButton backFromTheme = view.findViewById(R.id.backFromDic);
        backFromTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ThemeOfIdiomsFragment.this).navigate(R.id.action_themeFragment_to_dictionaryIdByThemeFragment);
            }
        });
        return view;
    }
    
}

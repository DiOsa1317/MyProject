package com.example.russianidioms.adapter.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.russianidioms.R;
import com.example.russianidioms.databinding.VocabularyEntryBinding;
import com.example.russianidioms.databinding.WordFromDicBinding;
import com.example.russianidioms.domain.WordFromIdiomDIc;
import com.example.russianidioms.fragments.DictionaryIdiomByAlphFragment;

import java.util.ArrayList;
import java.util.List;

public class DictionaryIdByAlphAdapter extends RecyclerView.Adapter<WordFrIdDicViewHolder> {

    private final WordFrIdDicClickListener listener;
    private List<WordFromIdiomDIc> words;


    public DictionaryIdByAlphAdapter(WordFrIdDicClickListener listener) {
        this.listener=listener;
    }

    @NonNull
    @Override
    public WordFrIdDicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WordFromDicBinding binding = WordFromDicBinding.
                inflate(LayoutInflater.from(parent.getContext()),parent, false);
        return new WordFrIdDicViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull WordFrIdDicViewHolder holder, int position) {
        holder.bind(words.get(position));
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public void setWords(List<WordFromIdiomDIc> words) {
        int count = getItemCount();
        this.words = new ArrayList<>(words);
        notifyItemChanged(0, Math.max(count, getItemCount()));
    }
}

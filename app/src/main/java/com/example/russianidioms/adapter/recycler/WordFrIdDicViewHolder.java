package com.example.russianidioms.adapter.recycler;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.russianidioms.databinding.VocabularyEntryBinding;
import com.example.russianidioms.databinding.WordFromDicBinding;
import com.example.russianidioms.domain.WordFromIdiomDIc;

public class WordFrIdDicViewHolder extends RecyclerView.ViewHolder {

    private WordFromDicBinding binding;
    private WordFrIdDicClickListener listener;

    public WordFrIdDicViewHolder(WordFromDicBinding binding, WordFrIdDicClickListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    public void  bind(WordFromIdiomDIc item) {
        binding.wordFromDic.setText(item.getName());
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(item.getId());
            }
        });
    }
}

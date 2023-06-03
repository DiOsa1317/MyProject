package com.example.russianidioms.adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.russianidioms.R;
import com.example.russianidioms.domain.WordFromDic;
import com.example.russianidioms.domain.WordFromIdiomDIc;
import com.example.russianidioms.fragments.DictionaryIdiomByAlphFragment;

import java.util.List;

public class DictionaryIdByAlphAdapter extends RecyclerView.Adapter<DictionaryIdByAlphAdapter.ViewHolder> {

    private List<WordFromDic> words;
    private Context context;
    private LayoutInflater layoutInflater;
    private DictionaryIdiomByAlphFragment dictionaryIdiomByAlphFragment;

    public DictionaryIdByAlphAdapter(List<WordFromDic> words, Context context, DictionaryIdiomByAlphFragment dictionaryIdiomByAlphFragment) {
        this.words = words;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.dictionaryIdiomByAlphFragment = dictionaryIdiomByAlphFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = layoutInflater.inflate(R.layout.word_from_dic, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull DictionaryIdByAlphAdapter.ViewHolder holder, int position) { //all actions here
        WordFromDic wordFromDic = words.get(position);
        holder.nameOfWord.setText(wordFromDic.getName());

        holder.nameOfWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("word_name", wordFromDic.getName());
                bundle.putString("word_meaning", wordFromDic.getMeaning());
                bundle.putString("word_history", wordFromDic.getHistory());
                Navigation.findNavController(v).navigate(R.id.action_dictionaryIdiomByAlphFragment_to_alphForIdiomFragment, bundle);
            }
        });

    }
    public int getItemCount() {
        return words.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameOfWord;


        public ViewHolder(@NonNull View itemview) {
            super(itemview);
            nameOfWord = itemview.findViewById(R.id.wordFromDic);
        }
    }
}
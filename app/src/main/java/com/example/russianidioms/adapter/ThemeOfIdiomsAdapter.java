package com.example.russianidioms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.russianidioms.R;
import com.example.russianidioms.domain.WordFromIdiomDIc;
import com.example.russianidioms.fragments.DictionaryIdiomByAlphFragment;
import com.example.russianidioms.fragments.ThemeFragment;

import java.util.List;

public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.ViewHolder> {
    private List<WordFromIdiomDIc> words;
    private Context context;
    private LayoutInflater layoutInflater;
    private ThemeFragment themeFragment;

    public ThemeAdapter(List<WordFromIdiomDIc> words, Context context, ThemeFragment themeFragment) {
        this.words = words;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.themeFragment = themeFragment;
    }

    @NonNull
    @Override
    public ThemeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = layoutInflater.inflate(R.layout.word_from_dic, parent, false);
        return new ThemeAdapter.ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ThemeAdapter.ViewHolder holder, int position) { //all actions here
        WordFromIdiomDIc wordFromIdiomDIc = words.get(position);
        holder.nameOfWord.setText(wordFromIdiomDIc.getName());
        holder.nameOfWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(themeFragment).navigate(R.id.action_dictionaryFragment_to_idiomFragment);
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

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
import com.example.russianidioms.fragments.ThemeOfIdiomsFragment;

import java.util.List;

public class ThemeOfIdiomsAdapter extends RecyclerView.Adapter<ThemeOfIdiomsAdapter.ViewHolder> {
    private List<WordFromIdiomDIc> words;
    private Context context;
    private LayoutInflater layoutInflater;
    private ThemeOfIdiomsFragment themeOfIdiomsFragment;

    public ThemeOfIdiomsAdapter(List<WordFromIdiomDIc> words, Context context, ThemeOfIdiomsFragment themeOfIdiomsFragment) {
        this.words = words;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.themeOfIdiomsFragment = themeOfIdiomsFragment;
    }

    @NonNull
    @Override
    public ThemeOfIdiomsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = layoutInflater.inflate(R.layout.word_from_dic, parent, false);
        return new ThemeOfIdiomsAdapter.ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ThemeOfIdiomsAdapter.ViewHolder holder, int position) { //all actions here
        WordFromIdiomDIc wordFromIdiomDIc = words.get(position);
        holder.nameOfWord.setText(wordFromIdiomDIc.getName());
        holder.nameOfWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(themeOfIdiomsFragment).navigate(R.id.action_themeOfIdiomsFragment_to_themeForIdiomFragment);
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

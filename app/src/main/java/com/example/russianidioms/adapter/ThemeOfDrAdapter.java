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
import com.example.russianidioms.domain.WordFromDrDic;
import com.example.russianidioms.domain.WordFromIdiomDIc;
import com.example.russianidioms.fragments.ThemeOfDrFragment;
import com.example.russianidioms.fragments.ThemeOfIdiomsFragment;

import java.util.List;

public class ThemeOfDrAdapter extends RecyclerView.Adapter<ThemeOfDrAdapter.ViewHolder>{
    private List<WordFromDrDic> words;
    private Context context;
    private LayoutInflater layoutInflater;
    private ThemeOfDrFragment themeOfDrFragment;

    public ThemeOfDrAdapter(List<WordFromDrDic> words, Context context, ThemeOfDrFragment themeOfDrFragment) {
        this.words = words;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.themeOfDrFragment = themeOfDrFragment;
    }

    @NonNull
    @Override
    public ThemeOfDrAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = layoutInflater.inflate(R.layout.word_from_dic, parent, false);
        return new ThemeOfDrAdapter.ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ThemeOfDrAdapter.ViewHolder holder, int position) { //all actions here
        WordFromDrDic wordFromDrDic = words.get(position);
        holder.nameOfWord.setText(wordFromDrDic.getName());
        holder.nameOfWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(themeOfDrFragment).navigate(R.id.action_themeOfDrFragment_to_themeForDrFragment);
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

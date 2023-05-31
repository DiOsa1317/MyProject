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
import com.example.russianidioms.fragments.DictionaryDrByAlphFragment;
import com.example.russianidioms.fragments.DictionaryIdiomByAlphFragment;

import java.util.List;

public class DictionaryDrByAlphAdapter extends RecyclerView.Adapter<DictionaryDrByAlphAdapter.ViewHolder>{
    private List<WordFromDrDic> words;
    private Context context;
    private LayoutInflater layoutInflater;
    private DictionaryDrByAlphFragment dictionaryDrByAlphFragment;

    public DictionaryDrByAlphAdapter(List<WordFromDrDic> words, Context context, DictionaryDrByAlphFragment dictionaryDrByAlphFragment) {
        this.words = words;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.dictionaryDrByAlphFragment = dictionaryDrByAlphFragment;
    }

    @NonNull
    @Override
    public DictionaryDrByAlphAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = layoutInflater.inflate(R.layout.word_from_dic, parent, false);
        return new DictionaryDrByAlphAdapter.ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull DictionaryDrByAlphAdapter.ViewHolder holder, int position) { //all actions here
        WordFromDrDic wordFromDrDic = words.get(position);
        holder.nameOfWord.setText(wordFromDrDic.getName());
        holder.nameOfWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(dictionaryDrByAlphFragment).navigate(R.id.action_dictionaryDrByAlphFragment_to_alphForDrFragment);
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

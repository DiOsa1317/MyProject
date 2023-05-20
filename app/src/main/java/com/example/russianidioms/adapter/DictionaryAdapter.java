package com.example.russianidioms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.russianidioms.R;
import com.example.russianidioms.domain.WordFromIdiomDIc;
import com.example.russianidioms.fragments.DictionaryFragment;

import java.util.List;

public class DictionaryAdapter  extends  RecyclerView.Adapter<DictionaryAdapter.ViewHolder> {

private List<WordFromIdiomDIc> words;
private Context context;
private LayoutInflater layoutInflater;
private DictionaryFragment dictionaryFragment;

public DictionaryAdapter(List<WordFromIdiomDIc> words, Context context, DictionaryFragment dictionaryFragment) {
        this.words = words;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.dictionaryFragment = dictionaryFragment;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = layoutInflater.inflate(R.layout.word_from_dic, parent, false);
        return new ViewHolder(view);
        }

    public void onBindViewHolder(@NonNull DictionaryAdapter.ViewHolder holder, int position) { //all actions here
    WordFromIdiomDIc wordFromIdiomDIc = words.get(position);
        holder.nameOfWord.setText(wordFromIdiomDIc.getName());
        holder.nameOfWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(dictionaryFragment).navigate(R.id.action_dictionaryFragment_to_idiomFragment);
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

package com.example.russianidioms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.russianidioms.R;
import com.example.russianidioms.domain.ThemeOfIdioms;
import com.example.russianidioms.domain.WordFromIdiomDIc;
import com.example.russianidioms.fragments.DictionaryIdByThemeFragment;
import com.example.russianidioms.fragments.DictionaryIdiomByAlphFragment;

import java.util.List;

public class DictionaryIdByThemeAdapter extends RecyclerView.Adapter<DictionaryIdByThemeAdapter.ViewHolder>{
    private List<ThemeOfIdioms> themes;
    private Context context;
    private LayoutInflater layoutInflater;
    private DictionaryIdByThemeFragment dictionaryIdByThemeFragment;

    public DictionaryIdByThemeAdapter(List<ThemeOfIdioms> themes, Context context, DictionaryIdByThemeFragment dictionaryIdByThemeFragment) {
        this.themes = themes;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.dictionaryIdByThemeFragment = dictionaryIdByThemeFragment;
    }

    @NonNull
    @Override
    public DictionaryIdByThemeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = layoutInflater.inflate(R.layout.theme, parent, false);
        return new DictionaryIdByThemeAdapter.ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull DictionaryIdByThemeAdapter.ViewHolder holder, int position) { //all actions here
        ThemeOfIdioms themeOfIdioms= themes.get(position);
        holder.backImage.setImageResource(R.drawable.registration_rectangle);
        holder.themeOfTest.setText(themeOfIdioms.getName());
        holder.btnGoToWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(dictionaryIdByThemeFragment).navigate(R.id.action_dictionaryIdByThemeFragment_to_themeFragment);
            }
        });

    }
    public int getItemCount() {
        return themes.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView backImage;
        TextView themeOfTest;
        AppCompatButton btnGoToWord;

        public ViewHolder(@NonNull View itemview) {
            super(itemview);
            backImage=itemview.findViewById(R.id.reg_rectangle);
            themeOfTest=itemview.findViewById(R.id.themeOfTest);
            btnGoToWord=itemview.findViewById(R.id.btn_GoToWord);

        }
    }
}

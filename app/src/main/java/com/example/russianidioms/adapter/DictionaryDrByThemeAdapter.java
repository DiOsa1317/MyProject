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
import com.example.russianidioms.domain.ThemeOfDr;
import com.example.russianidioms.domain.ThemeOfIdioms;
import com.example.russianidioms.fragments.DictionaryDrByThemeFragment;
import com.example.russianidioms.fragments.DictionaryIdByThemeFragment;

import java.util.List;

public class DictionaryDrByThemeAdapter extends RecyclerView.Adapter<DictionaryDrByThemeAdapter.ViewHolder>{
    private List<ThemeOfDr> themes;
    private Context context;
    private LayoutInflater layoutInflater;
    private DictionaryDrByThemeFragment dictionaryDrByThemeFragment;

    public DictionaryDrByThemeAdapter(List<ThemeOfDr> themes, Context context, DictionaryDrByThemeFragment dictionaryDrByThemeFragment) {
        this.themes = themes;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.dictionaryDrByThemeFragment = dictionaryDrByThemeFragment;
    }

    @NonNull
    @Override
    public DictionaryDrByThemeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = layoutInflater.inflate(R.layout.theme, parent, false);
        return new DictionaryDrByThemeAdapter.ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull DictionaryDrByThemeAdapter.ViewHolder holder, int position) { //all actions here
        ThemeOfDr themeOfDr= themes.get(position);
        holder.backImage.setImageResource(R.drawable.registration_rectangle);
        holder.themeOfTest.setText(themeOfDr.getName());
        holder.btnGoToWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(dictionaryDrByThemeFragment)
                        .navigate(R.id.action_dictionaryDrByThemeFragment_to_themeOfDrFragment);
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

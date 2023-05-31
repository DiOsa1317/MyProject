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
import com.example.russianidioms.domain.DrTest;
import com.example.russianidioms.fragments.DrTestsFragment;

import java.util.List;

public class DrTestsAdapter extends RecyclerView.Adapter<DrTestsAdapter.ViewHolder>{

    private List<DrTest> tests;
    private Context context;
    private LayoutInflater layoutInflater;
    private DrTestsFragment drTestsFragment;

    public DrTestsAdapter(List<DrTest> tests, Context context, DrTestsFragment drTestsFragment) {
        this.tests = tests;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.drTestsFragment = drTestsFragment;
    }

    @NonNull
    @Override
    public DrTestsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = layoutInflater.inflate(R.layout.front_of_test, parent, false);
        return new DrTestsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrTestsAdapter.ViewHolder holder, int position) { //all actions here
        DrTest drTest = tests.get(position);
        holder.backImage.setImageResource(R.drawable.registration_rectangle);
        holder.nameOfTest.setText(drTest.getName());
        holder.themeOfTest.setText(drTest.getTheme());
        holder.btnStart.setText(R.string.Start);
        holder.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(drTestsFragment).navigate(R.id.action_drTestsFragment_to_drTestFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tests.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView backImage;
        TextView nameOfTest;
        TextView themeOfTest;
        AppCompatButton btnStart;

        public ViewHolder(@NonNull View itemview) {
            super(itemview);
            backImage=itemview.findViewById(R.id.reg_rectangle);
            nameOfTest=itemview.findViewById(R.id.nameOfTest);
            themeOfTest=itemview.findViewById(R.id.themeOfTEst);
            btnStart=itemview.findViewById(R.id.btn_Start);

        }
    }
}

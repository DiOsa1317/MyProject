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
import com.example.russianidioms.domain.IdiomTest;
import com.example.russianidioms.fragments.IdiomTestsFragment;

import java.util.List;

public class TestsAdapter extends RecyclerView.Adapter<TestsAdapter.ViewHolder> {
    private List<IdiomTest> tests;
    private Context context;
    private LayoutInflater layoutInflater;
    private IdiomTestsFragment idiomTestsFragment;

    public TestsAdapter(List<IdiomTest> tests, Context context, IdiomTestsFragment idiomTestsFragment) {
        this.tests = tests;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.idiomTestsFragment = idiomTestsFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = layoutInflater.inflate(R.layout.front_of_test, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { //all actions here
        IdiomTest idiomTest = tests.get(position);
        holder.backImage.setImageResource(R.drawable.registration_rectangle);
        holder.nameOfTest.setText(idiomTest.getName());
        holder.themeOfTest.setText(idiomTest.getTheme());
        holder.btnStart.setText(R.string.Start);
        holder.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(idiomTestsFragment).navigate(R.id.action_IdiomTestsFragment_to_idiomTestFragment);
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


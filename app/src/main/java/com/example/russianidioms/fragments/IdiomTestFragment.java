package com.example.russianidioms.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.russianidioms.R;
import com.example.russianidioms.domain.IdiomTest;

public class IdiomTestFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);

        IdiomTest test1 = new IdiomTest(1, "Тема 1","Аналоги", "кот наплакал",
                "мышь нарыдала", "медведь натопал", "кукушка накуковала",
                getResources().getDrawable(R.drawable.ic_baseline_work_24));
        AppCompatButton btn_backToListOfTests = view.findViewById(R.id.backFromTest);
        AppCompatButton varient1 = view.findViewById(R.id.ans1);
        varient1.setText(test1.getVarient1());
        btn_backToListOfTests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(IdiomTestFragment.this).navigate(R.id.action_idiomTestFragment_to_ListOfTests);
            }
        });
        varient1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Moved", Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(IdiomTestFragment.this).navigate(R.id.action_idiomTestFragment_self);
            }
        });
        return view;
    }
}

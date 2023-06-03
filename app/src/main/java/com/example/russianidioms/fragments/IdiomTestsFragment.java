package com.example.russianidioms.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.russianidioms.R;
import com.example.russianidioms.adapter.TestsAdapter;
import com.example.russianidioms.dao.impl.IdiomTestSQLite;
import com.example.russianidioms.domain.IdiomTest;

import java.util.ArrayList;
import java.util.List;

public class IdiomTestsFragment extends Fragment {
    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.list_of_tests, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_listOfTests);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
   List<IdiomTest> tests = new ArrayList<>();
        tests = new IdiomTestSQLite(getContext()).findAll();
        Log.e("Before adapter", "Construction");
        TestsAdapter adapter = new TestsAdapter(tests, getContext(), IdiomTestsFragment.this);
      recyclerView.setAdapter(adapter);
        Log.e("After adapter", "Where?");
        AppCompatButton back = view.findViewById(R.id.backFromTests);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(IdiomTestsFragment.this).navigate(R.id.action_IdiomTestsFragment_to_mainFragment);
            }
        });
        return view;

    }
}

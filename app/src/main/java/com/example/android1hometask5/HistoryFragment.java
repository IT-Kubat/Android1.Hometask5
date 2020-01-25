package com.example.android1hometask5;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment implements Result_Send {

    RecyclerView recyclerView;
    MainAdapter adapter;
    String acceptAnswer;




    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ((MainActivity) Objects.requireNonNull(getActivity())).sendValue(new Result_Send() {
                @Override
                public void send(String text) {
                    acceptAnswer = text;
                    if (acceptAnswer != null) {
                        adapter.addText(acceptAnswer);

                    }
                }
            });
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void send(String text) {
        if(text != null){
            String acceptAnswer = text;
        }
    }
}

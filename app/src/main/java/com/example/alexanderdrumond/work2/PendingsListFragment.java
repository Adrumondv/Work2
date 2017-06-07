package com.example.alexanderdrumond.work2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexanderdrumond.work2.adapters.PendingsAdapter;
import com.example.alexanderdrumond.work2.adapters.PendingsClick;
import com.example.alexanderdrumond.work2.models.Pending;

/**
 * A placeholder fragment containing a simple view.
 */
public class PendingsListFragment extends Fragment implements PendingsClick {

    public static final String PENDING_ID = "com.example.alexanderdrumond.work2.KEY.PENDING_ID";

    private PendingsAdapter Adapter;

    public PendingsListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pendingslist, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view;
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);

        
        Adapter = new PendingsAdapter(this);

        recyclerView.setAdapter(Adapter);


    }

    public void addPending(Pending pending){
        Adapter.addPending(pending);
    }

    @Override
    public void clicked(long id) {
        Intent intent =  new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(PENDING_ID, id);
        startActivity(intent);

    }
}

package com.example.baitaplon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baitaplon.adapters.HomeHorAdapter;
import com.example.baitaplon.adapters.HomeVerAdapter;
import com.example.baitaplon.adapters.UpdateVerticalRec;
import com.example.baitaplon.models.HomeHorModel;
import com.example.baitaplon.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment implements UpdateVerticalRec {

        RecyclerView homeHorizontalRec,homeVerticalRec;
        ArrayList<HomeHorModel> homeHorModelList;
        HomeHorAdapter homeHorAdapter;

        ArrayList<HomeVerModel> homeVerModelList;
        HomeVerAdapter homeVerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu, container, false);
        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);

        homeHorModelList = new ArrayList<>();
        homeHorModelList.add(new HomeHorModel(R.drawable.glass1, "Coffee"));
        homeHorModelList.add(new HomeHorModel(R.drawable.bakerylogo, "Bakery"));


       homeHorAdapter = new HomeHorAdapter(this,getActivity(),homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled( false);



        ////////////////////vertical recyclerView
        homeVerModelList = new ArrayList<>();

        homeVerAdapter = new HomeVerAdapter(getActivity(),homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));

        return root;
    }

    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {
        homeVerAdapter = new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);
    }
}
package com.example.viewpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SliderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    int[] layoutScreen;

    SliderAdapter mAdapter;
    public SliderAdapter(int[] layoutScreen){
        this.layoutScreen = layoutScreen;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // return null;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);
        return new SliderViewHolder(view);
    }
    public class SliderViewHolder extends RecyclerView.ViewHolder{

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return layoutScreen[position];
    }

    @Override
    public int getItemCount() {
        return layoutScreen.length;
    }
}

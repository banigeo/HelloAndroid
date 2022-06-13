package com.banigeo.helloandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> implements Filterable {
    private List<String> localDataSet;
    private List<String> fullDataset;
    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filterPattern = constraint.toString().toLowerCase().trim();
            List<String> filteredDataSet = new ArrayList<>();
            for(String data : fullDataset) {
                if(data.toLowerCase().contains(filterPattern)){
                    filteredDataSet.add(data);
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredDataSet;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            localDataSet = new ArrayList<>((List)results.values);
            notifyDataSetChanged();
        }
    };

    @Override
    public Filter getFilter() {
        return filter;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textViewRecycler);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public CustomAdapter(List<String> dataSet) {
        localDataSet = dataSet;
        fullDataset = new ArrayList<>(localDataSet);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTextView().setText(localDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

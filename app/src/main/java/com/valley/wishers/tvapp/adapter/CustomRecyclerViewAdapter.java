package com.valley.wishers.tvapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.valley.wishers.tvapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomRecyclerViewAdapter extends
        RecyclerView.Adapter<CustomRecyclerViewAdapter.MyViewHolder> {
    private List<String> dataList;
    private Context context;

    public CustomRecyclerViewAdapter(Context context, List<String> items) {
        this.context = context;
        dataList = items;
    }

    public void setDataList(List<String> items) {
        this.dataList = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.card_view_item, viewGroup, false);
        return new MyViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        String data = dataList.get(position);
        myViewHolder.cardViewTitle.setText(data);
    }

    @Override
    public int getItemCount() {
        if (dataList != null) {
            return dataList.size();
        } else {
            return 0;
        }
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.cardViewTitleTv)
        TextView cardViewTitle;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View v) {

        }
    }
}

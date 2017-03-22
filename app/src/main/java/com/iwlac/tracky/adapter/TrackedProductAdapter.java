package com.iwlac.tracky.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iwlac.tracky.ProductClickListener;
import com.iwlac.tracky.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by buupv on 3/22/17.
 */

public class TrackedProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> listTrackedProduct;
    private Context context;
    private ProductClickListener listener;

    public TrackedProductAdapter(List<String> listTrackedProduct,ProductClickListener listener) {
        this.listTrackedProduct = listTrackedProduct;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.tracked_product, parent, false);

        // Return a new holder instance
        final TrackedProductViewHolder viewHolder = new TrackedProductViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TrackedProductViewHolder viewHolder = (TrackedProductViewHolder) holder;
        configureTrackedProductViewHolder(viewHolder, position);
    }

    private void configureTrackedProductViewHolder(TrackedProductViewHolder viewHolder, int position) {
        String name = listTrackedProduct.get(position);
        viewHolder.tvName.setText(name);
    }

    @Override
    public int getItemCount() {
        return listTrackedProduct.size();
    }

    public void add(List<String> name) {
        listTrackedProduct.addAll(name);
        this.notifyDataSetChanged();
    }

    public void clear() {
        listTrackedProduct.clear();
        this.notifyDataSetChanged();
    }

    public class TrackedProductViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvName)
        TextView tvName;

        public TrackedProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}

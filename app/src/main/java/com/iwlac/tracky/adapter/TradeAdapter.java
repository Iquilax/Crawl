package com.iwlac.tracky.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iwlac.tracky.ProductClickListener;
import com.iwlac.tracky.R;
import com.iwlac.tracky.models.TrackedProduct;
import com.iwlac.tracky.models.Trade;
import com.iwlac.tracky.utility.GlideHelper;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by buupv on 3/26/17.
 */

public class TradeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Trade> listTrackedProduct;
    private Context context;
    private ProductClickListener listener;

    public TradeAdapter(List<Trade> listTrackedProduct, ProductClickListener listener) {
        this.listTrackedProduct = listTrackedProduct;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.trade_item, parent, false);

        // Return a new holder instance
        final TradeAdapter.TradeViewHolder viewHolder = new TradeAdapter.TradeViewHolder(view);
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
        TradeAdapter.TradeViewHolder viewHolder = (TradeAdapter.TradeViewHolder) holder;
        configureTradeViewHolder(viewHolder, position);
    }

    private void configureTradeViewHolder(TradeAdapter.TradeViewHolder viewHolder, int position) {
        Trade item = listTrackedProduct.get(position);
        viewHolder.tvChannel.setText(item.getTrackedPlaces());
        viewHolder.tvPrice.setText("$" + item.getPrice());
    }

    @Override
    public int getItemCount() {
        return listTrackedProduct.size();
    }

    public void add(Trade name) {
        listTrackedProduct.add(name);
        this.notifyDataSetChanged();
    }
    public void addAll(List<Trade> name) {
        listTrackedProduct.addAll(name);
        this.notifyDataSetChanged();
    }

    public void clear() {
        listTrackedProduct.clear();
        this.notifyDataSetChanged();
    }

    public class TradeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvChannel)
        TextView tvChannel;
        @BindView(R.id.tvPrice)
        TextView tvPrice;

        public TradeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

package com.iwlac.tracky.adapter;

import android.content.Context;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.iid.FirebaseInstanceId;
import com.iwlac.tracky.ProductClickListener;
import com.iwlac.tracky.R;
import com.iwlac.tracky.activity.MainActivity;
import com.iwlac.tracky.firebasemanager.Database;
import com.iwlac.tracky.fragment.TrackPriceDialogFragment;
import com.iwlac.tracky.models.TrackedProduct;
import com.iwlac.tracky.models.Trade;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by buupv on 3/26/17.
 */

public class TrendingProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<TrackedProduct> listTrackedProduct;
    private Context context;
    private ProductClickListener listener;

    public TrendingProductAdapter(List<TrackedProduct> listTrackedProduct, ProductClickListener listener) {
        this.listTrackedProduct = listTrackedProduct;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.hot_product, parent, false);

        // Return a new holder instance
        final TrendingProductViewHolder viewHolder = new TrendingProductViewHolder(view);
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
        TrendingProductViewHolder viewHolder = (TrendingProductViewHolder) holder;
        configureTrackedProductViewHolder(viewHolder, position);
    }

    private void configureTrackedProductViewHolder(final TrendingProductViewHolder viewHolder, int position) {

        try {
            final TrackedProduct item = listTrackedProduct.get(position);
            viewHolder.tvName.setText(item.getTitle());
            List<Trade> trades = new ArrayList<>(item.getUpdates().values());
            viewHolder.tvPrice.setText(String.format("%1$,.0f", trades.get(0).getPrice()) + "₫");
            viewHolder.btnTrack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fm = ((MainActivity) context).getSupportFragmentManager();
                    TrackPriceDialogFragment trackPriceDialogFragment = TrackPriceDialogFragment.newInstance(item.getId());
                    trackPriceDialogFragment.show(fm, "fragment_track_price");
                }
            });
            Glide.with(context).load(trades.get(0).getFullPicture()).into(viewHolder.imThumbnail);
        } catch (Exception e) {
            Toast.makeText(context, "Not found", Toast.LENGTH_SHORT).show();
//            return;
        }


    }

    @Override
    public int getItemCount() {
        return listTrackedProduct.size();
    }

    public void add(TrackedProduct name) {
        listTrackedProduct.add(name);
        this.notifyDataSetChanged();
    }

    public void addAll(List<TrackedProduct> name) {
        listTrackedProduct.addAll(name);
        this.notifyDataSetChanged();
    }

    public void clear() {
        listTrackedProduct.clear();
        this.notifyDataSetChanged();
    }

    public class TrendingProductViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.imThumbnail)
        ImageView imThumbnail;
        @BindView(R.id.tvPrice)
        TextView tvPrice;
        @BindView(R.id.btnTrack)
        FloatingActionButton btnTrack;


        public TrendingProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

package com.iwlac.tracky.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.iwlac.tracky.ProductClickListener;
import com.iwlac.tracky.R;
import com.iwlac.tracky.activity.MainActivity;
import com.iwlac.tracky.activity.PriceCompareActivity;
import com.iwlac.tracky.adapter.TrendingProductAdapter;
import com.iwlac.tracky.models.CrawlResponse;
import com.iwlac.tracky.networks.ApiService;
import com.iwlac.tracky.networks.CrawlerAPI;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.iwlac.tracky.utility.IntentConstant.EXTRA_PRODUCT_CODE;

/**
 * A simple {@link Fragment} subclass.
 */
public class BrowseProductFragment extends Fragment {
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.btnCrawl)
    Button btnCrawl;
    @BindView(R.id.loading_screen)
    GifImageView loading;
    CrawlerAPI crawlerAPI = ApiService.getInstance();

    public BrowseProductFragment() {
        // Required empty public constructor
    }

    public static BrowseProductFragment newInstance() {
        BrowseProductFragment fragment = new BrowseProductFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_browse_product, container, false);
        ButterKnife.bind(this,view);
        btnCrawl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading.setVisibility(View.VISIBLE);
                crawlerAPI.getProductID(etName.getText().toString()).enqueue(new Callback<CrawlResponse>() {
                    @Override
                    public void onResponse(Call<CrawlResponse> call, Response<CrawlResponse> response) {
                        Intent i = new Intent(getContext(), PriceCompareActivity.class);
                        i.putExtra(EXTRA_PRODUCT_CODE, response.body().getName());
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(Call<CrawlResponse> call, Throwable t) {
                        loading.setVisibility(View.INVISIBLE);
                        Toast.makeText(getContext(), "Some error occurs", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return view;
    }

}

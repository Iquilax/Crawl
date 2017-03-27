package com.iwlac.tracky.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.iwlac.tracky.R;
import com.iwlac.tracky.utility.MessageString;

import butterknife.BindView;
import butterknife.ButterKnife;



/**
 * Created by Thien on 3/22/2017.
 */

public class ProductDetailFragment extends Fragment implements Button.OnClickListener {

    public static final String ARG_PAGE = "ARG_PAGE";

    @BindView(R.id.ivProductDetailImage)
    ImageView ivProductImage;
    @BindView(R.id.tvProductDetailPrice)
    TextView tvProductPrice;
    @BindView(R.id.btnTrack)
    Button btnTrack;

    public static ProductDetailFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ProductDetailFragment fragment = new ProductDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("Test", "onCreate");
        //call API to get product detail
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_detail, container, false);
        ButterKnife.bind(this, view);
        tvProductPrice.setText("490$");
        loadImageToView("http://www.fusible.net/image/upload/minh.bt/2016/5/7/312/312_GrJ4Pw682c.jpg", ivProductImage);
        btnTrack.setOnClickListener(this);
        Log.d("Test", "onCreateView");
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnTrack:
                Toast.makeText(this.getActivity(), MessageString.TRACK_SUCCESSFULLY, Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this.getActivity(), MessageString.UNEXPECTED_ERROR, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void loadImageToView(String imgUrl, ImageView view){
        Glide.with(getContext()).load(imgUrl).into(view);
    }
}

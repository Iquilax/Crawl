package com.iwlac.tracky.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.iwlac.tracky.ProductClickListener;
import com.iwlac.tracky.R;
import com.iwlac.tracky.activity.PriceCompareActivity;
import com.iwlac.tracky.adapter.TrackedProductAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.apptik.widget.MultiSlider;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrackPriceDialogFragment extends DialogFragment {
    private OnFragmentInteractionListener mListener;
    @BindView(R.id.btnTrack)
    Button btnTrack;
    @BindView(R.id.rbPrice)
    MultiSlider rbPrice;
    @BindView(R.id.tvMin)
    TextView tvMin;
    @BindView(R.id.tvMax)
    TextView tvMax;

    public TrackPriceDialogFragment() {
        // Required empty public constructor
    }

    public static TrackPriceDialogFragment newInstance() {
        TrackPriceDialogFragment fragment = new TrackPriceDialogFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_track_price_dialog, container, false);
        ButterKnife.bind(this, view);
        btnTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFragmentInteraction(rbPrice.getThumb(0).getValue());
                dismiss();
            }
        });
        rbPrice.setOnThumbValueChangeListener(new MultiSlider.OnThumbValueChangeListener() {
            @Override
            public void onValueChanged(MultiSlider multiSlider, MultiSlider.Thumb thumb, int thumbIndex, int value) {
                if (thumbIndex == 0) {
                    tvMin.setText(" " + value);
                } else {
                    tvMax.setText(" " + value);
                }
            }
        });
        rbPrice.setMax(1000,true,true);

//        rbPrice.getThumb(1).setValue(1000);
        rbPrice.setMin(500,true,true);


        return view;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(double price);
    }
}

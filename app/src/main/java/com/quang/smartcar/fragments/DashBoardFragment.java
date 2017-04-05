package com.quang.smartcar.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quang.smartcar.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment {

    private TextView tvHeartBeat, tvTemperature, tvAlcoholConcentration, tvConclude;
    int heartBeat, temperature;
    float alcohol;

    public DashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dash_board, container, false);
        tvAlcoholConcentration = (TextView) v.findViewById(R.id.textViewAlcoholConcentration);
        tvConclude = (TextView) v.findViewById(R.id.textViewConclude);
        tvHeartBeat = (TextView) v.findViewById(R.id.textViewHeartBeat);
        tvTemperature = (TextView) v.findViewById(R.id.textViewTemperature);
        showConclude();
        return v;
    }

    private void showConclude() {
        heartBeat = Integer.parseInt(tvHeartBeat.getText().toString());
        temperature = Integer.parseInt(tvTemperature.getText().toString());
        alcohol = Float.parseFloat(tvAlcoholConcentration.getText().toString());
        if (heartBeat <= 80 && heartBeat >= 60 && temperature == 37 && alcohol <= 0.25)
            tvConclude.setText("Các chỉ số bình thường. Bạn được phép lái xe.");
        else tvConclude.setText("Các chỉ số không bình thường. Bạn không được phép lái xe.");
    }

}

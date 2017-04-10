package com.quang.smartcar.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
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

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference alcoholRef = database.getReference("alcohol");
        DatabaseReference temperatureRef = database.getReference("temperature");
        DatabaseReference heartBeatRef = database.getReference("heartbeat");
        alcoholRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue(Float.class) == null) {
                    tvAlcoholConcentration.setText("Đang đo");
                } else
                    tvAlcoholConcentration.setText(String.valueOf(dataSnapshot.getValue(Float.class)));
                showConclude();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        temperatureRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue(Integer.class) == null) {
                    tvTemperature.setText("Đang đo");
                } else
                    tvTemperature.setText(String.valueOf(dataSnapshot.getValue(Integer.class)));
                showConclude();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        heartBeatRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue(Integer.class) == null) {
                    tvHeartBeat.setText("Đang đo");
                } else
                    tvHeartBeat.setText(String.valueOf(dataSnapshot.getValue(Integer.class)));
                showConclude();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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

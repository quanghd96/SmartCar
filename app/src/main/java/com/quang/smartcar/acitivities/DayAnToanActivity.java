package com.quang.smartcar.acitivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.quang.smartcar.R;

public class DayAnToanActivity extends AppCompatActivity {
    private ImageView btnBatTat;
    private TextView tvBatTat;
    private boolean isBat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_an_toan);
        findViewById();
        btnBatTat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isBat = !isBat;
                if (isBat) {
                    btnBatTat.setImageResource(R.drawable.on);
                    tvBatTat.setText("Đã mở khóa");
                } else {
                    btnBatTat.setImageResource(R.drawable.off);
                    tvBatTat.setText("Đã khóa");
                }
            }
        });
        if (isBat) {
            btnBatTat.setImageResource(R.drawable.on);
            tvBatTat.setText("Đã mở khóa");
        } else {
            btnBatTat.setImageResource(R.drawable.off);
            tvBatTat.setText("Đã khóa");
        }
    }

    private void findViewById() {
        btnBatTat = (ImageView) findViewById(R.id.buttonBatTat);
        tvBatTat = (TextView) findViewById(R.id.textViewBatTat);
    }
}

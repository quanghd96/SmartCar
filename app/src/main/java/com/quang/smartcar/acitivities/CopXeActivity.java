package com.quang.smartcar.acitivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.quang.smartcar.R;

public class CopXeActivity extends AppCompatActivity {

    private ImageView btnBatTat, imvOpen, imvClose;
    private TextView tvBatTat;
    private boolean isBat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cop_xe);
        findViewById();
        if (isBat) {
            btnBatTat.setImageResource(R.drawable.on);
            tvBatTat.setText("Đã bật chức năng tự động mở cốp xe");
        } else {
            btnBatTat.setImageResource(R.drawable.off);
            tvBatTat.setText("Đã tắt chức năng tự động mở cốp xe");
        }
        Glide.with(CopXeActivity.this).load(R.drawable.copxe_open).into(imvOpen);
        Glide.with(CopXeActivity.this).load(R.drawable.copxe_close).into(imvClose);
        btnBatTat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isBat = !isBat;
                if (isBat) {
                    btnBatTat.setImageResource(R.drawable.on);
                    tvBatTat.setText("Đã bật chức năng tự động mở cốp xe");
                } else {
                    btnBatTat.setImageResource(R.drawable.off);
                    tvBatTat.setText("Đã tắt chức năng tự động mở cốp xe");
                }
            }
        });
    }

    private void findViewById() {
        btnBatTat = (ImageView) findViewById(R.id.buttonBatTat);
        imvOpen = (ImageView) findViewById(R.id.imageViewOpen);
        imvClose = (ImageView) findViewById(R.id.imageViewClose);
        tvBatTat = (TextView) findViewById(R.id.textViewBatTat);
    }
}

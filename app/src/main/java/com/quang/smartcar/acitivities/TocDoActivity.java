package com.quang.smartcar.acitivities;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.quang.smartcar.R;

public class TocDoActivity extends AppCompatActivity {

    private Button btnBatDau, btnKetThuc;
    private EditText edt;
    private TextView tvTrangThai;
    private int tocDoMax;
    private boolean isBatDau, isShowing;
    private AlertDialog.Builder builder;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toc_do);
        findViewById();
        btnBatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt.getText().toString().trim().length() > 0) {
                    isBatDau = true;
                    tocDoMax = Integer.parseInt(edt.getText().toString());
                    tvTrangThai.setText("Tốc độ tối đa là: " + edt.getText().toString() + " km/h");
                    edt.clearFocus();
                }
            }
        });
        btnKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isBatDau = false;
                tocDoMax = 0;
                edt.setText("");
                tvTrangThai.setText("Bạn chưa thiết lập tốc độ tối đa.");
            }
        });
        builder = new AlertDialog.Builder(TocDoActivity.this);
        builder.setMessage("Nguy hiểm!\n Bạn đang đi với tốc độ quá tốc độ tối đa.\n Hệ thống sẽ tự động giảm tốc độ của bạn.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                mediaPlayer.stop();
                isShowing = false;
            }
        });
        builder.setCancelable(false);
        builder.create();
        FirebaseDatabase.getInstance().getReference("TocDo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    if (isBatDau && dataSnapshot.getValue(Integer.class) > tocDoMax) {
                        if (!isFinishing() && !isShowing) {
                            builder.show();
                            mediaPlayer.start();
                            isShowing = true;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void findViewById() {
        btnBatDau = (Button) findViewById(R.id.buttonBatDau);
        btnKetThuc = (Button) findViewById(R.id.buttonKetThuc);
        edt = (EditText) findViewById(R.id.editText);
        tvTrangThai = (TextView) findViewById(R.id.textViewTrangThai);
        mediaPlayer = MediaPlayer.create(TocDoActivity.this, R.raw.warning);
        mediaPlayer.setLooping(true);
    }
}

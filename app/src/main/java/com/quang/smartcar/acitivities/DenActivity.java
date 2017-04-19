package com.quang.smartcar.acitivities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.quang.smartcar.R;

import java.util.ArrayList;
import java.util.Locale;

public class DenActivity extends AppCompatActivity {
    private static final int REQ_CODE_SPEECH_INPUT = 1000;
    private ImageView btnBatTat, btnSpeak;
    private TextView tvBatTat;
    private boolean isBat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_den);
        findViewById();
        btnBatTat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isBat = !isBat;
                if (isBat) {
                    btnBatTat.setImageResource(R.drawable.on);
                    tvBatTat.setText("Đã bật đèn");
                } else {
                    btnBatTat.setImageResource(R.drawable.off);
                    tvBatTat.setText("Đã tắt đèn");
                }
            }
        });
        if (isBat) {
            btnBatTat.setImageResource(R.drawable.on);
            tvBatTat.setText("Đã bật đèn");
        } else {
            btnBatTat.setImageResource(R.drawable.off);
            tvBatTat.setText("Đã tắt đèn");
        }
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    if (result.get(0).contains("tắt đèn số")) {
                        Toast.makeText(DenActivity.this, "Đã " + result.get(0), Toast.LENGTH_LONG).show();
                    } else if (result.get(0).contains("bật đèn số")) {
                        Toast.makeText(DenActivity.this, "Đã " + result.get(0), Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(DenActivity.this, "Xin mời nói lại!", Toast.LENGTH_LONG).show();
                }
                break;
            }

        }
    }

    private void findViewById() {
        btnBatTat = (ImageView) findViewById(R.id.buttonBatTat);
        btnSpeak = (ImageView) findViewById(R.id.buttonSpeek);
        tvBatTat = (TextView) findViewById(R.id.textViewBatTat);
    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }
}

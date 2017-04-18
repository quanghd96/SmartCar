package com.quang.smartcar.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.quang.smartcar.R;
import com.quang.smartcar.acitivities.CopXeActivity;
import com.quang.smartcar.acitivities.CuaXeActivity;
import com.quang.smartcar.acitivities.DayAnToanActivity;
import com.quang.smartcar.acitivities.DenActivity;
import com.quang.smartcar.acitivities.GheActivity;
import com.quang.smartcar.acitivities.KinhActivity;
import com.quang.smartcar.acitivities.MediaActivity;
import com.quang.smartcar.acitivities.TocDoActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment {

    private ImageButton btnCopXe, btnCuaXe, btnDayAnToan, btnDen, btnGhe, btnKinh, btnMedia, btnTocDo;
    private View view;

    public DashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dash_board, container, false);
        findViewById();
        btnCopXe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), CopXeActivity.class));
            }
        });
        btnCuaXe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), CuaXeActivity.class));
            }
        });
        btnDayAnToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), DayAnToanActivity.class));
            }
        });
        btnDen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), DenActivity.class));
            }
        });
        btnGhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), GheActivity.class));
            }
        });
        btnKinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), KinhActivity.class));
            }
        });
        btnMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), MediaActivity.class));
            }
        });
        btnTocDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), TocDoActivity.class));
            }
        });
        return view;
    }

    private void findViewById() {
        btnCopXe = (ImageButton) view.findViewById(R.id.buttonCopXe);
        btnCuaXe = (ImageButton) view.findViewById(R.id.buttonCuaXe);
        btnDayAnToan = (ImageButton) view.findViewById(R.id.buttonDayAnToan);
        btnDen = (ImageButton) view.findViewById(R.id.buttonDen);
        btnGhe = (ImageButton) view.findViewById(R.id.buttonGhe);
        btnKinh = (ImageButton) view.findViewById(R.id.buttonKinh);
        btnMedia = (ImageButton) view.findViewById(R.id.buttonMedia);
        btnTocDo = (ImageButton) view.findViewById(R.id.buttonTocDo);

    }
}

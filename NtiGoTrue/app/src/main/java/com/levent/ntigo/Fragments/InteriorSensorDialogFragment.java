package com.levent.ntigo.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.levent.ntigo.R;

public class InteriorSensorDialogFragment extends DialogFragment  {

    TextView unitDesc,unitAlarm,unitValue;
    Drawable background;
    String desc,alarm,value;
    RelativeLayout interiorFragmentRelative;

    public InteriorSensorDialogFragment(String desc, String alarm, String value, Drawable background) {
        this.desc = desc;
        this.alarm = alarm;
        this.value = value;
        this.background = background;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_interior_sensor_dialog,null);

        unitDesc=view.findViewById(R.id.fragment_dahili_sensor_desc);
        unitAlarm=view.findViewById(R.id.fragment_dahili_sensor_alarm_durumu);
        unitValue=view.findViewById(R.id.fragment_dahili_sensor_deger);
        interiorFragmentRelative=view.findViewById(R.id.interior_fragment_relative);

        unitDesc.setText(desc);
        unitAlarm.setText(alarm);
        unitValue.setText(value);

        interiorFragmentRelative.setBackground(background);


        return view;
    }


}

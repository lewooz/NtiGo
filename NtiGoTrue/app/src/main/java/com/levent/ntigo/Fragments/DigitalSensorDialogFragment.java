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

public class DigitalSensorDialogFragment extends DialogFragment {

    TextView unitDesc,unitAlarm,unitValue;
    Drawable background;
    String desc,alarm,value;
    RelativeLayout digitalFragmentRelative;

    public DigitalSensorDialogFragment(Drawable background, String desc, String alarm, String value) {
        this.background = background;
        this.desc = desc;
        this.alarm = alarm;
        this.value = value;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_digital_sensor_dialog,null);

        unitDesc=view.findViewById(R.id.fragment_digital_sensor_desc);
        unitAlarm=view.findViewById(R.id.fragment_digital_sensor_alarm_durumu);
        unitValue=view.findViewById(R.id.fragment_digital_sensor_deger);
        digitalFragmentRelative=view.findViewById(R.id.digital_fragment_relative);

        unitDesc.setText(desc);
        unitAlarm.setText(alarm);
        unitValue.setText(value);

        digitalFragmentRelative.setBackground(background);

        return view;
    }
}

package com.levent.ntigo.viewholders;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.levent.ntigo.R;

public class InteriorSensorViewHolder extends RecyclerView.ViewHolder {

    public TextView sensorDesc, sensorAlarm, sensorDeger;
    public RelativeLayout interiorSensorRelativeLayout;

    public InteriorSensorViewHolder(@NonNull View itemView) {
        super(itemView);

        sensorDesc= itemView.findViewById(R.id.sensor_desc);
        sensorAlarm=itemView.findViewById(R.id.sensor_alarm_durumu);
        sensorDeger= itemView.findViewById(R.id.sensor_deger);
        interiorSensorRelativeLayout= itemView.findViewById(R.id.sensor_relative_layout);

    }
}

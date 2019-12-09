package com.levent.ntigo.viewholders;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.levent.ntigo.R;

public class HariciSensorViewHolder extends RecyclerView.ViewHolder {

    public TextView haricisensorDesc, haricisensorAlarm, haricisensorDeger;
    public RelativeLayout hariciSensorRelativeLayout;

    public HariciSensorViewHolder(@NonNull View itemView) {
        super(itemView);

        haricisensorDesc= itemView.findViewById(R.id.harici_sensor_desc);
        haricisensorAlarm=itemView.findViewById(R.id.harici_sensor_alarm_durumu);
        haricisensorDeger= itemView.findViewById(R.id.harici_sensor_deger);
        hariciSensorRelativeLayout= itemView.findViewById(R.id.harici_sensor_relative_layout);
    }
}

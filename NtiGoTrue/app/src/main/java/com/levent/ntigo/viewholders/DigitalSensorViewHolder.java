package com.levent.ntigo.viewholders;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.levent.ntigo.R;

public class DigitalSensorViewHolder extends RecyclerView.ViewHolder {

    public TextView digitalsensorDesc, digitalsensorAlarm, digitalsensorDeger;
    public RelativeLayout digitalSensorRelativeLayout;

    public DigitalSensorViewHolder(@NonNull View itemView) {
        super(itemView);

        digitalsensorDesc= itemView.findViewById(R.id.digital_sensor_desc);
        digitalsensorAlarm=itemView.findViewById(R.id.digital_sensor_alarm_durumu);
        digitalsensorDeger= itemView.findViewById(R.id.digital_sensor_deger);
        digitalSensorRelativeLayout= itemView.findViewById(R.id.digital_sensor_relative_layout);
    }
}

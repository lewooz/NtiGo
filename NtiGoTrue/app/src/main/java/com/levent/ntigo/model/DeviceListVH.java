package com.levent.ntigo.model;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.levent.ntigo.R;

public class DeviceListVH extends RecyclerView.ViewHolder {

    public TextView deviceNametxt, deviceModeltxt, deviceIpNotxt,usernametxt,passwordtxt;
    public ImageView deviceImage;
    public Button connectButton;

    public DeviceListVH(@NonNull View itemView) {
        super(itemView);
        deviceNametxt= itemView.findViewById(R.id.cihaz_name_card);
        deviceModeltxt=itemView.findViewById(R.id.model_card);
        deviceIpNotxt=itemView.findViewById(R.id.ipno_card);
        deviceImage=itemView.findViewById(R.id.device_picture_card);
        usernametxt=itemView.findViewById(R.id.username_card);
        passwordtxt=itemView.findViewById(R.id.password_card);
        connectButton=itemView.findViewById(R.id.connect_button_card);
    }


}

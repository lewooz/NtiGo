package com.levent.ntigo.viewholders;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.levent.ntigo.R;

public class IpDevicesViewHolder extends RecyclerView.ViewHolder {

    public TextView ipDevicesDesc, ipDevicesIp, ipDevicesDeger;
    public RelativeLayout ipDevicesRelativeLayout;

    public IpDevicesViewHolder(@NonNull View itemView) {
        super(itemView);

        ipDevicesDesc= itemView.findViewById(R.id.ipdevices_desc);
        ipDevicesIp=itemView.findViewById(R.id.ipdevices_ip);
        ipDevicesDeger= itemView.findViewById(R.id.ipdevices_deger);
        ipDevicesRelativeLayout= itemView.findViewById(R.id.ipdevices_relative_layout);
    }
}

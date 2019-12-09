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

public class IpDevicesDialogFragment extends DialogFragment {

    TextView unitDesc,unitIp,unitValue;
    Drawable background;
    String desc,ip,value;
    RelativeLayout ipdevicesFragmentRelative;

    public IpDevicesDialogFragment(Drawable background, String desc, String ip, String value) {
        this.background = background;
        this.desc = desc;
        this.ip = ip;
        this.value = value;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_ipdevices_dialog,null);

        unitDesc=view.findViewById(R.id.fragment_ipdevices_desc);
        unitIp=view.findViewById(R.id.fragment_ipdevices_ip);
        unitValue=view.findViewById(R.id.fragment_ipdevices_deger);
        ipdevicesFragmentRelative=view.findViewById(R.id.ipdevices_relative);

        unitDesc.setText(desc);
        unitIp.setText(ip);
        unitValue.setText(value);

        ipdevicesFragmentRelative.setBackground(background);

        return view;
    }
}

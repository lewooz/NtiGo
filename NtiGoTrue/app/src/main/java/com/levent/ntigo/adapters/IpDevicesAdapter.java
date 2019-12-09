package com.levent.ntigo.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.levent.ntigo.Fragments.DigitalSensorDialogFragment;
import com.levent.ntigo.IpDevices.Ipdev;
import com.levent.ntigo.KuruKontakSensors.Diginp;
import com.levent.ntigo.R;
import com.levent.ntigo.viewholders.DigitalSensorViewHolder;
import com.levent.ntigo.viewholders.IpDevicesViewHolder;

import java.util.List;

public class IpDevicesAdapter extends RecyclerView.Adapter<IpDevicesViewHolder> {

    Context context;
    List<Ipdev> list;
    LayoutInflater layoutInflater;
    FragmentManager manager;

    public IpDevicesAdapter(Context context, List<Ipdev> list, LayoutInflater layoutInflater, FragmentManager manager) {
        this.context = context;
        this.list = list;
        this.layoutInflater = layoutInflater;
        this.manager = manager;
    }

    @NonNull
    @Override
    public IpDevicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= layoutInflater.inflate(R.layout.ipdevices_info_row,parent,false);

        IpDevicesViewHolder viewHolder= new IpDevicesViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final IpDevicesViewHolder holder, final int position) {

        Ipdev ipDev = new Ipdev();
        ipDev = list.get(position);


        holder.ipDevicesDesc.setText(ipDev.getDesc());
        holder.ipDevicesIp.setText(ipDev.getIp());

        if(ipDev.getVal().equals("Responding"))
        {
            holder.ipDevicesDeger.setText("RESPONDING");
        }else
        {
            holder.ipDevicesDeger.setText("NOT RESPONDING!");
            holder.ipDevicesRelativeLayout.setBackgroundColor(context.getResources().getColor(R.color.alarm));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Ipdev ipDev1 = new Ipdev();
                ipDev1 = list.get(position);

                Drawable background;
                background = holder.ipDevicesRelativeLayout.getBackground();
                DigitalSensorDialogFragment fragment = new DigitalSensorDialogFragment(background,ipDev1.getDesc(),holder.ipDevicesIp.getText().toString(),ipDev1.getVal());
                fragment.show(manager,"Digital Dialog");

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
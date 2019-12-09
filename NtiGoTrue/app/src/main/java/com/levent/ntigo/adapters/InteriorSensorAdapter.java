package com.levent.ntigo.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.levent.ntigo.Fragments.InteriorSensorDialogFragment;
import com.levent.ntigo.InternalSensors.InteriorSensorInfo;
import com.levent.ntigo.R;
import com.levent.ntigo.viewholders.InteriorSensorViewHolder;

import java.util.List;

public class InteriorSensorAdapter extends RecyclerView.Adapter<InteriorSensorViewHolder> {

    Context context;
    List<InteriorSensorInfo> list;
    LayoutInflater layoutInflater;
    FragmentManager manager;

    public InteriorSensorAdapter(Context context, List<InteriorSensorInfo> list, LayoutInflater layoutInflater, FragmentManager manager) {
        this.context = context;
        this.list = list;
        this.layoutInflater = layoutInflater;
        this.manager = manager;
    }

    @NonNull
    @Override
    public InteriorSensorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= layoutInflater.inflate(R.layout.interior_sensor_info_row,parent,false);

        InteriorSensorViewHolder viewHolder= new InteriorSensorViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final InteriorSensorViewHolder holder, final int position) {

        InteriorSensorInfo interiorSensorInfo = new InteriorSensorInfo();
        interiorSensorInfo = list.get(position);

        holder.sensorDesc.setText(interiorSensorInfo.getDesc());
        holder.sensorDeger.setText(interiorSensorInfo.getVal());

        if(interiorSensorInfo.getStatus().toString().equals("1"))
        {
            holder.sensorAlarm.setText("NO ALARM");
        }else if(interiorSensorInfo.getStatus().toString().equals("2"))
            {
                holder.sensorAlarm.setText("ALARM");
                holder.interiorSensorRelativeLayout.setBackgroundColor(context.getResources().getColor(R.color.warning));
            }else if(interiorSensorInfo.getStatus().toString().equals("3"))
            {
                holder.sensorAlarm.setText("DANGER");
                holder.interiorSensorRelativeLayout.setBackgroundColor(context.getResources().getColor(R.color.alarm));
            }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InteriorSensorInfo posinteriorSensorInfo = new InteriorSensorInfo();
                posinteriorSensorInfo = list.get(position);

                Drawable background;
                background = holder.interiorSensorRelativeLayout.getBackground();
                InteriorSensorDialogFragment fragment = new InteriorSensorDialogFragment(posinteriorSensorInfo.getDesc(),holder.sensorAlarm.getText().toString(),posinteriorSensorInfo.getVal(),background);
                fragment.show(manager,"Interior Dialog");

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

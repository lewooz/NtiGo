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
import com.levent.ntigo.HariciSensors.Esen;
import com.levent.ntigo.InternalSensors.InteriorSensorInfo;
import com.levent.ntigo.R;
import com.levent.ntigo.viewholders.HariciSensorViewHolder;
import com.levent.ntigo.viewholders.InteriorSensorViewHolder;

import java.util.List;

public class HariciSensorAdapter extends RecyclerView.Adapter<HariciSensorViewHolder> {

    Context context;
    List<Esen> list;
    LayoutInflater layoutInflater;
    FragmentManager manager;

    public HariciSensorAdapter(Context context, List<Esen> list, LayoutInflater layoutInflater, FragmentManager manager) {
        this.context = context;
        this.list = list;
        this.layoutInflater = layoutInflater;
        this.manager = manager;
    }

    @NonNull
    @Override
    public HariciSensorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= layoutInflater.inflate(R.layout.harici_sensor_info_row,parent,false);

        HariciSensorViewHolder viewHolder= new HariciSensorViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final HariciSensorViewHolder holder, final int position) {

        Esen esen = new Esen();
        esen = list.get(position);


        holder.haricisensorDesc.setText(esen.getDesc());
        holder.haricisensorDeger.setText(esen.getVal());

        if(esen.getStatus().toString().equals("1"))
        {
            holder.haricisensorAlarm.setText("NO ALARM");
        }else if(esen.getStatus().toString().equals("2"))
        {
            holder.haricisensorAlarm.setText("ALARM!");
            holder.hariciSensorRelativeLayout.setBackgroundColor(context.getResources().getColor(R.color.warning));
        }else if(esen.getStatus().toString().equals("3"))
        {
            holder.haricisensorAlarm.setText("DANGER!");
            holder.hariciSensorRelativeLayout.setBackgroundColor(context.getResources().getColor(R.color.alarm));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Esen esen1 = new Esen();
                esen1 = list.get(position);

                Drawable background;
                background = holder.hariciSensorRelativeLayout.getBackground();
                InteriorSensorDialogFragment fragment = new InteriorSensorDialogFragment(esen1.getDesc(),holder.haricisensorAlarm.getText().toString(),esen1.getVal(),background);
                fragment.show(manager,"Harici Dialog");

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

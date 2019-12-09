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
import com.levent.ntigo.Fragments.InteriorSensorDialogFragment;
import com.levent.ntigo.HariciSensors.Esen;
import com.levent.ntigo.KuruKontakSensors.Diginp;
import com.levent.ntigo.R;
import com.levent.ntigo.viewholders.DigitalSensorViewHolder;
import com.levent.ntigo.viewholders.HariciSensorViewHolder;

import java.util.List;

public class DigitalSensorAdapter extends RecyclerView.Adapter<DigitalSensorViewHolder> {

    Context context;
    List<Diginp> list;
    LayoutInflater layoutInflater;
    FragmentManager manager;

    public DigitalSensorAdapter(Context context, List<Diginp> list, LayoutInflater layoutInflater, FragmentManager manager) {
        this.context = context;
        this.list = list;
        this.layoutInflater = layoutInflater;
        this.manager = manager;
    }

    @NonNull
    @Override
    public DigitalSensorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= layoutInflater.inflate(R.layout.digi_sensor_info_row,parent,false);

        DigitalSensorViewHolder viewHolder= new DigitalSensorViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final DigitalSensorViewHolder holder, final int position) {

        Diginp diginp = new Diginp();
        diginp = list.get(position);


        holder.digitalsensorDesc.setText(diginp.getDesc());
        holder.digitalsensorDeger.setText(diginp.getVal());

        if(diginp.getStatus().toString().equals("1"))
        {
            holder.digitalsensorAlarm.setText("No Alarm");
        }else if(diginp.getStatus().toString().equals("2"))
        {
            holder.digitalsensorAlarm.setText("Alarm!");
            holder.digitalSensorRelativeLayout.setBackgroundColor(context.getResources().getColor(R.color.warning));
        }else if(diginp.getStatus().toString().equals("3"))
        {
            holder.digitalsensorAlarm.setText("DANGER!");
            holder.digitalSensorRelativeLayout.setBackgroundColor(context.getResources().getColor(R.color.alarm));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Diginp diginp1 = new Diginp();
                diginp1 = list.get(position);

                Drawable background;
                background = holder.digitalSensorRelativeLayout.getBackground();
                DigitalSensorDialogFragment fragment = new DigitalSensorDialogFragment(background,diginp1.getDesc(),holder.digitalsensorAlarm.getText().toString(),diginp1.getVal());
                fragment.show(manager,"Digital Dialog");

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

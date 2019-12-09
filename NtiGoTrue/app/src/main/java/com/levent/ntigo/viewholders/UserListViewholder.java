package com.levent.ntigo.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.levent.ntigo.R;

public class UserListViewholder extends RecyclerView.ViewHolder {

    public TextView firmanametxt, userpasswordtxt, usermailtxt, maxUnit, usedUnit;

    public UserListViewholder(@NonNull View itemView) {
        super(itemView);
        firmanametxt = itemView.findViewById(R.id.card_firma_adı);
        usermailtxt=itemView.findViewById(R.id.card_kullanıcı_mail);
        userpasswordtxt=itemView.findViewById(R.id.card_kullanıcı_password);
        maxUnit=itemView.findViewById(R.id.card_kullanıcı_maxdevice);
        usedUnit=itemView.findViewById(R.id.card_kullanıcı_usedDevice);


    }


}

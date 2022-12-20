package edu.upi.cs.yudiwbs.uas_template;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderAccel extends RecyclerView.ViewHolder {
    public TextView tvTime;
    public TextView tvNotif;

    public ViewHolderAccel(@NonNull View itemView) {
        super(itemView);
        tvTime = itemView.findViewById(R.id.tvTime);
        tvNotif = itemView.findViewById(R.id.tvNotif);
    }
}

package edu.upi.cs.yudiwbs.uas_template;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterAccel extends RecyclerView.Adapter<ViewHolderAccel> {

    ArrayList<Accel> alAccel;

    public AdapterAccel(ArrayList<Accel> alAccel) {
        this.alAccel = alAccel;
    }

    @NonNull
    @Override
    public ViewHolderAccel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.accel_row, parent, false);
        // jangan sampai lupa return viewholder, akan menyebabkan bug yang susah ditrace
        return new ViewHolderAccel(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAccel holder, int position) {
        Accel m = alAccel.get(position);
        holder.tvNotif.setText(m.getNotif());
        holder.tvTime.setText(m.getTime());
    }

    @Override
    public int getItemCount() {
        return alAccel.size();
    }
}

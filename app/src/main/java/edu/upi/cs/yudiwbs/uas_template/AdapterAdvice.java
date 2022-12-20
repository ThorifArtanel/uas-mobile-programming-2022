package edu.upi.cs.yudiwbs.uas_template;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterAdvice extends RecyclerView.Adapter<ViewHolderAdvice> {

    ArrayList<Advice> alAdvice;

    public AdapterAdvice(ArrayList<Advice> alAdvice) {
        this.alAdvice = alAdvice;
    }

    @NonNull
    @Override
    public ViewHolderAdvice onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.advice_row, parent, false);
        // jangan sampai lupa return viewholder, akan menyebabkan bug yang susah ditrace
        return new ViewHolderAdvice(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdvice holder, int position) {
        Advice m = alAdvice.get(position);
        holder.tvAdvice.setText(m.getAdvice());
    }

    @Override
    public int getItemCount() {
        return alAdvice.size();
    }
}

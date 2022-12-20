package edu.upi.cs.yudiwbs.uas_template;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderAdvice extends RecyclerView.ViewHolder {
    public TextView tvAdvice;

    public ViewHolderAdvice(@NonNull View itemView) {
        super(itemView);
        tvAdvice = itemView.findViewById(R.id.tvRow);
    }
}

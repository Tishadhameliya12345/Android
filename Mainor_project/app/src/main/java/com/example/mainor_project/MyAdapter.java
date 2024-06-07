package com.example.mainor_project;

import android.content.Context;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList name_id,phno_id,loc_id,item_id,time_id,day_id,qun_id;

    public MyAdapter(Context context, ArrayList name_id, ArrayList phno_id, ArrayList loc_id, ArrayList item_id, ArrayList time_id, ArrayList day_id, ArrayList qun_id) {
        this.context = context;
        this.name_id = name_id;
        this.phno_id = phno_id;
        this.loc_id = loc_id;
        this.item_id = item_id;
        this.time_id = time_id;
        this.day_id = day_id;
        this.qun_id = qun_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.phno_id.setText(String.valueOf(phno_id.get(position)));
        holder.loc_id.setText(String.valueOf(loc_id.get(position)));
        holder.item_id.setText(String.valueOf(item_id.get(position)));
        holder.time_id.setText(String.valueOf(time_id.get(position)));
        holder.day_id.setText(String.valueOf(day_id.get(position)));
        holder.qun_id.setText(String.valueOf(qun_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_id,phno_id,loc_id,item_id,time_id,day_id,qun_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id=itemView.findViewById(R.id.txtname);
            phno_id=itemView.findViewById(R.id.txtphno);
            loc_id=itemView.findViewById(R.id.txtLocation);
            item_id=itemView.findViewById(R.id.txtitem);
            time_id=itemView.findViewById(R.id.txttime);
            day_id=itemView.findViewById(R.id.txtday);
            qun_id=itemView.findViewById(R.id.txtqun);
        }
    }
}

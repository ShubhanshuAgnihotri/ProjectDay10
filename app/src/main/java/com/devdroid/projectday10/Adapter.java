package com.devdroid.projectday10;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    public Adapter(List<Model> list) {
        this.list = list;
    }
    private boolean isEnable = false;
    private List<Integer> itemSelectedList = new ArrayList<>();


    private List<Model> list;
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Model model= list.get(position);
        Log.d("Adapter","model name: "+ model.getName());
        holder.nameTextView.setText(model.getName());
        holder.imageView.setVisibility(View.GONE);
       // holder.designationTextView.setText(model.getDesignation());
        //holder.phoneTextView.setText(model.getPhone());
      //  holder.idTextView.setText(model.getId());
        holder.nameTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                selectItem(holder, model, position);
                return true;
            }
        });

        holder.nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemSelectedList.contains(position)) {
                    holder.imageView.setVisibility(View.GONE);
                    model.setSelected(false);
                    if (itemSelectedList.isEmpty()) {
                        isEnable = false;
                    }

                } else if (isEnable) {
                    selectItem(holder, model, position);
                }
            }
        });
    }

    private void selectItem(ViewHolder holder, Model item, int position) {
        isEnable = true;
        itemSelectedList.add(position);
        String name = item.getName();
        item.setSelected(true);

        holder.imageView.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        Log.d("Adapter","List Size:" +list.size());

        return list.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        ImageView imageView;
      //public TextView designationTextView;
        //public TextView phoneTextView;
        //public TextView idTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.display_name);
            imageView = itemView.findViewById(R.id.ImageView);
            //designationTextView = itemView.findViewById(R.id.designation_display);
            //phoneTextView = itemView.findViewById(R.id.display_phone);
            //idTextView = itemView.findViewById(R.id.id_display);

        }
    }
}
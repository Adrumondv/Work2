package com.example.alexanderdrumond.work2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.alexanderdrumond.work2.R;
import com.example.alexanderdrumond.work2.data.Queries;
import com.example.alexanderdrumond.work2.models.Pending;

import java.util.List;

/**
 * Created by Alexander Drumond on 02-06-2017.
 */

public class PendingsAdapter extends RecyclerView.Adapter<PendingsAdapter.ViewHolder>{

    private List<Pending> pendings = new Queries().pendings();
    private PendingsClick listener;

    public PendingsAdapter(PendingsClick listener){
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pending, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Pending pending = pendings.get(position);
        CheckBox checkBox = holder.checkBox;
        checkBox.setChecked(pending.isDone());

        TextView textView = holder.textView;
        textView.setText(pending.getName());

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    int auxPosition = holder.getAdapterPosition();
                    Pending auxPending =  pendings.get(auxPosition);
                    auxPending.setDone(true);
                    auxPending.save();
                    pendings.remove(auxPosition);
                    notifyItemRemoved(auxPosition);
                }

            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pending auxpPending =  pendings.get(holder.getAdapterPosition());
                listener.clicked(auxpPending.getId());
            }
        });

    }

    public void addPending(Pending pending){
        pendings.add(0,pending);
        notifyItemInserted(0);
    }


    @Override
    public int getItemCount(){
        return pendings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBox;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.pendingCb);
            textView = (TextView) itemView.findViewById(R.id.pendingTv);
        }
    }
}

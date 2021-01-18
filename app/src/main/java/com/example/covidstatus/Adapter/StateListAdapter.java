package com.example.covidstatus.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidstatus.Model.StateData;
import com.example.covidstatus.R;

import java.util.List;

public class StateListAdapter extends RecyclerView.Adapter<StateListAdapter.ViewHolder> {

    private Context context;
    private List<StateData> stateData;

    public StateListAdapter(Context context, List<StateData> stateData){
        this.context = context;
        this.stateData = stateData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false);
        return new ViewHolder(view,context) ;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.stateName.setText(stateData.get(position).getRegion());
    }

    @Override
    public int getItemCount() {
        return stateData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView stateName;
        public ViewHolder(@NonNull View itemView,Context ctx) {
            super(itemView);
            context = ctx;

            stateName = itemView.findViewById(R.id.country_name);

        }
    }
}

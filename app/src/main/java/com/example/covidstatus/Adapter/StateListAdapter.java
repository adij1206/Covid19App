package com.example.covidstatus.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidstatus.Model.CountryData;
import com.example.covidstatus.Model.StateData;
import com.example.covidstatus.R;
import com.example.covidstatus.UI.CountryDetail;
import com.example.covidstatus.UI.StateDetail;

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
            holder.stateName.setText(stateData.get(position).getName());
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    StateData state = stateData.get(position);
                    Intent intent = new Intent(context, StateDetail.class);
                    intent.putExtra("name",state.getName());
                    intent.putExtra("cases",state.getTotal());
                    intent.putExtra("activecases",state.getActive());
                    intent.putExtra("death",state.getDeath());
                    intent.putExtra("recovered",state.getCured());
                    context.startActivity(intent);
                }
            });

        }
    }
}

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
import com.example.covidstatus.R;
import com.example.covidstatus.UI.CountryDetail;

import java.util.List;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder> {

    private Context context;
    private List<CountryData> countryList;

    public CountryListAdapter(Context context, List<CountryData> countryList){
        this.context = context;
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public CountryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false);
        return new ViewHolder(view,context) ;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryListAdapter.ViewHolder holder, int position) {
        holder.nameOfCountry.setText(countryList.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nameOfCountry;
        public ViewHolder(@NonNull View itemView,Context ctx) {
            super(itemView);
            context = ctx;

            nameOfCountry = (TextView) itemView.findViewById(R.id.country_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    CountryData countryData = countryList.get(position);
                    Intent intent = new Intent(context, CountryDetail.class);
                    intent.putExtra("name",countryData.getCountry());
                    intent.putExtra("cases",countryData.getCases());
                    intent.putExtra("todaycases",countryData.getTodayCases());
                    intent.putExtra("death",countryData.getDeaths());
                    intent.putExtra("todayDeath",countryData.getTodayDeaths());
                    intent.putExtra("recovered",countryData.getRecovered());
                    intent.putExtra("todayRecovered",countryData.getTodayRecovered());
                    intent.putExtra("active",countryData.getActive());
                    context.startActivity(intent);
                }
            });
        }


    }

}

package com.example.khoahoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.khoahoc.model.Country;

import java.util.List;

public class CountryAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Country> CountryList;

    public CountryAdapter(Context context, int layout, List<Country> countryList) {
        this.context = context;
        this.layout = layout;
        CountryList = countryList;
    }

    @Override
    public int getCount() {
        return CountryList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       convertView = layoutInflater.inflate(layout,null);
       //anh xa
        TextView tvTenNuoc = (TextView)convertView. findViewById(R.id.tvTenNuoc);
        TextView tvThuDo = (TextView) convertView.findViewById(R.id.tvThuDo);
        ImageView imgCo = (ImageView) convertView.findViewById(R.id.img_country);
        //Gan gia tri
        tvTenNuoc.setText(CountryList.get(position).TenNuoc);
        tvThuDo.setText(CountryList.get(position).ThuDo);
        imgCo.setImageResource(CountryList.get(position).HinhAnh);
        return convertView;
    }
}

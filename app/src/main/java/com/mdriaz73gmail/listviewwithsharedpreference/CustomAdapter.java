package com.mdriaz73gmail.listviewwithsharedpreference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by MARS on 6/11/2016.
 */
public class CustomAdapter extends BaseAdapter {

    Context context;
    String[] name;

    public CustomAdapter(Context c,String[] n){

        context=c;
        name=n;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        if (convertView==null){
            convertView=inflater.inflate(R.layout.listview_layout,null);
        }
        TextView tvlistview= (TextView) convertView.findViewById(R.id.tvListview);
        tvlistview.setText(name[position]);

        return convertView;
    }
}

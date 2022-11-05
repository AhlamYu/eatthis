package com.ahlam.eatthis.supriseme;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SupriseMeAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<SupriseMeal> listSuprise;

    public SupriseMeAdapter (Activity context, ArrayList<SupriseMeal> listSuprise){
        this.context = context;
        this.listSuprise = listSuprise;

    }

    static class ViewHolder{
        ImageView ivRandom_img;
        TextView tvRandom_name;
        TextView tvRandom_category;
    }


    @Override
    public int getCount() {
        return 0;
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

        ViewHolder holder;

        return convertView;
    }
}

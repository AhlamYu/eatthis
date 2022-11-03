package com.ahlam.eatthis;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahlam.eatthis.domain.MealByCategory;

import java.util.ArrayList;

public class MealAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<MealByCategory> listMeal;
    private LayoutInflater inflater;
    private String categoryName ;

    public MealAdapter(Activity context , ArrayList<MealByCategory> listMeal, String categoryName){
        this.context = context;
        this.listMeal = listMeal;
        this.categoryName = categoryName;
        inflater = LayoutInflater.from(context);
    }

    static class ViewHolder {
        ImageView ivMealPhoto;
        TextView tvMealName;
        TextView tvMealCategory;

    }

    @Override
    public int getCount() {
        return listMeal.size();
    }

    @Override
    public Object getItem(int position) {
        return listMeal.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null){
            convertView = inflater.inflate(R.layout.layout_for_each_meal,null);
            holder = new ViewHolder();
            holder.ivMealPhoto = convertView.findViewById(R.id.ivMealPhoto);
            holder.tvMealName = convertView.findViewById(R.id.tvMealName);
            holder.tvMealCategory = convertView.findViewById(R.id.tvMealCategory);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        MealByCategory meal = listMeal.get(position);
        //TODO add images here
//        holder.ivMealPhoto.setImageBitmap(meal.getStrMealThumb());
        holder.tvMealName.setText(meal.getStrMeal());
//        holder.tvMealCategory.setText(meal.get);

        return convertView;
    }
}

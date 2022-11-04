package com.ahlam.eatthis.meal_recipty;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahlam.eatthis.domain.ReceiptMeal;

import java.util.ArrayList;

public class MealDetailAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ReceiptMeal> receiptLists;
    private LayoutInflater inflater;
    private String receiptID ;

    public MealDetailAdapter(Activity context,ArrayList<ReceiptMeal> receiptLists, String receiptID){
        this.context = context;
        this.receiptLists = receiptLists;
        this.receiptID = receiptID;
        inflater = LayoutInflater.from(context);
    }

    static class ViewHolder {
        ImageView ivMealPhoto;
        TextView tvMealName;
        TextView tvMealCategory;


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
        return null;
    }
}

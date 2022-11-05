//package com.ahlam.eatthis.room_fav;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Adapter;
//import android.widget.BaseAdapter;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.ahlam.eatthis.R;
//import com.ahlam.eatthis.domain.ReceiptMeal;
//
//import java.util.List;
//
//public class FavouriteAdapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
//    Context context;
//    List<ReceiptMeal> receiptMeals;
//
//
//    public FavouriteAdapter(Context context, List<ReceiptMeal> articles) {
//        this.context = context;
//        this.receiptMeals = articles;
//    }
//
//
//    @NonNull
//    @Override
//    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_favourite,parent,false);
//
//        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
//
//        final ReceiptMeal recM = receiptMeals.get(position);
//        String recipyID = getItemId()
//
//
//
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
////
////    @Override
////    public View getView(int position, View convertView, ViewGroup parent) {
////        return null;
////    }
//}

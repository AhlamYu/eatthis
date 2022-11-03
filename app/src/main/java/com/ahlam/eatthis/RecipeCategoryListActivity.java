package com.ahlam.eatthis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ahlam.eatthis.api.TheMealDbApi;
import com.ahlam.eatthis.api.TheMealDbApiInterface;
import com.ahlam.eatthis.domain.MealByCategory;
import com.ahlam.eatthis.domain.MealByCategoryApiList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeCategoryListActivity extends AppCompatActivity {

    MealAdapter mealAdapter;
    ArrayList<MealByCategory> mealList;
    String mealcategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_category_list);

        Intent intent = getIntent();
        mealcategory = intent.getStringExtra("categoryName");

        mealList = new ArrayList<>();
        mealAdapter = new MealAdapter(this, mealList, mealcategory);
        ListView listView = findViewById(R.id.recipe_list_category);
        listView.setAdapter(mealAdapter);

        loadRecipes();
    }



    private void loadRecipes(){
        TheMealDbApiInterface api = TheMealDbApi.buildInstance();
        Call<MealByCategoryApiList> callProducts = api.getMealsbyCategory(mealcategory);
        callProducts.enqueue(new Callback<MealByCategoryApiList>() {
            @Override
            public void onResponse(Call<MealByCategoryApiList> call, Response<MealByCategoryApiList> response) {
                MealByCategoryApiList mealApiList = response.body();
                mealList.addAll(mealApiList.getMeals());
                mealAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MealByCategoryApiList> call, Throwable throwable) {
                Toast.makeText(getApplicationContext(), "An error has occurred", Toast.LENGTH_LONG).show();
                mealList.clear();
                mealAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
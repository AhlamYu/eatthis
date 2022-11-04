package com.ahlam.eatthis.list_meals_based_on_category;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ahlam.eatthis.R;
import com.ahlam.eatthis.api.TheMealDbApi;
import com.ahlam.eatthis.api.TheMealDbApiInterface;
import com.ahlam.eatthis.domain.Category;
import com.ahlam.eatthis.domain.MealByCategory;
import com.ahlam.eatthis.domain.MealByCategoryApiList;
import com.ahlam.eatthis.domain.ReceiptMeal;
import com.ahlam.eatthis.meal_recipty.MealDetailActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeCategoryListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    MealAdapter mealAdapter;
    ArrayList<MealByCategory> mealList;
    String mealcategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_category_list);

        /// Recieve the data
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String selectReciptID = mealList.get(position).getIdMeal();
        Intent intent = new Intent(this, MealDetailActivity.class);
        intent.putExtra("recipeID", selectReciptID);
        startActivity(intent);

    }
}
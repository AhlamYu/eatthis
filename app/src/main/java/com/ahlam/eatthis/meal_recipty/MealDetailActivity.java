package com.ahlam.eatthis.meal_recipty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

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
import com.ahlam.eatthis.domain.CategoryApiList;
import com.ahlam.eatthis.domain.MealByCategory;
import com.ahlam.eatthis.domain.MealByCategoryApiList;
import com.ahlam.eatthis.domain.ReceiptAPiList;
import com.ahlam.eatthis.domain.ReceiptMeal;
import com.ahlam.eatthis.list_meals_based_on_category.MealAdapter;
import com.ahlam.eatthis.list_meals_based_on_category.RecipeCategoryListActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealDetailActivity extends AppCompatActivity {

    String recipymeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_detail);

        /// Recieve the data
        Intent intent = getIntent();
        recipymeal = intent.getStringExtra("recipeID");


        loadRecipe();
    }

    private void loadRecipe() {

        TheMealDbApiInterface api = TheMealDbApi.buildInstance();
        Call<ReceiptAPiList> callRecipe = api.getRecipe(recipymeal);
        callRecipe.enqueue(new Callback<ReceiptAPiList>() {
            @Override
            public void onResponse(Call<ReceiptAPiList> call, Response<ReceiptAPiList> response) {
                ReceiptAPiList receiptAPiList = response.body();
            }

            @Override
            public void onFailure(Call<ReceiptAPiList> call, Throwable t) {

            }
        });



    }

}
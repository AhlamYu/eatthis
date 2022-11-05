package com.ahlam.eatthis.meal_recipty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahlam.eatthis.R;
import com.ahlam.eatthis.api.TheMealDbApi;
import com.ahlam.eatthis.api.TheMealDbApiInterface;
import com.ahlam.eatthis.domain.ReceiptAPiList;
import com.ahlam.eatthis.domain.ReceiptMeal;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealDetailActivity extends AppCompatActivity {

    String recipymeal;
    Call<ReceiptAPiList> MealDetails;

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
                ReceiptMeal receiptMeals = receiptAPiList.getMeals().get(0);

                ImageView ivDetailPhoto = findViewById(R.id.ivDetailPhoto);
                TextView tvTitle_name = findViewById(R.id.tvDetailMealName);
                TextView ivMealCate_name = findViewById(R.id.ivMealCate_name);
                TextView ivMealArea_name = findViewById(R.id.ivMealArea_name);
                TextView ivMealIng1_name = findViewById(R.id.ivMealIng1_name);
                TextView ivMealIng2_name = findViewById(R.id.ivMealIng2_name);
                TextView ivMealIng3_name = findViewById(R.id.ivMealIng3_name);
                TextView ivMealIng4_name = findViewById(R.id.ivMealIng4_name);
                TextView ivMealIng5_name = findViewById(R.id.ivMealIng5_name);
                TextView tvReceiptInstructionsDetail = findViewById(R.id.tvReceiptInstructionsDetail);

                tvTitle_name.setText(receiptMeals.getStrMeal());
                ivMealCate_name.setText(receiptMeals.getStrCategory());
                ivMealArea_name.setText(receiptMeals.getStrArea());
                ivMealIng1_name.setText(receiptMeals.getStrIngredient1());
                ivMealIng2_name.setText(receiptMeals.getStrIngredient2());
                ivMealIng3_name.setText(receiptMeals.getStrIngredient3());
                ivMealIng4_name.setText(receiptMeals.getStrIngredient4());
                ivMealIng5_name.setText(receiptMeals.getStrIngredient5());
                tvReceiptInstructionsDetail.setText(receiptMeals.getStrInstructions());

//                Picasso.with(context()).load(ivDetailPhoto)


            }

            @Override
            public void onFailure(Call<ReceiptAPiList> call, Throwable t) {

            }
        });



    }

}
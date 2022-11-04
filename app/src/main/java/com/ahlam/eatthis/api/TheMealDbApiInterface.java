package com.ahlam.eatthis.api;

import com.ahlam.eatthis.domain.CategoryApiList;
import com.ahlam.eatthis.domain.MealByCategoryApiList;
import com.ahlam.eatthis.domain.RandomApiList;
import com.ahlam.eatthis.domain.ReceiptAPiList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface TheMealDbApiInterface {

    @GET("search.php")
    Call<MealByCategoryApiList> getMealsByName(@Query("s") String name);

    @GET("filter.php")
    Call<MealByCategoryApiList> getMealsbyCategory(@Query("c") String categoryByMeal);

    @GET("categories.php")
    Call<CategoryApiList> getAllCategories();

    @GET("random.php")
    Call<RandomApiList> getRandomMeal();

    @GET("lookup.php")
    Call<ReceiptAPiList> getRecipe(@Query("i") String mealID);
}

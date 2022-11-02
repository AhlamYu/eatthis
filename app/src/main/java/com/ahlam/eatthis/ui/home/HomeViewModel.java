package com.ahlam.eatthis.ui.home;

import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ahlam.eatthis.api.TheMealDbApi;
import com.ahlam.eatthis.api.TheMealDbApiInterface;
import com.ahlam.eatthis.domain.Category;
import com.ahlam.eatthis.domain.CategoryApiList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Category>> categories;
    private List<Category> categoryList;

    public HomeViewModel() {
        categoryList = new ArrayList<>();

    }



    public LiveData<List<Category>> getCategories() {
        if (categories == null) {
            categories = new MutableLiveData<>();
            loadCategories();
        }

        return categories;
    }

    private void loadCategories () {
        TheMealDbApiInterface api = TheMealDbApi.buildInstance();
        Call<CategoryApiList> callProducts = api.getAllCategories();
        callProducts.enqueue(new Callback<CategoryApiList>() {
            @Override
            public void onResponse(Call<CategoryApiList> call, Response<CategoryApiList> response) {
                CategoryApiList categoryApiList = response.body();
                categoryList.addAll(categoryApiList.getCategories());
                categories.setValue(categoryList);
            }

            @Override
            public void onFailure(Call<CategoryApiList> call, Throwable throwable) {
//                Toast.makeText(, "An error has occurred", Toast.LENGTH_LONG).show();
//                categoryList.clear();
//                categoryAdapter.notifyDataSetChanged();
//                Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_LONG).show();
            }


        });
    }
}
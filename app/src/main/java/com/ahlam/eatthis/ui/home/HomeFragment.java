package com.ahlam.eatthis.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ahlam.eatthis.R;
import com.ahlam.eatthis.api.TheMealDbApi;
import com.ahlam.eatthis.api.TheMealDbApiInterface;
import com.ahlam.eatthis.databinding.FragmentHomeBinding;
import com.ahlam.eatthis.domain.Category;
import com.ahlam.eatthis.domain.CategoryApiList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    ArrayAdapter<Category> categoryAdapter;
    List<Category> categoryList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        categoryList = new ArrayList<>();
        categoryAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, categoryList);
        ListView listView = root.findViewById(R.id.categoryList);
        listView.setAdapter(categoryAdapter);



        loadCategories();

        return root;
    }

    private void loadCategories () {
        TheMealDbApiInterface api = TheMealDbApi.buildInstance();
        Call<CategoryApiList> callProducts = api.getAllCategories();
        callProducts.enqueue(new Callback<CategoryApiList>() {
            @Override
            public void onResponse(Call<CategoryApiList> call, Response<CategoryApiList> response) {
                CategoryApiList categoryApiList = response.body();
                categoryList.addAll(categoryApiList.getCategories());
                categoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<CategoryApiList> call, Throwable throwable) {
                Toast.makeText(getActivity(), "An error has occurred", Toast.LENGTH_LONG).show();
                categoryList.clear();
                categoryAdapter.notifyDataSetChanged();
                Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_LONG).show();
            }


        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
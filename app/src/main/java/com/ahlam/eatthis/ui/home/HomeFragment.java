package com.ahlam.eatthis.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ahlam.eatthis.MainActivity;
import com.ahlam.eatthis.R;
import com.ahlam.eatthis.RecipeCategoryListActivity;
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


public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener {

    private FragmentHomeBinding binding;
    ArrayAdapter<Category> categoryAdapter;
    List<Category> categoryList;
    private HomeViewModel homeViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
         homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ListView listView = binding.categoryList;
        homeViewModel.getCategories().observe(getViewLifecycleOwner(), categories -> {
            categoryAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, categories);
            listView.setAdapter(categoryAdapter);
            categoryAdapter.notifyDataSetChanged();
        });

        listView.setOnItemClickListener(this);


        return root;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Category selectCategoryName = homeViewModel.getCategories().getValue().get(position);
        Intent intent = new Intent(getActivity(), RecipeCategoryListActivity.class);
        intent.putExtra("categoryName", selectCategoryName.getStrCategory());
        startActivity(intent);

    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
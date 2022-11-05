package com.ahlam.eatthis.ui.surprise;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ahlam.eatthis.databinding.FragmentSurpriseBinding;
import com.ahlam.eatthis.supriseme.SupriseMeAdapter;
import com.ahlam.eatthis.supriseme.SupriseMeal;

import java.util.List;

public class SurpriseFragment extends Fragment {

    private FragmentSurpriseBinding binding;
    ArrayAdapter<SupriseMeAdapter> supriseMeAdapterArrayAdapter;
    List<SupriseMeal> supriseMeals;
    private SurpriseViewModel surpriseViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SurpriseViewModel surpriseViewModel =
                new ViewModelProvider(this).get(SurpriseViewModel.class);

        binding = FragmentSurpriseBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void getMore(View view) {

    }
}
package com.ahlam.eatthis.ui.surprise;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ahlam.eatthis.databinding.FragmentSurpriseBinding;

public class SurpriseFragment extends Fragment {

    private FragmentSurpriseBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SurpriseViewModel surpriseViewModel =
                new ViewModelProvider(this).get(SurpriseViewModel.class);

        binding = FragmentSurpriseBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textDashboard;
//        surpriseViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
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
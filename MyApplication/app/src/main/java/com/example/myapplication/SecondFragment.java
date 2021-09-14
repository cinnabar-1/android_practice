package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.conf.Configuration;
import com.example.myapplication.databinding.FragmentSecondBinding;
import com.example.myapplication.service.HttpThread;
import com.example.myapplication.utils.HttpUtils;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private final static String ARG_PARAM = "param_key";
    private String mParam = null;
    private String response = null;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        if (getArguments() != null)
            mParam = getArguments().getString(ARG_PARAM);
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(view1 -> {
//            NavHostFragment.findNavController(this)
//                    .navigate(R.id.action_SecondFragment_to_FirstFragment, new Bundle());
            binding.textviewSecond.setText("123");
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
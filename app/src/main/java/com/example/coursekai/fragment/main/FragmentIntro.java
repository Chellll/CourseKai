package com.example.coursekai.fragment.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.coursekai.R;
import com.example.coursekai.activity.MainActivity;
import com.example.coursekai.databinding.FragmentIntroBinding;

public class FragmentIntro extends Fragment {


    public static FragmentIntro newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentIntro fragment = new FragmentIntro();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentIntroBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_intro, container,false);
        binding.setFragment(this);

        return binding.getRoot();
    }

    public void clickRegister(){

        ((MainActivity)getActivity()).getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, FragmentRegister.newInstance())
                .commit();

        Toast.makeText(getContext(), "sdf", Toast.LENGTH_SHORT).show();
    }

    public void clickLogin(){

        ((MainActivity)getActivity()).getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, FragmentLogin.newInstance())
                .commit();

        Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
    }
}

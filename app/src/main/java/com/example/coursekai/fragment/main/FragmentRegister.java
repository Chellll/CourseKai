package com.example.coursekai.fragment.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.coursekai.R;
import com.example.coursekai.activity.DataActivity;
import com.example.coursekai.data.db.entity.UserEntity;
import com.example.coursekai.databinding.FragmentRegisterBinding;
import com.example.coursekai.viewModel.User.UserListViewModel;

public class FragmentRegister extends Fragment {

    private FragmentRegisterBinding binding;
    private UserEntity user;
    UserListViewModel userListViewModel;

    public static FragmentRegister newInstance() {

        Bundle args = new Bundle();

        FragmentRegister fragment = new FragmentRegister();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userListViewModel = new ViewModelProvider(this).get(UserListViewModel.class);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        binding.setFragment(this);
        user = new UserEntity();
        binding.setUser(user);



        return binding.getRoot();
    }

    public void click(){
        long q = userListViewModel.insertUser(user);

        getActivity().getSharedPreferences("STORAGE",0).edit().putLong("id", q).apply();
        Intent intent = new Intent(getActivity(), DataActivity.class);
        startActivity(intent);

    }
}

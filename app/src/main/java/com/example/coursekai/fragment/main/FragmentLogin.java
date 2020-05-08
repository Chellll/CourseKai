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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.coursekai.R;
import com.example.coursekai.activity.DataActivity;
import com.example.coursekai.data.db.entity.UserEntity;
import com.example.coursekai.databinding.FragmentLoginBinding;
import com.example.coursekai.viewModel.User.UserListViewModel;

import java.util.List;

public class FragmentLogin extends Fragment {

    UserListViewModel userListViewModel;
    FragmentLoginBinding binding;

    public static FragmentLogin newInstance() {

        Bundle args = new Bundle();

        FragmentLogin fragment = new FragmentLogin();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        binding.setFragment(this);

        userListViewModel = new ViewModelProvider(this).get(UserListViewModel.class);

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.emailId.getText().toString();
                String password = binding.passwordEditText.getText().toString();

                userListViewModel.getmUsers().observe(getViewLifecycleOwner(), new Observer<List<UserEntity>>() {
                    @Override
                    public void onChanged(List<UserEntity> userEntities) {
                        for(UserEntity userEntity: userEntities){
//                            Toast.makeText(getContext(), userEntity.getEmail(), Toast.LENGTH_SHORT).show();
//                            Toast.makeText(getContext(), userEntity.getPassword(), Toast.LENGTH_SHORT).show();
                            if(email.equals(userEntity.getEmail()) && password.equals(userEntity.getPassword())){
                                getActivity().getSharedPreferences("STORAGE",0).edit().putBoolean("hasVisited", true).apply();
                                getActivity().getSharedPreferences("STORAGE",0).edit().putLong("id", userEntity.getId()).apply();
                                Intent intent = new Intent(getActivity(), DataActivity.class);
                                startActivity(intent);
                            }
                        }
                    }
                });
            }
        });



        return binding.getRoot();
    }

    public void cancelClick(){

    }


}

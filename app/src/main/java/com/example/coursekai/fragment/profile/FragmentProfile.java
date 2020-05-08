package com.example.coursekai.fragment.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.coursekai.R;
import com.example.coursekai.activity.DataActivity;
import com.example.coursekai.activity.MainActivity;
import com.example.coursekai.data.db.entity.UserEntity;
import com.example.coursekai.databinding.FragmentProfileBinding;
import com.example.coursekai.viewModel.User.UserListViewModel;
import com.example.coursekai.viewModel.User.UserViewModel;

import java.util.List;

public class FragmentProfile extends Fragment {

    private UserViewModel userViewModel;

    private FragmentProfileBinding binding;
    private long param = 5;

    public static FragmentProfile newInstance() {

        Bundle args = new Bundle();

        FragmentProfile fragment = new FragmentProfile();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }
    UserListViewModel userListViewModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

        userListViewModel = new ViewModelProvider(this).get(UserListViewModel.class);

        UserViewModel.UserFactory factory = new UserViewModel.UserFactory(getActivity().getApplication(), param);
        userViewModel = new ViewModelProvider(getViewModelStore(), factory).get(UserViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);

        ((DataActivity)getActivity()).setSupportActionBar((Toolbar) binding.tbProfile);
        List<UserEntity> userEntities = userListViewModel.getmUsers().getValue();
        userViewModel.getmObservableUser().observe(getViewLifecycleOwner(), new Observer<UserEntity>() {
            @Override
            public void onChanged(UserEntity userEntity) {
                binding.setUser(userEntity);
            }
        });



        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_toolbar_profile, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}

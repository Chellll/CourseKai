package com.example.coursekai.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.coursekai.R;
import com.example.coursekai.data.db.entity.UserEntity;
import com.example.coursekai.databinding.ActivityDataBinding;
import com.example.coursekai.fragment.FragmentNavigation;
import com.example.coursekai.viewModel.User.UserListViewModel;

import java.util.List;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data);

        //getSupportActionBar().hide();

        UserListViewModel userListViewModel = new ViewModelProvider(this).get(UserListViewModel.class);

        long t = getSharedPreferences("STORAGE",0).getLong("id", 0);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_data, FragmentNavigation.newInstance())
                .commit();

    }
}
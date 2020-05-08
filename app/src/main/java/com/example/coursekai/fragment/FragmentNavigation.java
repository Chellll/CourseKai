package com.example.coursekai.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.coursekai.R;
import com.example.coursekai.fragment.course.FragmentCourses;
import com.example.coursekai.fragment.main.FragmentIntro;
import com.example.coursekai.fragment.main.FragmentLogin;
import com.example.coursekai.fragment.main.FragmentRegister;
import com.example.coursekai.fragment.profile.FragmentProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentNavigation extends Fragment {

    public static FragmentNavigation newInstance() {

        Bundle args = new Bundle();

        FragmentNavigation fragment = new FragmentNavigation();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_nav, FragmentProfile.newInstance())
                .commit();

        BottomNavigationView bottomNavigationView = view.findViewById(R.id.nav_bar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch(item.getItemId()){
                    case R.id.bottom_fav:
                        fragment = FragmentProfile.newInstance();
                        break;
                    case R.id.bottom_fav1:
                        fragment = FragmentCourses.newInstance();
                        break;
                    case R.id.bottom_fav2:
                        fragment = FragmentIntro.newInstance();
                        break;
                }
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_nav, fragment)
                        .commit();
                return true;
            }
        });

        return view;
    }
}

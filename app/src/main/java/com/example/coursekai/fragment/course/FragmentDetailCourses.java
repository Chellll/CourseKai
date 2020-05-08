package com.example.coursekai.fragment.course;

import android.os.Bundle;
import android.view.LayoutInflater;
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
import com.example.coursekai.data.db.entity.CourseEntity;
import com.example.coursekai.databinding.FragmentCourseBinding;
import com.example.coursekai.viewModel.course.CourseListViewModel;
import com.example.coursekai.viewModel.course.CourseViewModel;

import java.util.Objects;

public class FragmentDetailCourses extends Fragment {

    CourseListViewModel courseListViewModel;
    CourseViewModel courseViewModel;

    FragmentCourseBinding binding;

    public static FragmentDetailCourses newInstance() {

        Bundle args = new Bundle();

        FragmentDetailCourses fragment = new FragmentDetailCourses();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

        courseListViewModel = new ViewModelProvider(this).get(CourseListViewModel.class);

        long param = getActivity().getSharedPreferences("STORAGE",0).getLong("idCourse",0);

        CourseViewModel.CourseFactory factory = new CourseViewModel.CourseFactory(getActivity().getApplication(), param);
        courseViewModel = new ViewModelProvider(getViewModelStore(), factory).get(CourseViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_course, container, false);
        Toolbar toolbar = (Toolbar)binding.toolbar;

        courseViewModel.getCourse().observe(getViewLifecycleOwner(), new Observer<CourseEntity>() {
            @Override
            public void onChanged(CourseEntity courseEntity) {
                toolbar.setTitle(courseEntity.getName());
            }
        });

        ((DataActivity)getActivity()).setSupportActionBar(toolbar);

        return binding.getRoot();
    }
}

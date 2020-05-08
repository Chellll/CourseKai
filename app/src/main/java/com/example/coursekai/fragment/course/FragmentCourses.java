package com.example.coursekai.fragment.course;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.coursekai.R;
import com.example.coursekai.adapter.CoursesAdapter;
import com.example.coursekai.data.db.entity.AuthorEntity;
import com.example.coursekai.data.db.entity.CourseEntity;
import com.example.coursekai.databinding.FragmentCoursesBinding;
import com.example.coursekai.fragment.CardClickCallback;
import com.example.coursekai.viewModel.author.AuthorListViewModel;
import com.example.coursekai.viewModel.course.CourseListViewModel;

import java.util.List;

public class FragmentCourses extends Fragment {

    private FragmentCoursesBinding binding;
    private CoursesAdapter adapter;
    private CourseListViewModel courseListViewModel;
    private AuthorListViewModel authorListViewModel;

    public static FragmentCourses newInstance() {

        Bundle args = new Bundle();

        FragmentCourses fragment = new FragmentCourses();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        authorListViewModel = new ViewModelProvider(this).get(AuthorListViewModel.class);
        courseListViewModel = new ViewModelProvider(this).get(CourseListViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_courses, container, false);

        adapter = new CoursesAdapter(mCardCallback,authorListViewModel);
        binding.rvCourses.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvCourses.setAdapter(adapter);

        courseListViewModel.getAllCourse().observe(getViewLifecycleOwner(), new Observer<List<CourseEntity>>() {
            @Override
            public void onChanged(List<CourseEntity> courseEntities) {
                if(courseEntities != null){
                    authorListViewModel.getAllAuthors().observe(getViewLifecycleOwner(), new Observer<List<AuthorEntity>>() {
                        @Override
                        public void onChanged(List<AuthorEntity> authorEntities) {
                            if(authorEntities != null)
                            adapter.setmCourses(courseEntities, authorEntities);
                        }
                    });
                } else {

                }
                binding.executePendingBindings();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        binding = null;
        adapter = null;
        super.onDestroyView();
    }

    private final CardClickCallback mCardCallback = course ->{
        getActivity().getSharedPreferences("STORAGE", 0).edit().putLong("idCourse", course.getId()).apply();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_data, FragmentDetailCourses.newInstance())
                .commit();
    };
}

package com.example.coursekai.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursekai.R;
import com.example.coursekai.data.model.Author;
import com.example.coursekai.data.model.Course;
import com.example.coursekai.databinding.CardCourseBinding;
import com.example.coursekai.fragment.CardClickCallback;
import com.example.coursekai.viewModel.author.AuthorListViewModel;

import java.util.List;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.CourseViewHolder> {

    List<? extends Course> mCourses;
    List<? extends Author> mAuthor;

    private final CardClickCallback cardClickCallback;

    AuthorListViewModel authorListViewModel;

    public CoursesAdapter(@Nullable CardClickCallback cardClickCallback, AuthorListViewModel authorListViewModel){
        setHasStableIds(true);
        this.cardClickCallback  =cardClickCallback;
        this.authorListViewModel = authorListViewModel;
    }

    public void setmCourses(final List<? extends Course> courses, final List<? extends Author> authors){
        this.mAuthor = authors;
        if(mCourses == null){
            mCourses = courses;
            notifyItemChanged(0, courses.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mCourses == null ? 0 : mCourses.size();
                }

                @Override
                public int getNewListSize() {
                    return courses.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return mCourses.get(oldItemPosition).getId() == courses.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

                    Course newCourse = courses.get(newItemPosition);
                    Course oldCourse = mCourses.get(oldItemPosition);

                    return newCourse.getName() == oldCourse.getName();
                }
            });

            mCourses = courses;
            result.dispatchUpdatesTo(this);
        }
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardCourseBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.card_course, parent, false
        );

        binding.setCallback(cardClickCallback);

        return new CourseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {

        holder.binding.setCourse(mCourses.get(position));
        holder.binding.setAuthor(mAuthor.get((mCourses.get(position)).getIdAuthor().intValue()));
        holder.binding.setAuthorViewModel(authorListViewModel);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mCourses == null ? 0 : mCourses.size();
    }

    @Override
    public long getItemId(int position) {
        return mCourses.get(position).getId();
    }


    static class CourseViewHolder extends RecyclerView.ViewHolder{

        final CardCourseBinding binding;

        public CourseViewHolder(CardCourseBinding binding){
            super(binding.getRoot());

            this.binding = binding;
        }
    }

}

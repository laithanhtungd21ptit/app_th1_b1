package com.tuto.b2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {
    private List<Subject> subjects;

    public SubjectAdapter(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_subject, parent, false);
        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        Subject subject = subjects.get(position);
        holder.textViewSubjectName.setText(subject.getName());
        holder.textViewCredits.setText(String.valueOf(subject.getCredits()));
        holder.textViewScore.setText(String.valueOf(subject.getScore()));
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public static class SubjectViewHolder extends RecyclerView.ViewHolder {
        TextView textViewSubjectName, textViewCredits, textViewScore;

        public SubjectViewHolder(View itemView) {
            super(itemView);
            textViewSubjectName = itemView.findViewById(R.id.textViewSubjectName);
            textViewCredits = itemView.findViewById(R.id.textViewCredits);
            textViewScore = itemView.findViewById(R.id.textViewScore);
        }
    }
}

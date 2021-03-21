package com.example.workout_room_persistance.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workout_room_persistance.ExerciseListActivity;
import com.example.workout_room_persistance.R;
import com.example.workout_room_persistance.dialogs.ExerciseListDialog;
import com.example.workout_room_persistance.model.Exercise;
import com.example.workout_room_persistance.util.ExerciseInsertSaveInterface;

import java.util.ArrayList;

public class DialogExercisesListRecyclerAdapter extends RecyclerView.Adapter<DialogExercisesListRecyclerAdapter.ViewHolder> {

    private static final String TAG = "ExercisesRecyclerAdapter";

    private ArrayList <Exercise> mExercises;

    private OnDialogExerciseListener mOnDialogExerciseListener;

    private int focusedItem = 100;
    private boolean focusingItem = false;



    public DialogExercisesListRecyclerAdapter(ArrayList<Exercise> exercise, OnDialogExerciseListener onDialogExerciseListener) {
        this.mExercises = exercise;
        this.mOnDialogExerciseListener = onDialogExerciseListener;
    }

//    public DialogExercisesListRecyclerAdapter(ArrayList<Exercise> exercises, ExerciseListDialog exerciseListDialog) {
//
//    }

    // Needed Override methods for RecyclerView Adapter
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_exercise_list_item, parent, false);
        return new ViewHolder(view, mOnDialogExerciseListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.title.setText(mExercises.get(i).getTitle());
    }



    @Override
    public int getItemCount() {
        return mExercises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        OnDialogExerciseListener mOnDialogExerciseListener;

        public ViewHolder(@NonNull View itemView, OnDialogExerciseListener onDialogExerciseListener) {
            super(itemView);
            //Connect to (note list item) Layout
            title = itemView.findViewById(R.id.text_view_title);
            this.mOnDialogExerciseListener = onDialogExerciseListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (!focusingItem){
                itemView.setSelected(true);
                focusingItem = true;
                focusedItem = getLayoutPosition();
            }
            else if (focusedItem == getLayoutPosition()){
                itemView.setSelected(false);
                focusingItem = false;
            }
        }
    }

    //On click listener
    public interface OnDialogExerciseListener {
        void getDialogExerciseClicked(int position);
    }
}


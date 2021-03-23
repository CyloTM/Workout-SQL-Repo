package com.example.workout_room_persistance.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workout_room_persistance.R;
import com.example.workout_room_persistance.model.Exercise;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ExercisesRecyclerAdapter extends RecyclerView.Adapter<ExercisesRecyclerAdapter.ViewHolder>{

    private static final String TAG = "ExercisesRecyclerAdapter";

    private ArrayList <Exercise> mExercises;

    private OnExerciseListener mOnExerciseListener;

    private static final int EDIT_MODE_ENABLED = 1;
    private static final int EDIT_MODE_DISABLED = 0;
    private int mMode = EDIT_MODE_DISABLED;
    private int mFocusedItem;
    private boolean mFocusingItem = false;
    private Exercise current;

    private TextView repetitions;
    private EditText editTextRepetitions;

    public ExercisesRecyclerAdapter(ArrayList<Exercise> exercise, OnExerciseListener onExerciseListener) {
        this.mExercises = exercise;
        this.mOnExerciseListener = onExerciseListener;


    }

    // Needed Override methods for RecyclerView Adapter
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_exercise_list_item, parent, false);
        return new ViewHolder(view, mOnExerciseListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        int[] pos = {0};
        holder.title.setText(mExercises.get(i).getTitle());
        holder.repetitions.setText(mExercises.get(i).getRepetitions());
        holder.itemView.setOnClickListener(v -> {
            if(!mFocusingItem){
                holder.repetitions.setVisibility(View.GONE);
                holder.editTextRepetitions.setVisibility(View.VISIBLE);
//            editTextRepetitions.setFocusable(true);
//            editTextRepetitions.setFocusableInTouchMode(true);
                holder.editTextRepetitions.setCursorVisible(true);
                holder.editTextRepetitions.requestFocus();
                current = mExercises.get(i);
                pos[0] = (holder.getLayoutPosition());
                mOnExerciseListener.onExerciseClicked(holder.getLayoutPosition());
                mFocusingItem=true;

            }
            else if(mFocusingItem) {
                notifyItemChanged(pos[0]);
                Log.d(TAG, "current pos" + pos[0]);

                mFocusingItem = false;}
//            else if(holder.getLayoutPosition() != pos[0]) {
//                notifyItemChanged(pos[0]);
//                holder.disableRepetitionEditMode(current.getId());
//                holder.disableRepetitionEditMode(pos[0]);
//                if(holder.editTextRepetitions.getText().toString().equals("")){
//                    current.setRepetitions("0");
//                }
//                else{current.setRepetitions(holder.editTextRepetitions.getText().toString());}
//                Log.d(TAG, "disabled edit mode");
//                Log.d(TAG, "current =" + current.getTitle());
//                holder.repetitions.setVisibility(View.VISIBLE);
//                holder.editTextRepetitions.setVisibility(View.GONE);
////            editTextRepetitions.setFocusable(false);
////            editTextRepetitions.setFocusableInTouchMode(false);
//                holder.editTextRepetitions.setCursorVisible(false);
//                holder.editTextRepetitions.clearFocus();
//                mFocusingItem=false;
//            }
//

//            holder.itemView.setOnClickListener(v -> {
//                        if (mFocusingItem) {
////                int position = mOnExerciseListener.onExerciseClicked(holder.getLayoutPosition());
////                    holder.disableRepetitionEditMode(position);
////                    Log.d(TAG, "disabled edit mode");
//////                    repetitions.setVisibility(View.VISIBLE);
//////                    holder.editTextRepetitions.setVisibility(View.GONE);
//////                    holder.editTextRepetitions.setCursorVisible(false);
//////                    holder.editTextRepetitions.clearFocus();
////                    notifyDataSetChanged();
//                        }
//                    }
//            );
        });
    }

    public void enableRepetitionEditMode(){
        repetitions.setVisibility(View.GONE);
        editTextRepetitions.setVisibility(View.VISIBLE);
//            editTextRepetitions.setFocusable(true);
//            editTextRepetitions.setFocusableInTouchMode(true);
        editTextRepetitions.setCursorVisible(true);
        editTextRepetitions.requestFocus();

        mMode = EDIT_MODE_ENABLED;
    }

    public void disableRepetitionEditMode() {
        Exercise exercise = current;
        if(editTextRepetitions.getText().toString().equals("")){
            current.setRepetitions("0");
        }
        else{repetitions.setText(editTextRepetitions.getText().toString());}
        Log.d(TAG, "disabled edit mode");

        repetitions.setVisibility(View.VISIBLE);
        editTextRepetitions.setVisibility(View.GONE);
//            editTextRepetitions.setFocusable(false);
//            editTextRepetitions.setFocusableInTouchMode(false);
        editTextRepetitions.setCursorVisible(false);
        editTextRepetitions.clearFocus();
        mMode = EDIT_MODE_DISABLED;
        mFocusingItem=false;
    }



    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mExercises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, repetitions;
        EditText editTextRepetitions;
        OnExerciseListener mOnExerciseListener;

        public ViewHolder(@NonNull View itemView, OnExerciseListener onExerciseListener) {
            super(itemView);
            //Connect to (note list item) Layout
            title = itemView.findViewById(R.id.text_view_title);
            repetitions= itemView.findViewById(R.id.text_view_repetitions);
            editTextRepetitions= itemView.findViewById(R.id.edit_text_repetitions);
            this.mOnExerciseListener = onExerciseListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//
//            if(!mFocusingItem){
//                enableRepetitionEditMode();
//
//                mFocusingItem=true;
//
//            }
//            else if(mFocusingItem) {
//                disableRepetitionEditMode();
//                Log.d(TAG, "disabled oLD EDITMODE");
//
//            }
//            else {disableRepetitionEditMode();}
//
////            if (!focusingItem){
////                v.setSelected(true);
////                focusingItem = true;
////                focusedItem = getLayoutPosition();
////            }
////            else if (focusedItem == getLayoutPosition()){
////                v.setSelected(false);
////                focusingItem = false;
////            }

        }

        public void enableRepetitionEditMode(){
            repetitions.setVisibility(View.GONE);
            editTextRepetitions.setVisibility(View.VISIBLE);
//            editTextRepetitions.setFocusable(true);
//            editTextRepetitions.setFocusableInTouchMode(true);
            editTextRepetitions.setCursorVisible(true);
            editTextRepetitions.requestFocus();
            mFocusedItem = getLayoutPosition();

            mMode = EDIT_MODE_ENABLED;
        }

        public void disableRepetitionEditMode(int position) {
            current = mExercises.get(position);

            if(editTextRepetitions.getText().toString().equals("")){
//                current.setRepetitions("0");
                this.repetitions.setText("0");
            }
            else{this.repetitions.setText(editTextRepetitions.getText().toString());}
            Log.d(TAG, "disabled edit mode");

            this.repetitions.setVisibility(View.VISIBLE);
            this.editTextRepetitions.setVisibility(View.GONE);
//            editTextRepetitions.setFocusable(false);
//            editTextRepetitions.setFocusableInTouchMode(false);
            this.editTextRepetitions.setCursorVisible(false);
            this.editTextRepetitions.clearFocus();
            mMode = EDIT_MODE_DISABLED;
            mFocusingItem=false;
        }
    }

    //On click listener
    public interface OnExerciseListener {
        int onExerciseClicked(int position);
    }







}

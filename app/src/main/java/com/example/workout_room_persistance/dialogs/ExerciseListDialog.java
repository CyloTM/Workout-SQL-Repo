package com.example.workout_room_persistance.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workout_room_persistance.ExerciseInterface;
import com.example.workout_room_persistance.R;
import com.example.workout_room_persistance.adapter.DialogExercisesListRecyclerAdapter;
import com.example.workout_room_persistance.adapter.ExercisesRecyclerAdapter;
import com.example.workout_room_persistance.model.Exercise;
import com.example.workout_room_persistance.util.VerticalSpacingItemDecorator;

import java.util.ArrayList;

public class ExerciseListDialog extends AppCompatDialogFragment implements
        DialogExercisesListRecyclerAdapter.OnDialogExerciseListener
{

    public static final String TAG = "ExerciseListDialog";

    //UI
    private RecyclerView mRecyclerView;


    // Variables
    private ArrayList<Exercise> mExercises = new ArrayList();
    private DialogExercisesListRecyclerAdapter mExercisesRecyclerAdapter;
    public exerciseDialogListener dialogListener;
    public ExerciseInterface mExerciseInterface;
    public View v;
    AlertDialog.Builder builder;


    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);
        mExerciseInterface = (ExerciseInterface) context;
        try {
            dialogListener = (exerciseDialogListener) getTargetFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "implement the ting");
        }
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        v = inflater.inflate(R.layout.dialog_exercise_list, null);
        mRecyclerView = v.findViewById(R.id.recycler_view);
        builder = new AlertDialog.Builder(getActivity());
        builder.setView(v)
                .setTitle("Exercises")
                .setPositiveButton("ok", (dialog, which) -> {
//                    dialogListener.applyExercise(mExercises.get(position));
                    mExerciseInterface.saveNewExercise();

                    return;
                }).create();
        initRecyclerView();
        insertFakeExercises();
        return builder.show();

    }

    @Override
    public void getDialogExerciseClicked(int position) {
        Log.d(TAG, "onDoubleTab: double tapped!");
    }


    public interface exerciseDialogListener {
//        void applyExercise(String string);
//        void applyExercise(Exercise exercise);
    }

    public void insertFakeExercises(){
        for(int i = 0;i<20; i++){

            Exercise noteExercise = new Exercise();
            noteExercise.setTitle("Exercise #"+ i);
            noteExercise.setRepetitions(""+i);
            mExercises.add(noteExercise);
        }
        mExercisesRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView(){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);
        mExercisesRecyclerAdapter = new DialogExercisesListRecyclerAdapter(mExercises, this);
        mRecyclerView.setAdapter(mExercisesRecyclerAdapter);
    }

//    public void saveData(){
//        SharedPreferences sharedPreferences = getActivity().getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        return;
//    }

}

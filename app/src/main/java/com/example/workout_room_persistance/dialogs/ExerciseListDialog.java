package com.example.workout_room_persistance.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workout_room_persistance.R;
import com.example.workout_room_persistance.adapter.ExercisesRecyclerAdapter;
import com.example.workout_room_persistance.model.Exercise;
import com.example.workout_room_persistance.util.VerticalSpacingItemDecorator;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class ExerciseListDialog extends AppCompatDialogFragment implements
        ExercisesRecyclerAdapter.OnExerciseListener
{



    public static final String TAG = "ExerciseListDialog";

    //UI
    private RecyclerView mRecyclerView;


    // Variables
    private ArrayList<Exercise> mExercises = new ArrayList();
    private ExercisesRecyclerAdapter mExercisesRecyclerAdapter;
    public exerciseDialogListener dialogListener;
    public Activity activity;
    public Dialog dialog;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter adapter;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            dialogListener = (exerciseDialogListener) getTargetFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "implement the ting");
        }
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_exercise_list, null);
        mRecyclerView = v.findViewById(R.id.recycler_view);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v)
                .setTitle("Exercises").create();
        initRecyclerView();
        insertFakeExercises();
        return builder.show();
    }

    @Override
    public void onExerciseClicked(int position) {

    }

    public interface exerciseDialogListener {
        void applyExercise(Exercise exercise);
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
        mExercisesRecyclerAdapter = new ExercisesRecyclerAdapter(mExercises, this);
        mRecyclerView.setAdapter(mExercisesRecyclerAdapter);

    }

//    public void saveData(){
//        SharedPreferences sharedPreferences = getActivity().getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        return;
//    }

}

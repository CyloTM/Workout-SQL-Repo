package com.example.workout_room_persistance.async;

import android.os.AsyncTask;

import com.example.workout_room_persistance.model.Exercise;
import com.example.workout_room_persistance.persistance.ExerciseDao;
import com.example.workout_room_persistance.persistance.WorkoutDao;

public class ExerciseInsertAsyncTask extends AsyncTask<Exercise, Void, Void> {

    private ExerciseDao mExerciseDao;

    private WorkoutDao mWorkoutDao;
//    public ExerciseInsertAsyncTask(ExerciseDao dao) {
//        mExerciseDao = dao;
//
//    }

    public ExerciseInsertAsyncTask(WorkoutDao dao) {
        mWorkoutDao = dao;
    }

    @Override
    protected Void doInBackground(Exercise... exercise) {
        mWorkoutDao.insertExercise(exercise);
        return null;
    }
}

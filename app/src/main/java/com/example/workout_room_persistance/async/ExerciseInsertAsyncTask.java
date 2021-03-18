package com.example.workout_room_persistance.async;

import android.os.AsyncTask;

import com.example.workout_room_persistance.model.Exercise;
import com.example.workout_room_persistance.persistance.ExerciseDao;

public class ExerciseInsertAsyncTask extends AsyncTask<Exercise, Void, Void> {

    private ExerciseDao mExerciseDao;
    public ExerciseInsertAsyncTask(ExerciseDao dao) {
        mExerciseDao = dao;

    }

    @Override
    protected Void doInBackground(Exercise... workouts) {
        mExerciseDao.insertExercise(workouts);
        return null;
    }
}

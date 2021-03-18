package com.example.workout_room_persistance.async;

import android.os.AsyncTask;

import com.example.workout_room_persistance.model.Exercise;
import com.example.workout_room_persistance.model.Workout;
import com.example.workout_room_persistance.persistance.ExerciseDao;
import com.example.workout_room_persistance.persistance.WorkoutDao;

public class ExerciseDeleteAsyncTask extends AsyncTask<Exercise, Void, Void> {

    private ExerciseDao mExerciseDao;
    public ExerciseDeleteAsyncTask(ExerciseDao dao) {
        mExerciseDao = dao;
    }

    @Override
    protected Void doInBackground(Exercise... workouts) {
        mExerciseDao.delete(workouts);
        return null;
    }
}

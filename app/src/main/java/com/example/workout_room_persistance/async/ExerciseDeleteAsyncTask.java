package com.example.workout_room_persistance.async;

import android.os.AsyncTask;

import com.example.workout_room_persistance.model.Exercise;
import com.example.workout_room_persistance.persistance.WorkoutDao;

public class ExerciseDeleteAsyncTask extends AsyncTask<Exercise, Void, Void> {

    private WorkoutDao mWorkoutDao;
    public ExerciseDeleteAsyncTask(WorkoutDao dao) {
        mWorkoutDao = dao;
    }
    @Override
    protected Void doInBackground(Exercise... workouts) {
        mWorkoutDao.delete(workouts);
        return null;
    }
}
